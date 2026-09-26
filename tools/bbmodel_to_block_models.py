"""
Builds block model JSONs from the Blockbench projects in blockbench/.

THE .bbmodel FILES ARE THE SOURCE. Edit a model in Blockbench, save the .bbmodel, and run this
script from the repo root; never hand-edit its output, which is overwritten on every run.
    python tools/bbmodel_to_block_models.py

WHY NOT BLOCKBENCH'S OWN EXPORT
-------------------------------
One Blockbench project here usually becomes several game models, which a plain export cannot do:
- VARIANTS: a model's element groups are switched on per output - the iron maiden's
  `doors_closed` and `doors_open` groups become its closed and open models.
- SPLITS: the sarcophagus `lid` group is written on its own, for the renderer that always draws
  the lid, and the body without it; plus both together, closed, for the item.
One project per BLOCK of a multi-block object: Blockbench's java_block format only allows
elements within -16..32, so a 3-tall gibbet cannot be one project.

CONVERSION RULES
----------------
- A face's texture becomes "#<the Blockbench texture's name>", so a texture's NAME in Blockbench
  is the model's texture key (side, lid, effigy, body, cage, bone). The value each key
  gets is set in JOBS below - and per material in datagen, for the sarcophagus.
- UVs are converted from each texture's own UV size to Minecraft's 0-16 space, so a non-16
  texture such as the 64x32 skeleton mob texture maps correctly.
- Any unrotated face lying flush on a block boundary gets the matching cullface. A flush face
  without one renders black against a solid neighbour.
- An element may rotate on ONE axis, by a multiple of 22.5 degrees up to 45: the JSON format's
  limit. The script stops with an error rather than export something the game will reject.
"""
import json
import os

SRC = "blockbench/"
OUT = "src/main/resources/assets/dungeonblocks/models/block/"

STONE = {"side": "minecraft:block/chiseled_stone_bricks", "lid": "minecraft:block/smooth_stone",
         "effigy": "minecraft:block/polished_andesite"}
IRON = {"body": "dungeonblocks:block/dark_iron"}
CAGE = {"cage": "dungeonblocks:block/dark_iron", "bone": "minecraft:entity/skeleton/skeleton",
        "chain": "minecraft:block/chain"}
# the campfire's own 4x4 log texture: bark strip in rows 0-4, cut end at [0,4,4,8]
FIREWOOD = {"log": "minecraft:block/campfire_log", "frame": "dungeonblocks:block/dark_iron"}
RACK = {"frame": "dungeonblocks:block/dark_iron", "sword": "minecraft:item/iron_sword",
        "axe": "minecraft:item/iron_axe"}

JOBS = []
for part in ("head", "foot"):
    # the block shows `body`; SarcophagusRenderer always draws `lid` (sliding it open by its
    # OPEN_SLIDE); `closed` is both together, for the item
    JOBS.append((f"sarcophagus_{part}", f"template_sarcophagus_{part}_closed", STONE, {"body": (0, 0, 0), "lid": (0, 0, 0)}))
    JOBS.append((f"sarcophagus_{part}", f"template_sarcophagus_{part}_body", STONE, {"body": (0, 0, 0)}))
    JOBS.append((f"sarcophagus_{part}", f"template_sarcophagus_{part}_lid", STONE, {"lid": (0, 0, 0)}))
for half in ("lower", "upper"):
    for state in ("closed", "open"):
        JOBS.append((f"iron_maiden_{half}", f"iron_maiden_{half}_{state}", IRON,
                     {"body": (0, 0, 0), f"doors_{state}": (0, 0, 0)}))
for part in ("bottom", "middle", "top"):
    JOBS.append((f"gibbet_{part}", f"gibbet_{part}", CAGE,
                 {"cage": (0, 0, 0), "skeleton": (0, 0, 0), "chain": (0, 0, 0)}))
