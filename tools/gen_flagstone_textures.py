"""
Generates the PLACEHOLDER flagstone floor textures: one 48x48 pattern of irregular flagstones,
whose joints cross block edges, cut into nine 16x16 tiles.

    python tools/gen_flagstone_textures.py

Run from the repo root. Writes textures/block/flagstones_<tile>.png for tile 0-8, where tile is
col + 3 * row of the 48x48 sheet - the value FlagstoneBlock's TILE takes from a position:
col = x mod 3, row = z mod 3. A block's top face shows its tile with the sheet's right toward +x
(east) and its bottom toward +z (south), the way a top face's default UV lies.

METHOD
------
The stones are a Voronoi pattern on a 48x48 torus: seeds scattered at random, no two closer than
SPACING, each with a weight that grows or shrinks its stone, so big slabs sit among small fillers.
(Seeds on a jittered grid came out as a honeycomb of near-equal hexagons.)
Distances wrap at the edges, so the sheet tiles seamlessly in both directions and a 3x3 repeat has
no seam of its own. A pixel is mortar where its nearest two seeds are close to equidistant. Stone
pixels take vanilla stone_bricks' greys: a tone per stone, mottled, lit along its top and left edge
and shadowed along its bottom and right, so each stone reads as a slab set in the mortar.

Deterministic (a fixed seed): re-running gives the same files. Hand edits are overwritten, so
change this script instead.
"""
import math
import random

from PIL import Image

OUT = "src/main/resources/assets/dungeonblocks/textures/block/"
SIZE = 48
TILE = 16

# vanilla stone_bricks.png, darkest to brightest; the mortar is its two darkest
GREYS = [(104, 104, 104), (116, 116, 116), (127, 127, 127), (139, 137, 139), (156, 153, 156)]
MORTAR = [(90, 89, 90), (99, 99, 99)]

STONES = 11       # seeds on the sheet: about one slab and a filler per block
SPACING = 10.0    # px, the least distance between two seeds
WEIGHT = 3.5      # px a seed's stone may grow or shrink by
JOINT = 1.4       # mortar where the nearest two seeds' (weighted) distances differ by less


def wrapped(a, b):
    d = abs(a - b) % SIZE
    return min(d, SIZE - d)


def main():
    rng = random.Random(4807)
    seeds = []
    while len(seeds) < STONES:
        x, y = rng.uniform(0, SIZE), rng.uniform(0, SIZE)
        if all(math.hypot(wrapped(x, sx), wrapped(y, sy)) >= SPACING for sx, sy, _, _ in seeds):
            seeds.append((x, y, rng.uniform(-WEIGHT, WEIGHT), rng.choice((1, 2, 2, 3))))

    owner = {}
    mortar = set()
    for y in range(SIZE):
        for x in range(SIZE):
            d = sorted((math.hypot(wrapped(x + 0.5, sx), wrapped(y + 0.5, sy)) - w, i)
                       for i, (sx, sy, w, _) in enumerate(seeds))
            owner[x, y] = d[0][1]
            if d[1][0] - d[0][0] < JOINT:
                mortar.add((x, y))

    def is_mortar(x, y):
        return (x % SIZE, y % SIZE) in mortar

    sheet = Image.new("RGBA", (SIZE, SIZE))
    for y in range(SIZE):
        for x in range(SIZE):
            if (x, y) in mortar:
                sheet.putpixel((x, y), rng.choice(MORTAR))
                continue
            shade = seeds[owner[x, y]][3]
            r = rng.random()
            shade += -1 if r < 0.2 else (1 if r > 0.85 else 0)
            # a slab's edges: lit where the joint is above or to the left, shadowed below or right
            if is_mortar(x, y - 1) or is_mortar(x - 1, y):
                shade += 1
            elif is_mortar(x, y + 1) or is_mortar(x + 1, y):
                shade -= 1
            sheet.putpixel((x, y), GREYS[max(0, min(len(GREYS) - 1, shade))])

    for row in range(3):
        for col in range(3):
            tile = sheet.crop((col * TILE, row * TILE, (col + 1) * TILE, (row + 1) * TILE))
            tile.save(OUT + f"flagstones_{col + 3 * row}.png")


if __name__ == "__main__":
    main()
