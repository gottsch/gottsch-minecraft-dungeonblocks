"""
Generates the mossy siblings of vanilla deepslate_bricks, deepslate_tiles and cobbled_deepslate.

Vanilla ships no mossy deepslate of any kind, so these are authored -- but not freehand. The moss
is lifted straight off vanilla's own mossy pairs: for a given vanilla (base, mossy) pair, every
pixel whose mossy value is green is recorded with its exact colour, giving a mask that carries
vanilla's clump shapes AND vanilla's moss palette. That mask is then stamped onto the deepslate
base. The mod's existing moss palette is vanilla's moss palette, so this lands on the same green
the stone, mud and clay bricks already use -- which is the point: moss is the same colour whatever
it grows on (see the deepslate brick retone notes -- moss is never darkened to match its host).

Mask sources are chosen by geometry:
  deepslate_bricks   <- stone_bricks  (rectilinear, mortar courses)
  deepslate_tiles    <- stone_bricks, mirrored -- same structure, but mirroring keeps the tiles
                        from carrying a pixel-identical moss pattern to the bricks, which shows
                        immediately when the two are placed side by side
  cobbled_deepslate  <- cobblestone   (lumpy, much heavier coverage: 146/256 vs 98/256)

Deepslate's identity is its darkness rather than a hue, so unlike the andesite case there is no
shade class that needs protecting from the mask -- it is applied 1:1 with no thinning.

Vanilla sources are read from the ForgeGradle client-extra jar; the mod ships only the results.
Hand edits to the generated PNGs will be overwritten. Run from the repo root:
    python tools/gen_mossy_deepslate_textures.py
"""
import io
import os
import zipfile

from PIL import Image

TEX = "src/main/resources/assets/dungeonblocks/textures/block/"
VANILLA_JAR = os.path.expanduser(
    "~/.gradle/caches/forge_gradle/minecraft_repo/versions/1.20.1/client-extra.jar")

# (base, mossy mask source, mirror the mask?, output name)
JOBS = [
    ("deepslate_bricks",  ("stone_bricks", "mossy_stone_bricks"), False, "mossy_deepslate_bricks"),
    ("deepslate_tiles",   ("stone_bricks", "mossy_stone_bricks"), True,  "mossy_deepslate_tiles"),
    ("cobbled_deepslate", ("cobblestone", "mossy_cobblestone"),   False, "mossy_cobbled_deepslate"),
]

_jar = None


def vanilla(name):
    global _jar
    if _jar is None:
        if not os.path.exists(VANILLA_JAR):
            raise SystemExit(
                f"vanilla jar not found at {VANILLA_JAR}\n"
                "run a gradle task once to populate the ForgeGradle minecraft_repo cache")
        _jar = zipfile.ZipFile(VANILLA_JAR)
    data = _jar.read(f"assets/minecraft/textures/block/{name}.png")
    return Image.open(io.BytesIO(data)).convert("RGBA")


def is_moss(px):
    """Green pixels only -- vanilla also nudges a few greys between a base and its mossy twin,
    and those must not travel onto a palette they were never sampled from."""
    r, g, b, _ = px
    return g > r and g > b


def moss_mask(base_name, mossy_name, mirror):
    base, mossy = vanilla(base_name), vanilla(mossy_name)
    w, h = base.size
    if mirror:
        mossy = mossy.transpose(Image.FLIP_LEFT_RIGHT)
        base = base.transpose(Image.FLIP_LEFT_RIGHT)
    b, m = list(base.getdata()), list(mossy.getdata())
    return {i: m[i] for i in range(w * h) if b[i] != m[i] and is_moss(m[i])}


for base_name, (mask_base, mask_mossy), mirror, out_name in JOBS:
    base = vanilla(base_name)
    mask = moss_mask(mask_base, mask_mossy, mirror)
    px = list(base.getdata())
    for i, colour in mask.items():
        px[i] = colour
    out = Image.new("RGBA", base.size)
    out.putdata(px)
    out.save(TEX + out_name + ".png")
    print(f"{base_name} + {mask_mossy}{' (mirrored)' if mirror else ''} "
          f"-> {out_name}.png  ({len(mask)}/{base.size[0] * base.size[1]} px mossed)")
