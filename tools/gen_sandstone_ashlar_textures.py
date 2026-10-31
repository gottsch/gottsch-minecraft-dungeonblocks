"""
Generates the PLACEHOLDER sandstone ashlar floor textures: one 48x48 pattern of squared sandstone
blocks laid in courses, whose joints cross block edges, cut into nine 16x16 tiles.

    python tools/gen_sandstone_ashlar_textures.py

Run from the repo root. Writes textures/block/sandstone_ashlar_<tile>.png for tile 0-8, where tile
is col + 3 * row of the 48x48 sheet - the value PatternTileBlock's TILE takes from a position:
col = x mod 3, row = z mod 3, as for the flagstones (gen_flagstone_textures.py). The sheet is drawn
facing north, its courses running east-west; FacingPatternTileBlock turns it for the other facings.

METHOD
------
Coursed ashlar: the sheet is cut into COURSES, rows of mixed heights that add up to 48, and each
course into stones of random length (MIN_STONE to MAX_STONE px) that add up to 48 too, so the sheet
wraps both ways. A stone's end joint keeps at least STAGGER px from the end joints of the courses
either side, as a mason breaks joints, and no joint, course or end, falls on a block edge (or a
pixel either side of one), so the 16x16 grid never shows. Every course starts at a random offset.

A pixel is joint on a stone's right and bottom edge, one pixel of the darkest sandstone shade.
Each stone takes a tone from vanilla sandstone's palette and is drawn as vanilla's cut_sandstone
draws its slab: lit along its top and left edge, shadowed along its bottom and right, mottled in
between. The mean luma sits a few points under vanilla cut_sandstone's (about 201 against 204),
the joints darkening it a little.

Deterministic (a fixed seed): re-running gives the same files. Hand edits are overwritten, so
change this script instead.
"""
import random

from PIL import Image

OUT = "src/main/resources/assets/dungeonblocks/textures/block/"
SIZE = 48
TILE = 16

# vanilla 1.20.1 sandstone.png / cut_sandstone.png, darkest to brightest; the joint is the darkest
SAND = [(198, 174, 113), (209, 186, 138), (213, 196, 150), (218, 210, 163), (227, 219, 176),
        (231, 228, 187), (237, 235, 203)]
JOINT = SAND[0]

# course heights, joint included, top to bottom; they must add up to SIZE
COURSES = [12, 9, 15, 12]
# where the first course starts: off the block edges, so no course joint lies on one
FIRST = 6
MIN_STONE = 10    # px, a stone's length, its joint included
MAX_STONE = 22
STAGGER = 3       # px, the least distance between end joints in neighbouring courses
EDGE = 1          # px either side of a block edge where no joint may fall


def off_edge(v):
    """True if a joint at `v` (the joint pixel's own column or row) is clear of every block edge.
    A joint pixel at v lies between v and v + 1, its stone ending at v."""
    d = (v + 1) % TILE
    return min(d, TILE - d) > EDGE


def lay_course(rng, above, below):
    """End joints for one course: stone lengths adding up to SIZE, every joint off the block edges
    and STAGGER clear of the joints in the courses either side. None if the dice found no way."""
    for _ in range(2000):
        start = rng.randrange(SIZE)
        joints, x = [], start
        while True:
            left = start + SIZE - x
            if left <= MAX_STONE and left >= MIN_STONE:
                joints.append((start + SIZE - 1) % SIZE)
                break
            if left < MIN_STONE:
                joints = None
                break
            x += rng.randint(MIN_STONE, min(MAX_STONE, left - MIN_STONE))
            joints.append((x - 1) % SIZE)
        if joints is None:
            continue

        def clear(j, others):
            return all(min((j - o) % SIZE, (o - j) % SIZE) >= STAGGER for o in others)

        if all(off_edge(j) and clear(j, above) and clear(j, below) for j in joints):
            return joints
    return None


def build(rng):
    assert sum(COURSES) == SIZE
    tops, y = [], FIRST
    for h in COURSES:
        tops.append(y)
        assert off_edge((y + h - 1) % SIZE), f"a course joint at {y + h - 1} lies on a block edge"
        y += h

    # lay the courses in turn, the last checked against the first as well, since the sheet wraps
    while True:
        rows = []
        for i in range(len(COURSES)):
            above = rows[i - 1] if i else []
            below = rows[0] if i == len(COURSES) - 1 else []
            joints = lay_course(rng, above, below)
            if joints is None:
                break
            rows.append(joints)
        if len(rows) == len(COURSES):
            break

    # each pixel's stone: (course, index of the stone in it), and whether it is joint
    stone, joint = {}, set()
    for c, (top, h, ends) in enumerate(zip(tops, COURSES, rows)):
        ends = sorted(ends)
        for dy in range(h):
            yy = (top + dy) % SIZE
            for xx in range(SIZE):
                # the stone is the first end joint at or after xx, going round
                k = next((i for i, e in enumerate(ends) if e >= xx), 0)
                stone[xx, yy] = (c, k)
                if dy == h - 1 or xx in ends:
                    joint.add((xx, yy))

    def is_joint(x, y):
        return (x % SIZE, y % SIZE) in joint

    tone = {s: rng.choice((2, 3, 3, 4)) for s in sorted(set(stone.values()))}
    sheet = Image.new("RGBA", (SIZE, SIZE))
    for y in range(SIZE):
        for x in range(SIZE):
            if (x, y) in joint:
                sheet.putpixel((x, y), JOINT)
                continue
            shade = tone[stone[x, y]]
            r = rng.random()
            shade += -1 if r < 0.2 else (1 if r > 0.85 else 0)
            # lit along the top and left edge, shadowed along the bottom and right
            if is_joint(x, y - 1) or is_joint(x - 1, y):
                shade = max(shade, tone[stone[x, y]]) + 1
            elif is_joint(x, y + 1) or is_joint(x + 1, y):
                shade = min(shade, tone[stone[x, y]]) - 1
            sheet.putpixel((x, y), SAND[max(1, min(len(SAND) - 1, shade))])
    return sheet


def save_tiles(sheet, name):
    for row in range(3):
        for col in range(3):
            tile = sheet.crop((col * TILE, row * TILE, (col + 1) * TILE, (row + 1) * TILE))
            tile.save(OUT + f"{name}_{col + 3 * row}.png")


def main():
    save_tiles(build(random.Random(7039)), "sandstone_ashlar")


if __name__ == "__main__":
    main()
