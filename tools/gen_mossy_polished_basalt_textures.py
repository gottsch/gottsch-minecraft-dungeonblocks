"""
Generates the mossy sibling of vanilla polished basalt (top and side).

Same method as tools/gen_mossy_deepslate_textures.py: the moss is lifted off vanilla's own
stone_bricks -> mossy_stone_bricks pair, keeping both vanilla's clump shapes and vanilla's moss
green (which is the green every mossy texture in this mod already uses), then stamped onto the
basalt palette. Moss is never re-toned to match the stone it grows on.

The one thing specific to basalt: its identity is the cool dark blue-grey VERTICAL STRIATIONS,
not its overall brightness. Stamping the mask 1:1 buries them and the result reads as generic
mossy grey stone, so moss is held off those shade classes entirely -- it settles on the lighter
grey between the stripes instead, and a stacked column still reads as basalt. This is the
"check which shade class carries the identity before borrowing a moss mask" case.

Vanilla sources are read from the ForgeGradle client-extra jar; the mod ships only the results.
Hand edits to the generated PNGs will be overwritten. Run from the repo root:
    python tools/gen_mossy_polished_basalt_textures.py
"""
import io
import os
import zipfile

from PIL import Image

TEX = "src/main/resources/assets/dungeonblocks/textures/block/"
VANILLA_JAR = os.path.expanduser(
    "~/.gradle/caches/forge_gradle/minecraft_repo/versions/1.20.1/client-extra.jar")

# the cool dark striation classes of polished basalt, top and side, which moss must not cover
IDENTITY = {(58, 59, 72, 255), (50, 51, 61, 255), (27, 38, 50, 255),
            (61, 62, 76, 255), (53, 54, 65, 255)}

PAIRS = [("polished_basalt_side", "mossy_polished_basalt_side"),
         ("polished_basalt_top", "mossy_polished_basalt_top")]

_jar = None


def vanilla(name):
    global _jar
    if _jar is None:
        if not os.path.exists(VANILLA_JAR):
            raise SystemExit(
                f"vanilla jar not found at {VANILLA_JAR}\n"
                "run a gradle task once to populate the ForgeGradle minecraft_repo cache")
        _jar = zipfile.ZipFile(VANILLA_JAR)
    return Image.open(io.BytesIO(_jar.read(
        f"assets/minecraft/textures/block/{name}.png"))).convert("RGBA")


def moss_mask():
    """Green-only diff of a vanilla base/mossy pair. Green-only because vanilla also nudges a few
    greys between the two, and those must not travel onto a palette they were never sampled from."""
    base = list(vanilla("stone_bricks").getdata())
    mossy = list(vanilla("mossy_stone_bricks").getdata())
    return {i: mossy[i] for i in range(len(base))
            if base[i] != mossy[i] and mossy[i][1] > mossy[i][0] and mossy[i][1] > mossy[i][2]}


def main():
    mask = moss_mask()
    for src, dst in PAIRS:
        base = vanilla(src)
        px = list(base.getdata())
        applied = 0
        for i, colour in mask.items():
            if px[i] in IDENTITY:
                continue
            px[i] = colour
            applied += 1
        img = Image.new("RGBA", base.size)
        img.putdata(px)
        img.save(TEX + dst + ".png")
        print(f"{src}.png -> {dst}.png  ({applied}/{base.size[0] * base.size[1]} px mossed, "
              f"{len(mask) - applied} held off the striations)")


if __name__ == "__main__":
    main()
