"""
Generates the PLACEHOLDER fan cobble floor textures: one 48x48 pattern of small setts laid in
overlapping arcs (fan paving), whose joints cross block edges, cut into nine 16x16 tiles.

    python tools/gen_fan_cobble_textures.py

Run from the repo root. Writes textures/block/fan_cobbles_<tile>.png for tile 0-8, where tile is
col + 3 * row of the 48x48 sheet - the value PatternTileBlock's TILE takes from a position:
col = x mod 3, row = z mod 3, as for the flagstones (gen_flagstone_textures.py).

METHOD
------
Fans are circles of radius RADIUS on a lattice FAN_W wide and FAN_H high, every other row shifted
half a fan, so they overlap like fish scales: a pixel belongs to the fan of the LOWEST row (largest
y) whose circle holds it, the nearer of two in a row, and what shows of each fan is its upper rim, an arc FAN_W (3 blocks)
across. Inside a fan the setts lie in concentric rings RING px deep, each ring cut along its arc
into a whole number of setts about SETT px long, every ring's cuts staggered half a sett from the last, as fan
paving is laid. The lattice divides the sheet exactly (48 = 1 x FAN_W = 2 x FAN_H), and every
distance is taken on the 48x48 torus, so the sheet tiles seamlessly both ways.

A pixel is joint where the sett to its right or below is another sett (one pixel of mortar
between any two setts); a sett too small to read is filled in as joint. Setts take the flagstones'
greys (vanilla stone_bricks'), a tone per sett, mottled, lit on the top-left pixel edge and
shadowed on the bottom-right. The joint between two fans is the darker mortar grey and the joints
inside a fan the lighter, so the arcs read over several blocks; the sheet's mean luma sits within a
couple of points of the flagstones' (about 120), though two fifths of it is joint.

Deterministic (a fixed seed): re-running gives the same files. Hand edits are overwritten, so
change this script instead.
"""
import math
import random

from PIL import Image

OUT = "src/main/resources/assets/dungeonblocks/textures/block/"
SIZE = 48
TILE = 16

# the flagstones' palette (gen_flagstone_textures.py): vanilla stone_bricks, darkest to brightest;
# the mortar its two darkest
GREYS = [(104, 104, 104), (116, 116, 116), (127, 127, 127), (139, 137, 139), (156, 153, 156)]
MORTAR = [(90, 89, 90), (99, 99, 99)]

FAN_W = 48        # px, a fan's width: three blocks
FAN_H = 24        # px between rows of fans
RADIUS = 26.0     # px, a fan's circle: just over FAN_W / 2, to close the gaps between circles
RING = 5.0        # px, a ring of setts, its joint included
SETT = 6.0        # px, a sett's length along its ring, its joint included
MIN_SETT = 4      # px, a sett smaller than this is filled in as joint


def fans():
    """Every fan centre whose circle can reach the sheet, with its row, its torus copies included."""
    out = []
    for j in range(-3, SIZE // FAN_H + 3):
        for i in range(-2, SIZE // FAN_W + 3):
            out.append((i * FAN_W + (j % 2) * FAN_W / 2, j * FAN_H, j))
    return out


def sett_of(x, y, centres):
    """The sett a pixel lies in: (fan, ring, segment), the fan named by its lattice cell mod the
    sheet so torus copies of one fan are the same fan."""
    px, py = x + 0.5, y + 0.5
    best = None
    for cx, cy, j in centres:
        d = math.hypot(px - cx, py - cy)
        # the lower row lies over the upper; within a row the nearer fan
        if d < RADIUS and (best is None or (j, -d) > (best[2], -best[3])):
            best = (cx, cy, j, d)
    assert best is not None, f"pixel {x},{y} in no fan: raise RADIUS"
    cx, cy, j, d = best
    ring = int(d // RING)
    # the ring cut into a whole number of setts, so none is a sliver where the cuts meet round the
    # back; each ring's cuts staggered half a sett from the last, and none on the fan's axis
    count = max(1, round(2 * math.pi * (ring + 0.5) * RING / SETT))
    turn = math.atan2(px - cx, cy - py) / (2 * math.pi) + 0.5
    stagger = (0.25 + 0.5 * (ring % 2)) / count
    fan = (round(cx) % SIZE, round(cy) % SIZE)
    return fan, ring, math.floor((turn + stagger) * count) % count


def build(rng):
    centres = fans()
    sett = {(x, y): sett_of(x, y, centres) for y in range(SIZE) for x in range(SIZE)}

    def at(x, y):
        return sett[x % SIZE, y % SIZE]

    mortar = {(x, y) for (x, y), s in sett.items() if at(x + 1, y) != s or at(x, y + 1) != s}
    # a sett cut to a sliver by the joints, or by a fan's edge, reads as noise: fill it in
    size = {}
    for p, s in sett.items():
        if p not in mortar:
            size[s] = size.get(s, 0) + 1
    mortar |= {p for p, s in sett.items() if size.get(s, 0) < MIN_SETT}

    def is_mortar(x, y):
        return (x % SIZE, y % SIZE) in mortar

    # the joint where two fans meet: the darker grey, so the arcs read
    fan_joint = {(x, y) for (x, y) in mortar
                 if any(at(x + a, y + b)[0] != sett[x, y][0] for a, b in ((1, 0), (0, 1), (-1, 0), (0, -1)))}

    tone = {s: rng.choice((1, 2, 2, 3, 3, 3)) for s in sorted(set(sett.values()))}
    sheet = Image.new("RGBA", (SIZE, SIZE))
    for y in range(SIZE):
        for x in range(SIZE):
            if (x, y) in mortar:
                sheet.putpixel((x, y), MORTAR[0] if (x, y) in fan_joint else MORTAR[1])
                continue
            shade = tone[sett[x, y]]
            r = rng.random()
            shade += -1 if r < 0.15 else (1 if r > 0.9 else 0)
            # a sett's edges: lit where the joint is above or to the left, shadowed below or right
            if is_mortar(x, y - 1) or is_mortar(x - 1, y):
                shade += 1
            elif is_mortar(x, y + 1) or is_mortar(x + 1, y):
                shade -= 1
            sheet.putpixel((x, y), GREYS[max(0, min(len(GREYS) - 1, shade))])
    return sheet


def save_tiles(sheet, name):
    for row in range(3):
        for col in range(3):
            tile = sheet.crop((col * TILE, row * TILE, (col + 1) * TILE, (row + 1) * TILE))
            tile.save(OUT + f"{name}_{col + 3 * row}.png")


def main():
    save_tiles(build(random.Random(6211)), "fan_cobbles")


if __name__ == "__main__":
    main()
