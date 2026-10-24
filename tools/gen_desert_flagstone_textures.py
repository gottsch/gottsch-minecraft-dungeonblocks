"""
Generates the PLACEHOLDER desert flagstone textures: red sandstone paving half buried in sand, a
48x48 pattern cut into nine 16x16 tiles, as the flagstones are. For a future desert motif; not yet a
registered block.

    python tools/gen_desert_flagstone_textures.py

Run from the repo root. Writes textures/block/desert_flagstones_<tile>.png for tile 0-8, laid out
as gen_flagstone_textures.py lays its tiles (col + 3 * row; col = x mod 3, row = z mod 3), so a
PatternTileBlock can show them.

METHOD
------
Sparser than the flagstones: not a paved floor but broken paving in sand. The stones are again a
Voronoi pattern on the 48x48 torus (so the sheet wraps), but smaller and only partly kept:
- A seed's stone is laid only where a wrapping low-frequency field is high, so the stones lie in
  drifts of broken paving with open sand between; elsewhere a seed leaves at most a pebble. Then
  every block's tile is made at least MIN_STONE stone, so no block of the floor is bare sand.
- A laid stone is its Voronoi cell inset by a sand gap, and clipped to a radius about its seed, so
  stones are rounded and stand apart, the way stones sunk in sand show rather than butting up in
  mortar.
- Stone pixels take vanilla red_sandstone's (side) oranges: a tone per stone, mottled, lit along
  its top and left edge and darker along its bottom and right. The sand takes vanilla sand's own
  shades in about vanilla's proportions, with a shadow cast below and right of each stone.

Deterministic (a fixed seed): re-running gives the same files. Hand edits are overwritten, so
change this script instead.
"""
import math
import random

from PIL import Image

from gen_flagstone_textures import SIZE, TILE, field, save_tiles, wrapped

# vanilla sand.png, darkest to brightest, and how often each occurs in it
SAND = [(209, 186, 138), (213, 196, 150), (218, 207, 163), (227, 219, 176), (231, 228, 187), (237, 235, 203)]
SAND_WEIGHTS = [10, 67, 108, 58, 8, 5]
# a stone's shadow on the sand: a step under sand's darkest, the same hue
SAND_SHADOW = (192, 166, 118)
# vanilla red_sandstone.png (its side), darkest to brightest
RED = [(159, 78, 11), (172, 87, 18), (178, 96, 31), (192, 104, 34), (203, 110, 36), (210, 117, 43), (217, 123, 48)]

SEEDS = 22        # seeds on the sheet, stones and pebbles both
SPACING = 8.0     # px, the least distance between two seeds
WEIGHT = 1.5      # px a seed's cell may grow or shrink by
GAP = 1.6         # sand between two stones: where the nearest two seeds' distances differ by less
# px, the range of a laid stone's radius about its seed: big enough that most stones are their
# angular Voronoi cell, clipped round only at the drift's ragged edge (all-round stones read as
# blobs, not paving)
RADIUS = (7.5, 12.0)
PEBBLE = (1.6, 2.4)   # px, the same for a pebble
LAID = 0.0        # the drift field's level above which a seed lays a stone
PEBBLES = 0.25    # the share of the other seeds that leave a pebble
# the least share of each block's tile that is stone: a desert floor mixes these with plain sand,
# so a block of it that is all sand reads as plain sand. A block short of it has its nearest
# unlaid seed laid as a stone, until it has enough.
MIN_STONE = 0.2


def main():
    rng = random.Random(6131)
    drift = field(rng, waves=2)
    seeds = []
    while len(seeds) < SEEDS:
        x, y = rng.uniform(0, SIZE), rng.uniform(0, SIZE)
        if all(math.hypot(wrapped(x, sx), wrapped(y, sy)) >= SPACING for sx, sy, *_ in seeds):
            laid = drift(x, y) > LAID
            if laid:
                radius = rng.uniform(*RADIUS)
            elif rng.random() < PEBBLES:
                radius = rng.uniform(*PEBBLE)
            else:
                radius = 0
            seeds.append([x, y, rng.uniform(-WEIGHT, WEIGHT), radius, rng.choice((2, 3, 3, 4))])

    def lay():
        owner = {}
        for y in range(SIZE):
            for x in range(SIZE):
                d = sorted((math.hypot(wrapped(x + 0.5, sx), wrapped(y + 0.5, sy)) - w, i)
                           for i, (sx, sy, w, _, _) in enumerate(seeds))
                i = d[0][1]
                sx, sy, _, radius, _ = seeds[i]
                if d[1][0] - d[0][0] >= GAP and math.hypot(wrapped(x + 0.5, sx), wrapped(y + 0.5, sy)) <= radius:
                    owner[x, y] = i
        return owner

    owner = lay()
    for row in range(3):
        for col in range(3):
            centre = (col * TILE + TILE / 2, row * TILE + TILE / 2)
            while sum(1 for x, y in owner if x // TILE == col and y // TILE == row) < MIN_STONE * TILE * TILE:
                unlaid = [s for s in seeds if s[3] < RADIUS[0]]
                if not unlaid:
                    break
                nearest = min(unlaid, key=lambda s: math.hypot(wrapped(s[0], centre[0]), wrapped(s[1], centre[1])))
                nearest[3] = rng.uniform(*RADIUS)
                owner = lay()

    def stone(x, y):
        return owner.get((x % SIZE, y % SIZE))

    sheet = Image.new("RGBA", (SIZE, SIZE))
    for y in range(SIZE):
        for x in range(SIZE):
            i = stone(x, y)
            if i is None:
                # sand, shadowed below and right of a stone, as the light falls from the top left
                shaded = stone(x, y - 1) is not None or stone(x - 1, y) is not None
                sheet.putpixel((x, y), SAND_SHADOW if shaded else rng.choices(SAND, SAND_WEIGHTS)[0])
                continue
            shade = seeds[i][4]
            r = rng.random()
            shade += -1 if r < 0.2 else (1 if r > 0.85 else 0)
            # a stone's edges: lit toward the top left, darker toward the bottom right
            if stone(x, y - 1) != i or stone(x - 1, y) != i:
                shade += 1
            elif stone(x, y + 1) != i or stone(x + 1, y) != i:
                shade -= 1
            sheet.putpixel((x, y), RED[max(0, min(len(RED) - 1, shade))])

    save_tiles(sheet, "desert_flagstones")


if __name__ == "__main__":
    main()