# one model per fill stage: firewood_rack_N is the frame and log groups logs_1..logs_N, two logs
# each; firewood_rack_4, the full rack, is also the item's model
for n in range(5):
    JOBS.append(("firewood_rack", f"firewood_rack_{n}", FIREWOOD,
                 {"frame": (0, 0, 0), **{f"logs_{i}": (0, 0, 0) for i in range(1, n + 1)}}))
# the block is the frame only: WeaponRackRenderer draws whatever is racked, from the block entity.
# The item, which has no renderer, shows the `display` sword and axe (item sprites are on the
# block atlas) so the icon reads as a weapon rack rather than an empty frame.
JOBS.append(("weapon_rack", "weapon_rack", RACK, {"frame": (0, 0, 0)}))
JOBS.append(("weapon_rack", "weapon_rack_item", RACK, {"frame": (0, 0, 0), "display": (0, 0, 0)}))

# models whose textures have see-through pixels: the skeleton's ribs, the chain's links. Without
# cutout those pixels draw black.
CUTOUT = ("gibbet_",)

BOUNDARY = {"north": (2, 0, "from"), "south": (2, 16, "to"), "west": (0, 0, "from"),
            "east": (0, 16, "to"), "down": (1, 0, "from"), "up": (1, 16, "to")}


def convert(project, groups, textures):
    tex = project["textures"]
    by_uuid = {e["uuid"]: e for e in project["elements"]}
    elements = []
    for group in project["outliner"]:
        if group["name"] not in groups:
            continue
        dx, dy, dz = groups[group["name"]]
        for uid in group["children"]:
            e = by_uuid[uid]
            frm = [e["from"][0] + dx, e["from"][1] + dy, e["from"][2] + dz]
            to = [e["to"][0] + dx, e["to"][1] + dy, e["to"][2] + dz]
            out = {"name": e["name"], "from": frm, "to": to, "faces": {}}
            angles = [a for a in e.get("rotation", [0, 0, 0])]
            turned = [i for i, a in enumerate(angles) if a]
            if len(turned) > 1:
                raise SystemExit(f"{e['name']}: rotated on more than one axis")
            if turned:
                a = angles[turned[0]]
                if a not in (-45, -22.5, 22.5, 45):
                    raise SystemExit(f"{e['name']}: rotation {a} is not a JSON-legal angle")
                o = e["origin"]
                out["rotation"] = {"angle": a, "axis": "xyz"[turned[0]], "origin": [o[0] + dx, o[1] + dy, o[2] + dz]}
            for name, face in e["faces"].items():
                if face.get("texture") is None:
                    continue
                t = tex[face["texture"]]
                su, sv = 16 / t.get("uv_width", 16), 16 / t.get("uv_height", 16)
                u0, v0, u1, v1 = face["uv"]
                f = {"uv": [round(u0 * su, 4), round(v0 * sv, 4), round(u1 * su, 4), round(v1 * sv, 4)],
                     "texture": "#" + t["name"]}
                if face.get("rotation"):
                    f["rotation"] = face["rotation"]
                axis, plane, side = BOUNDARY[name]
                if not turned and (frm if side == "from" else to)[axis] == plane:
                    f["cullface"] = name
                out["faces"][name] = f
            elements.append(out)
    keys = sorted({t["name"] for t in tex})
    model = {"parent": "block/block",
             "textures": {**{k: textures[k] for k in keys}, "particle": textures[tex[0]["name"]]},
             "elements": elements}
    return model


def render_type(name):
    return "minecraft:cutout" if name.startswith(CUTOUT) else None


def main():
    for source, name, textures, groups in JOBS:
        project = json.load(open(SRC + source + ".bbmodel"))
        model = convert(project, groups, textures)
        if render_type(name):
            model = {"parent": model["parent"], "render_type": render_type(name), **{k: v for k, v in model.items() if k != "parent"}}
        json.dump(model, open(OUT + name + ".json", "w", newline="\n"), indent=2)
        print(f"{source}.bbmodel -> {name}.json ({len(model['elements'])} elements)")


if __name__ == "__main__":
    main()
