"""
Rough software preview of the mod's block models, with real textures, for judging a shape or a
texture ON THE MODEL before showing the user - a flat 16x16 swatch is not enough.

Not the game's lighting: one directional light, no ambient occlusion. Good for shape, proportion,
UV mapping and texture choice; confirm brightness in game.

Run from the repo root (it reads tools/gen_obj_models.py, the client-extra jar and the mod's
textures). Example:
    import sys; sys.path.insert(0, ".claude/skills/dungeonblocks-block-variant/scripts")
    from preview import tex, cube, load_obj, load_json, render
    f = load_json("gibbet_bottom", yrot=180) + load_json("gibbet_middle", (0, 1, 0), yrot=180)
    f += cube(tex("stone_bricks"), tex("stone_bricks"), (0, -1, 0))
    render(f, "out.png", centre=(0.5, 1, 0.5), scale=150)

tex("stone_bricks") is minecraft:block/stone_bricks; tex("dungeonblocks:block/dark_iron") a mod
texture; tex("minecraft:entity/skeleton/skeleton") any other vanilla texture. Models authored
facing north are seen from the front with yrot=180.
"""
import io, os, zipfile, math
from PIL import Image

JAR = zipfile.ZipFile(os.path.expanduser(
    "~/.gradle/caches/forge_gradle/minecraft_repo/versions/1.20.1/client-extra.jar"))
MOD = "src/main/resources/assets/dungeonblocks/textures/"
OBJ = "src/main/resources/assets/dungeonblocks/models/block/"


def tex(name):
    ns, path = name.split(":") if ":" in name else ("minecraft", "block/" + name)
    if ns == "minecraft":
        return Image.open(io.BytesIO(JAR.read(f"assets/minecraft/textures/{path}.png"))).convert("RGBA")
    return Image.open(MOD + path + ".png").convert("RGBA")


def load_obj(name, textures, offset=(0, 0, 0), yrot=0):
    V, VT, F = [], [], []
    mat = None
    for line in open(OBJ + name + ".obj"):
        p = line.split()
        if not p or p[0].startswith("#"):
            continue
        if p[0] == "v":
            V.append([float(x) for x in p[1:]])
        elif p[0] == "vt":
            VT.append([float(x) for x in p[1:]])
        elif p[0] == "usemtl":
            mat = p[1]
        elif p[0] == "f":
            idx = [q.split("/") for q in p[1:]]
            pts = []
            for a, _, _ in idx:
                x, y, z = V[int(a) - 1]
                if yrot:   # rotate about block centre, like a blockstate y rotation
                    r = math.radians(yrot)
                    x, z = 0.5 + (x - .5) * math.cos(r) - (z - .5) * math.sin(r), 0.5 + (x - .5) * math.sin(r) + (z - .5) * math.cos(r)
                pts.append((x + offset[0], y + offset[1], z + offset[2]))
            F.append((textures[mat], pts, [(VT[int(b) - 1][0], 1 - VT[int(b) - 1][1]) for _, b, _ in idx]))
    return F


def cube(t_side, t_top, offset):
    x, y, z = offset
    F = []
    for quad in ([(0, 1, 1), (0, 0, 1), (1, 0, 1), (1, 1, 1)], [(1, 1, 1), (1, 0, 1), (1, 0, 0), (1, 1, 0)],
                 [(1, 1, 0), (1, 0, 0), (0, 0, 0), (0, 1, 0)], [(0, 1, 0), (0, 0, 0), (0, 0, 1), (0, 1, 1)]):
        F.append((t_side, [(a + x, b + y, c + z) for a, b, c in quad], [(0, 0), (0, 1), (1, 1), (1, 0)]))
    F.append((t_top, [(x, y + 1, z), (x, y + 1, z + 1), (x + 1, y + 1, z + 1), (x + 1, y + 1, z)],
              [(0, 0), (0, 1), (1, 1), (1, 0)]))
    return F


