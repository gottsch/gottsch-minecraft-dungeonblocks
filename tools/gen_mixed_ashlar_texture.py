"""
Generates mixed_ashlar.png: a floor of squared stones of mixed sizes - one large stone two courses
tall, a long one, and smaller ones packed round them - in one 16px block that repeats.

This is the one-block form of the mixed ashlar on the 3.3 list. The full idea had stones of 2x1
and 2x2 blocks, which need a pattern-tile block; here the largest stone is 8x9 px. The layout wraps
round the tile's edges (stones cross them), so a floor shows no joint along every block edge, only
the 16px repeat. Two courses of joints run the full width; the rest break joint.

Each stone is cut from vanilla's stone texture at its own offset, its grain halved, shaded a little lighter or darker
than its neighbours, with a 1px highlight along its top and left edges and a shadow along its
bottom and right, as vanilla's stone bricks are dressed. A stone's mortar is its last column and
row, so every joint is 1px; mortar shades are stone bricks' own.

Hand edits to the generated PNG will be overwritten. Run from the repo root:
    python tools/gen_mixed_ashlar_texture.py
"""
import io
import os
import random
import zipfile

from PIL import Image

TEX = "src/main/resources/assets/dungeonblocks/textures/block/"
VANILLA_JAR = os.path.expanduser(
    "~/.gradle/caches/forge_gradle/minecraft_repo/versions/1.20.1/client-extra.jar")
SIZE = 16

# (x, y, w, h) with the 1px mortar included on the right and bottom; x and y wrap round the tile
STONES = [
    (0, 0, 10, 7),     # the long stone
    (10, 0, 6, 7),
    (6, 7, 8, 9),      # the large stone, two courses tall
    (14, 7, 8, 4),     # crosses the tile's east edge
    (14, 11, 4, 5),
    (2, 11, 4, 5),
]
# each stone's shade: a little lighter or darker than plain stone, so the sizes read
SHADES = [6, -4, 2, -8, 10, -2]


def vanilla(z, name):
    return Image.open(io.BytesIO(z.read(f"assets/minecraft/textures/block/{name}.png"))).convert("RGB")


def clamp(c):
    return max(0, min(255, c))


def tint(rgb, d):
    return tuple(clamp(c + d) for c in rgb)


def main():
    with zipfile.ZipFile(VANILLA_JAR) as z:
        stone = vanilla(z, "stone")
        bricks = vanilla(z, "stone_bricks")
    # stone bricks' mortar: its darkest pixels, which is what its joints are
    pixels = sorted({bricks.getpixel((x, y)) for x in range(SIZE) for y in range(SIZE)}, key=sum)
    mortar = pixels[:2]
    mean = tuple(sum(stone.getpixel((x, y))[i] for x in range(SIZE) for y in range(SIZE)) // (SIZE * SIZE)
                 for i in range(3))

    rnd = random.Random(7)
    out = Image.new("RGB", (SIZE, SIZE))
    covered = set()
    for (sx, sy, w, h), shade in zip(STONES, SHADES):
        ox, oy = rnd.randrange(SIZE), rnd.randrange(SIZE)
        for dy in range(h):
            for dx in range(w):
                x, y = (sx + dx) % SIZE, (sy + dy) % SIZE
                assert (x, y) not in covered, f"stones overlap at {x}, {y}"
                covered.add((x, y))
                if dx == w - 1 or dy == h - 1:
                    out.putpixel((x, y), rnd.choice(mortar))
                    continue
                # half of stone's grain: at full strength it buries the joints
                grain = stone.getpixel(((ox + dx) % SIZE, (oy + dy) % SIZE))
                colour = tuple(clamp(m + (g - m) // 2 + shade) for g, m in zip(grain, mean))
                if dx == 0 or dy == 0:
                    colour = tint(colour, 14)
                elif dx == w - 2 or dy == h - 2:
                    colour = tint(colour, -14)
                out.putpixel((x, y), colour)
    assert len(covered) == SIZE * SIZE, f"stones leave {SIZE * SIZE - len(covered)} px uncovered"
    out.save(TEX + "mixed_ashlar.png")


if __name__ == "__main__":
    main()