def render(faces, path, yaw=35, pitch=28, scale=260, size=(520, 600), centre=(0.5, 0.6, 0.5),
           bg=(135, 170, 215, 255)):
    W, H = size
    yaw, pitch = math.radians(yaw), math.radians(pitch)

    def proj(p):
        x, y, z = p[0] - centre[0], p[1] - centre[1], p[2] - centre[2]
        x, z = x * math.cos(yaw) - z * math.sin(yaw), x * math.sin(yaw) + z * math.cos(yaw)
        y, z = y * math.cos(pitch) - z * math.sin(pitch), y * math.sin(pitch) + z * math.cos(pitch)
        return (W / 2 + x * scale, H / 2 - y * scale, z)

    img = Image.new("RGBA", (W, H), bg)
    zb = [[-1e9] * W for _ in range(H)]
    px = img.load()
    light = (0.35, 0.85, 0.55)
    l = math.sqrt(sum(c * c for c in light))
    light = [c / l for c in light]

    def tri(t, P, UV):
        a, b, c = [proj(p) for p in P]
        area = (b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1])
        if area >= 0:
            return
        n = [P[1][i] - P[0][i] for i in range(3)]
        m = [P[2][i] - P[0][i] for i in range(3)]
        nn = (n[1] * m[2] - n[2] * m[1], n[2] * m[0] - n[0] * m[2], n[0] * m[1] - n[1] * m[0])
        ln = math.sqrt(sum(q * q for q in nn)) or 1
        shade = 0.55 + 0.45 * max(0, sum(nn[i] / ln * light[i] for i in range(3)))
        xs = [a[0], b[0], c[0]]
        ys = [a[1], b[1], c[1]]
        for y in range(max(0, int(min(ys))), min(H, int(max(ys)) + 1)):
            for x in range(max(0, int(min(xs))), min(W, int(max(xs)) + 1)):
                w0 = ((b[0] - x) * (c[1] - y) - (c[0] - x) * (b[1] - y)) / area
                w1 = ((c[0] - x) * (a[1] - y) - (a[0] - x) * (c[1] - y)) / area
                w2 = 1 - w0 - w1
                if min(w0, w1, w2) < 0:
                    continue
                z = w0 * a[2] + w1 * b[2] + w2 * c[2]
                if z < zb[y][x]:
                    continue
                u = w0 * UV[0][0] + w1 * UV[1][0] + w2 * UV[2][0]
                v = w0 * UV[0][1] + w1 * UV[1][1] + w2 * UV[2][1]
                tw, th = t.size
                col = t.getpixel((min(tw - 1, max(0, int(u * tw))), min(th - 1, max(0, int(v * th)))))
                if col[3] < 128:
                    continue
                zb[y][x] = z
                px[x, y] = tuple(int(ch * shade) for ch in col[:3]) + (255,)

    for t, P, UV in faces:
        for k in range(1, len(P) - 1):
            tri(t, [P[0], P[k], P[k + 1]], [UV[0], UV[k], UV[k + 1]])
    img.save(path)


def load_json(name, offset=(0, 0, 0), yrot=0, textures=None):
    """A block model JSON from the mod's models/block, drawn from its own elements."""
    import json, sys
    sys.path.insert(0, "tools")
    import gen_obj_models as g
    m = json.load(open(OBJ + name + ".json"))
    tx = dict(m.get("textures", {}))
    if textures:
        tx.update(textures)
    cache = {}
    F = []
    for e in m["elements"]:
        faces = g.box(tuple(e["from"]), tuple(e["to"]), "x")
        names = {(0, -1, 0): "down", (0, 1, 0): "up", (0, 0, -1): "north", (0, 0, 1): "south",
                 (-1, 0, 0): "west", (1, 0, 0): "east"}
        keep = []
        for f in faces:
            n = names[tuple(int(round(c)) for c in f.normal)]
            if n not in e["faces"]:
                continue
            fd = e["faces"][n]
            u0, v0, u1, v1 = fd["uv"]
            f.uvs = [(u0, v0), (u0, v1), (u1, v1), (u1, v0)]
            f.material = fd["texture"].lstrip("#")
            keep.append(f)
        if "rotation" in e:
            r = e["rotation"]
            keep = g.rotate(keep, r["axis"], r["angle"], tuple(r["origin"]))
        for f in keep:
            key = f.material
            ref = tx[key]
            while ref.startswith("#"):
                ref = tx[ref[1:]]
            if ref not in cache:
                cache[ref] = tex(ref if ":" in ref else "minecraft:" + ref)
            pts = []
            for v in f.verts:
                x, y, z = v[0] / 16, v[1] / 16, v[2] / 16
                if yrot:
                    r_ = math.radians(yrot)
                    x, z = 0.5 + (x - .5) * math.cos(r_) - (z - .5) * math.sin(r_), 0.5 + (x - .5) * math.sin(r_) + (z - .5) * math.cos(r_)
                pts.append((x + offset[0], y + offset[1], z + offset[2]))
            F.append((cache[ref], pts, [(u / 16, w / 16) for u, w in f.uvs]))
    return F
