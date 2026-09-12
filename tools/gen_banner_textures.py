"""
Art pipeline for the dungeon banners.

    python tools/gen_banner_textures.py          (needs Pillow)

Output paths are resolved relative to this file, so it runs from any clone. It OVERWRITES the
banner textures under src/main/resources - they are generated, not hand-edited. If you hand-edit
one, the next run silently reverts it; change the recipe here instead.

The point of this file is the LAYERING. Tattered / grimy / bloodstained are not four separate
banners, they are treatments that stack on top of a base identity, so a new banner is one row in
VARIANTS rather than a new drawing. Add a row, add one ModBlocks.banner(...) line, re-run.

Per variant it writes:
  textures/entity/<id>.png - the BER atlas (64x64)
  textures/block/<id>.png  - flat 16x16, used as the particle AND the item sprite

Atlas layout is dictated by DungeonBannerModel: the cloth slices are ZERO-THICKNESS quads, so each
unwraps to two coincident faces, front at (u, v) and back at (u + w, v). Stacking the slices at
texOffs(0, s*h) makes the fronts one contiguous 10x30 block at the origin - so the cloth is simply
painted as a rectangle and the SILHOUETTE IS ALPHA, which is what makes ragged hems and torn holes
free. The rod's unwrap goes below the two cloth blocks.

Everything random is seeded off the variant id, so re-running produces byte-identical output.
"""
import os
import zlib
from random import Random

from PIL import Image

OUT = os.path.join(os.path.dirname(os.path.abspath(__file__)),
                   "..", "src", "main", "resources", "assets", "dungeonblocks", "textures")

# must match DungeonBannerModel
CLOTH_W, CLOTH_H = 10, 30
ROD_W, ROD_H, ROD_D = 12, 2, 2
ROD_TEX = (0, 32)

CLEAR = (0, 0, 0, 0)
TAPER_FROM = 20  # rows above this are full width
CREST_FLOOR = 11  # tatter holes stay below this, so crests survive - see layer_tatter


# ----------------------------------------------------------------------------------------------
# colour helpers
# ----------------------------------------------------------------------------------------------

def mul(c, f):
    return (_c(c[0] * f), _c(c[1] * f), _c(c[2] * f), c[3])


def lerp(a, b, t):
    return (_c(a[0] + (b[0] - a[0]) * t), _c(a[1] + (b[1] - a[1]) * t),
            _c(a[2] + (b[2] - a[2]) * t), a[3])


def _c(v):
    return max(0, min(255, int(round(v))))


# ----------------------------------------------------------------------------------------------
# base identities: the field colour, the rim, the crest and the rod are what make a banner "a
# dungeon banner" or "an orc war banner". Treatments below are applied on top of whichever of
# these a variant starts from.
# ----------------------------------------------------------------------------------------------

BASES = {
    "dungeon": dict(
        field=(122, 31, 31, 255),
        edge=(74, 20, 20, 255),
        shade=(96, 24, 24, 255),
        crest=(214, 205, 186, 255),
        crest_dark=(160, 150, 132, 255),
        grime_tint=(52, 44, 34, 255),
        rod=(58, 58, 63, 255),
        rod_lit=(86, 86, 92, 255),
        symbol="cross",
    ),
    # Filthy olive sackcloth, daubed rather than woven. Orcs do not hem things.
    #
    # The field is deliberately LIGHTER than it looks like it should be. The crest is daubed in
    # near-black, and a crest only reads at 10px wide if the luma gap under it is wide - the first
    # pass used a dark olive field and the eye disappeared into it. Same lesson as the stone
    # textures: legibility is luma, not hue.
    "orc": dict(
        field=(116, 106, 70, 255),
        edge=(62, 56, 36, 255),
        shade=(92, 84, 54, 255),
        crest=(38, 33, 27, 255),
        crest_dark=(198, 188, 158, 255),
        # The claw marks are daubed in dried blood, not ink. Near-black at 1px on olive reads as
        # dirt specks rather than as a mark, and three of them read as damage to the texture
        # itself - this is warm and clearly lighter than the eye's rim, so it registers as paint.
        claw=(118, 52, 30, 255),
        grime_tint=(44, 38, 26, 255),
        rod=(74, 56, 38, 255),
        rod_lit=(102, 78, 52, 255),
        symbol="orc",
    ),
    # Near-black grave linen. The field is the darkest of the three by a wide margin, which is
    # exactly what lets a bone crest carry the whole banner: the luma gap does the work, so the
    # skull needs no outline of its own the way the orc eye does.
    "undead": dict(
        field=(48, 48, 54, 255),
        edge=(26, 26, 31, 255),
        shade=(37, 37, 43, 255),
        crest=(206, 200, 182, 255),
        # Sockets ARE holes, so near-black is right here - the "never pure black" rule is about
        # thin marks on a mid-tone field, not about depth inside a pale shape.
        crest_dark=(150, 145, 130, 255),
        socket=(20, 20, 24, 255),
        grime_tint=(38, 36, 32, 255),
        rod=(50, 46, 46, 255),
        rod_lit=(76, 72, 72, 255),
        symbol="undead",
        # Brighter and fresher than the default dried blood, and NOT a stylistic choice: the
        # default sits 9 luma from this field and simply disappears on it, where it reads fine on
        # the orc sackcloth 65 luma away. Contrast is a property of the pair, not of the colour -
        # so the stain is defined per base, next to the field it has to be seen against.
        blood=(170, 40, 32, 255),
        blood_dark=(112, 24, 20, 255),
    ),
}

# Default blood: dried and dark, which is what suits a mid-tone field like the orc sackcloth.
# A base can override it, and the undead one has to - see its "blood" entry.
BLOOD = (92, 18, 16, 255)
BLOOD_DARK = (58, 12, 12, 255)

# id, base, treatments. Treatment strengths are 0..1.
VARIANTS = [
    ("dungeon_banner", "dungeon", dict()),
    ("grimy_banner", "dungeon", dict(grime=0.8)),
    ("tattered_banner", "dungeon", dict(grime=0.5, tatter=0.65)),
    ("orc_banner", "orc", dict(grime=0.30, tatter=0.25)),
    ("tattered_orc_banner", "orc", dict(grime=0.60, tatter=0.85)),
    ("bloodstained_orc_banner", "orc", dict(grime=0.40, tatter=0.55, blood=0.45)),
    # Note there is no grimy undead banner: grime darkens and desaturates, and on a field this
    # dark and this grey it does nothing you can see. Tatter and blood both read well on it.
    ("undead_banner", "undead", dict(grime=0.25)),
    ("tattered_undead_banner", "undead", dict(grime=0.45, tatter=0.70)),
    ("bloodstained_undead_banner", "undead", dict(grime=0.35, tatter=0.50, blood=0.50)),
]


# ----------------------------------------------------------------------------------------------
# silhouette
# ----------------------------------------------------------------------------------------------

def taper_inset(y):
    """Pixels cut from each side at row y - the painted point every banner shares."""
    if y < TAPER_FROM:
        return 0
    return min(CLOTH_W // 2 - 1, int((y - TAPER_FROM + 1) * 0.45))


# ----------------------------------------------------------------------------------------------
# layers. Each takes the pixel grid and mutates it in place.
# ----------------------------------------------------------------------------------------------

def layer_weave(px, base, rnd):
    """
    The field, with cloth structure rather than one flat colour. Three cheap frequencies:
    a horizontal thread beat, a few vertical slubs down the whole drop, and per-pixel noise.
    Without this the banner reads as painted metal.
    """
    slub_dark = {rnd.randrange(CLOTH_W) for _ in range(3)}
    slub_light = {rnd.randrange(CLOTH_W) for _ in range(2)}
    for y in range(CLOTH_H):
        for x in range(CLOTH_W):
            if px[y][x] is None:
                continue
            c = base["field"]
            if y % 2 == 0:
                c = mul(c, 0.94)
            if x in slub_dark:
                c = mul(c, 0.90)
            elif x in slub_light:
                c = mul(c, 1.07)
            px[y][x] = mul(c, 1.0 + rnd.uniform(-0.04, 0.04))


def layer_edging(px, base, rnd):
    """A darker rim down both sides and along the top, where the cloth wraps the rod."""
    for y in range(CLOTH_H):
        row = [x for x in range(CLOTH_W) if px[y][x] is not None]
        if len(row) < 4:
            continue  # at the tip a rim on both sides would make the point solid dark
        left, right = row[0], row[-1]
        px[y][left] = base["edge"]
        px[y][right] = base["edge"]
        px[y][left + 1] = mul(base["shade"], 1.0 + rnd.uniform(-0.03, 0.03))
    for x in range(CLOTH_W):
        if px[0][x] is not None:
            px[0][x] = base["edge"]
        if px[1][x] is not None:
            px[1][x] = mul(px[1][x], 1.10)  # light catching just under the rod


def layer_crest(px, base, rnd):
    if base["symbol"] == "cross":
        _crest_cross(px, base, rnd)
    elif base["symbol"] == "undead":
        _crest_undead(px, base, rnd)
    else:
        _crest_orc(px, base, rnd)


def _bone_patch(px, base, cells, rnd):
    """
    Paints a set of cells as a patch stitched onto the banner rather than a block of one colour.

    Four things make it read that way, and none of them is hand-placed: the shadow side is derived
    from the shape (any cell missing a right or lower neighbour is an inner edge, so it takes the
    darker ply), a thread beat runs down its length, per-pixel noise breaks the remaining flatness,
    and the patch casts a shadow onto the field along its bottom and right. Two flat tones was
    what made the first pass look like painted metal - the relief is what says cloth on cloth.
    """
    light, dark, field = base["crest"], base["crest_dark"], base["field"]
    ordered = sorted(cells)

    for x, y in ordered:
        inner_edge = (x + 1, y) not in cells or (x, y + 1) not in cells
        c = dark if inner_edge else light
        if y % 3 == 0:
            c = mul(c, 0.96)
        _set(px, x, y, mul(c, 1.0 + rnd.uniform(-0.05, 0.05)))

    # worn through to the field beneath, in a handful of places
    for x, y in ordered:
        if rnd.random() < 0.07 and px[y][x] is not None:
            px[y][x] = lerp(px[y][x], field, rnd.uniform(0.45, 0.8))

    # the patch sits proud of the banner, so it throws a shadow down and to the right
    for x, y in ordered:
        for dx, dy in ((1, 0), (0, 1)):
            nx, ny = x + dx, y + dy
            if (nx, ny) in cells:
                continue
            if 0 <= nx < CLOTH_W and 0 <= ny < CLOTH_H and px[ny][nx] is not None:
                px[ny][nx] = mul(px[ny][nx], 0.82)


def _cells(art, x0, y0, mark="#"):
    """Cells matching `mark` in a small ASCII map, offset to (x0, y0)."""
    return {(x0 + dx, y0 + dy)
            for dy, row in enumerate(art)
            for dx, ch in enumerate(row) if ch == mark}


def _crest_cross(px, base, rnd):
    cells = {(4, y) for y in range(3, 25)} | {(5, y) for y in range(3, 25)}
    cells |= {(x, y) for x in range(2, 8) for y in range(7, 10)}
    _bone_patch(px, base, cells, rnd)


def _crest_undead(px, base, rnd):
    """
    A bone skull over a spine, both drawn as stitched-on patches.

    The skull is an 8x8 ASCII map because at this size the shape is the whole design and it needs
    to be read, not computed - and it has to be symmetric about the cloth's centre, which a set
    comprehension makes easy to get subtly wrong. Sockets and mouth are punched in afterwards so
    the patch treatment runs over the skull as one piece.

    The spine below is deliberately thin and dimmer than the skull. Ribs sit a pixel clear of it:
    touching, they merge into a solid 4px bar and read as a post rather than a spine.
    """
    skull = (
        ".######.",
        "########",
        "#oo##oo#",
        "#oo##oo#",
        "###oo###",
        ".######.",
        "..####..",
        "..#oo#..",
    )
    cells = _cells(skull, 1, 3)
    _bone_patch(px, base, cells, rnd)
    for x, y in sorted(_cells(skull, 1, 3, "o")):
        _set(px, x, y, mul(base["socket"], 1.0 + rnd.uniform(-0.08, 0.08)))

    spine = {(x, y) for x in (4, 5) for y in range(13, 23)}
    ribs = {(x, y) for y in (14, 16, 18, 20) for x in (2, 7)}
    _bone_patch(px, base, spine | ribs, rnd)
    for x, y in sorted(spine | ribs):
        if px[y][x] is not None:
            px[y][x] = mul(px[y][x], 0.82)  # keep the skull the thing you look at


def _crest_orc(px, base, rnd):
    """
    A daubed eye with a slit pupil, and three claw slashes dragged under it. Crude and
    deliberately asymmetric - it should look smeared on by hand, not printed.

    The eye is built pale-inside-dark rather than as one dark blob: at this size a solid shape has
    no internal structure to read as an eye, so it needs the light lens to sit against the ink rim.
    """
    ink, pale, rust = base["crest"], base["crest_dark"], base.get("blood", BLOOD)

    # An almond over five rows, with the ink outline DERIVED from it (any neighbour outside the
    # lens) rather than hand-placed bars above and below - those bars are what turned the first
    # pass into a box with a stripe in it.
    #
    # The pupil is ONE pixel wide, and that is forced by the width: at 6px across, a 2px pupil
    # leaves a single pale pixel either side on the narrow rows, and the eye stops reading as an eye
    # and starts reading as two white dots. It cannot sit on the true centre (4.5) either, so it
    # sits at 4 - which suits a mark daubed on by hand better than perfect symmetry would.
    lens = {(x, 4) for x in range(4, 6)}         | {(x, 5) for x in range(3, 7)}         | {(x, 6) for x in range(2, 8)}         | {(x, 7) for x in range(3, 7)}         | {(x, 8) for x in range(4, 6)}
    for x, y in sorted(lens):
        _set(px, x, y, mul(pale, 1.0 + rnd.uniform(-0.05, 0.05)))
    for x, y in sorted(lens):
        for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            if (x + dx, y + dy) not in lens:
                _set(px, x + dx, y + dy, ink)

    for y in range(5, 8):        # slit pupil, leaving the almond's tips pale
        _set(px, 4, y, ink)
    _set(px, 2, 6, rust)         # bloodshot inner corner, in the same daub as the claws

    # Three claw slashes dragged down-right. Every one is a single pixel wide, spaced 3px apart on
    # a near-vertical drift: thickened strokes, or a steeper slope that lets them converge, merge
    # into one dark mass against the grime blotches and stop reading as cuts.
    #
    # Each stroke is heaviest where the claw bit and fades along the drag, which is what makes it a
    # drag rather than a drawn line. A darker fleck at the head gives it the initial gouge.
    claw = base["claw"]
    for x0, y0, length in ((2, 13, 8), (5, 12, 9), (7, 14, 7)):
        for step in range(length):
            x, y = x0 + step // 6, y0 + step
            if not (0 <= x < CLOTH_W and 0 <= y < CLOTH_H) or px[y][x] is None:
                continue
            fade = (step / max(1, length - 1)) ** 0.8
            c = mul(claw, 1.0 + rnd.uniform(-0.06, 0.06))
            if step == 0:
                c = mul(c, 0.7)
            px[y][x] = lerp(c, px[y][x], fade * 0.65)


def layer_grime(px, base, amount, rnd):
    """
    Dirt does not sit evenly. Two components: a gradient wicking up from the hem (where a hanging
    cloth touches everything) and soot at the top (where the torch smoke collects), plus blotches.
    """
    tint = base["grime_tint"]
    for y in range(CLOTH_H):
        up_from_hem = max(0.0, (y - CLOTH_H * 0.35) / (CLOTH_H * 0.65)) ** 1.6
        down_from_rod = max(0.0, (CLOTH_H * 0.18 - y) / (CLOTH_H * 0.18)) ** 1.5
        base_t = amount * max(up_from_hem, down_from_rod * 0.7)
        for x in range(CLOTH_W):
            if px[y][x] is None:
                continue
            t = min(0.9, base_t * rnd.uniform(0.75, 1.15))
            # dirt kills saturation before it kills brightness, so pull toward grey first.
            # Darkening alone just reads as shadow, which is why the first pass was invisible.
            c = px[y][x]
            luma = 0.299 * c[0] + 0.587 * c[1] + 0.114 * c[2]
            c = lerp(c, (luma, luma, luma, c[3]), t * 0.55)
            px[y][x] = lerp(c, tint, t * 0.75)

    for _ in range(int(7 * amount) + 1):
        cx, cy = rnd.randrange(CLOTH_W), rnd.randrange(4, CLOTH_H)
        r = rnd.uniform(1.6, 3.4)
        for y in range(CLOTH_H):
            for x in range(CLOTH_W):
                if px[y][x] is None:
                    continue
                d = ((x - cx) ** 2 + ((y - cy) * 0.7) ** 2) ** 0.5
                if d < r:
                    px[y][x] = lerp(px[y][x], tint, amount * 0.7 * (1.0 - d / r))


def layer_blood(px, base, amount, rnd):
    """Spatter, and runs dragged down from some of it. Whether it reads as dried or fresh is the
    base's call, because that depends entirely on the field underneath it."""
    blood, blood_dark = base.get("blood", BLOOD), base.get("blood_dark", BLOOD_DARK)
    for _ in range(int(5 * amount) + 1):
        cx, cy = rnd.randrange(CLOTH_W), rnd.randrange(2, CLOTH_H - 6)
        r = rnd.uniform(1.2, 2.6)
        for y in range(CLOTH_H):
            for x in range(CLOTH_W):
                if px[y][x] is None:
                    continue
                d = ((x - cx) ** 2 + ((y - cy) * 0.8) ** 2) ** 0.5
                if d < r:
                    px[y][x] = lerp(px[y][x], blood, min(0.9, amount * (1.0 - d / r) * 2.0))
        # a run from the bottom of the spatter
        if rnd.random() < 0.7:
            for step in range(int(rnd.uniform(2, 8) * amount) + 1):
                y = int(cy + r) + step
                if 0 <= y < CLOTH_H and px[y][cx] is not None:
                    px[y][cx] = lerp(px[y][cx], blood_dark, amount * 0.9)

    for _ in range(int(8 * amount)):  # fine spray
        x, y = rnd.randrange(CLOTH_W), rnd.randrange(CLOTH_H)
        if px[y][x] is not None:
            px[y][x] = lerp(px[y][x], blood_dark, amount * 0.8)


def layer_tatter(px, amount, rnd):
    """
    Eats the silhouette: a ragged hem, bites out of the sides, and holes torn through. Runs LAST,
    so tears cut through the crest and the grime the way real damage does.

    This is the layer the zero-depth/alpha design bought: none of it is geometry, and the mirrored
    back face inherits every hole automatically.
    """
    # ragged hem - a random-walk profile so the tears read as connected damage, not as noise
    depth = 0
    max_depth = int(7 * amount)
    for x in range(CLOTH_W):
        depth = max(0, min(max_depth, depth + rnd.randint(-2, 2)))
        for y in range(CLOTH_H - depth, CLOTH_H):
            _clear(px, x, y)

    # bites out of the sides
    for _ in range(int(5 * amount)):
        y0 = rnd.randrange(2, CLOTH_H - 2)
        for dy in range(rnd.randint(1, 3)):
            row = [x for x in range(CLOTH_W) if px[min(y0 + dy, CLOTH_H - 1)][x] is not None]
            if not row:
                continue
            y = min(y0 + dy, CLOTH_H - 1)
            for k in range(rnd.randint(1, 2)):
                _clear(px, row[0] + k if rnd.random() < 0.5 else row[-1] - k, y)

    # Holes, kept to the lower cloth. Two reasons for the floor at CREST_FLOOR: the top rows are
    # what the banner hangs off its rod by, and everything above it is crest - the orc eye and the
    # undead skull both live at rows 3-10, and a hole through the emblem costs the banner its
    # identity. Damage the cloth, not the mark.
    for _ in range(int(5 * amount)):
        cx, cy = rnd.randrange(1, CLOTH_W - 1), rnd.randrange(CREST_FLOOR, CLOTH_H - 2)
        r = rnd.uniform(0.9, 1.0 + 1.4 * amount)
        for y in range(CLOTH_H):
            for x in range(CLOTH_W):
                if ((x - cx) ** 2 + ((y - cy) * 0.9) ** 2) ** 0.5 < r:
                    _clear(px, x, y)

    _fray(px, rnd)


def _fray(px, rnd):
    """Loose threads: pixels that gained a cleared neighbour get pulled light or dark."""
    frayed = []
    for y in range(CLOTH_H):
        for x in range(CLOTH_W):
            if px[y][x] is None:
                continue
            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                nx, ny = x + dx, y + dy
                if not (0 <= nx < CLOTH_W and 0 <= ny < CLOTH_H) or px[ny][nx] is None:
                    frayed.append((x, y))
                    break
    for x, y in frayed:
        px[y][x] = mul(px[y][x], rnd.choice((0.80, 0.88, 1.12)))


def _set(px, x, y, c):
    if 0 <= x < CLOTH_W and 0 <= y < CLOTH_H and px[y][x] is not None:
        px[y][x] = c


def _clear(px, x, y):
    if 0 <= x < CLOTH_W and 0 <= y < CLOTH_H:
        px[y][x] = None


# ----------------------------------------------------------------------------------------------
# assembly
# ----------------------------------------------------------------------------------------------

def build_face(base, treat, rnd):
    """None means transparent, so the silhouette and the colour live in one grid."""
    px = [[None if (x < taper_inset(y) or x >= CLOTH_W - taper_inset(y)) else base["field"]
           for x in range(CLOTH_W)] for y in range(CLOTH_H)]
    layer_weave(px, base, rnd)
    layer_edging(px, base, rnd)
    layer_crest(px, base, rnd)
    if treat.get("grime"):
        layer_grime(px, base, treat["grime"], rnd)
    if treat.get("blood"):
        layer_blood(px, base, treat["blood"], rnd)
    if treat.get("tatter"):
        layer_tatter(px, treat["tatter"], rnd)

    img = Image.new("RGBA", (CLOTH_W, CLOTH_H), CLEAR)
    out = img.load()
    for y in range(CLOTH_H):
        for x in range(CLOTH_W):
            out[x, y] = CLEAR if px[y][x] is None else px[y][x]
    return img


def entity_atlas(face, base, rnd):
    tex = Image.new("RGBA", (64, 64), CLEAR)
    tex.paste(face, (0, 0))                                         # fronts, contiguous
    tex.paste(face.transpose(Image.FLIP_LEFT_RIGHT), (CLOTH_W, 0))  # mirrored backs
    u, v = ROD_TEX
    rod = Image.new("RGBA", (2 * (ROD_W + ROD_D), ROD_D + ROD_H), base["rod"])
    rpx = rod.load()
    for y in range(rod.height):          # a little grain so the rod is not a flat bar either
        for x in range(rod.width):
            rpx[x, y] = mul(rpx[x, y], 1.0 + rnd.uniform(-0.07, 0.07))
    tex.paste(rod, (u, v))
    lit = Image.new("RGBA", (ROD_W, ROD_H), base["rod_lit"])
    lpx = lit.load()
    for x in range(ROD_W):
        for y in range(ROD_H):
            lpx[x, y] = mul(lpx[x, y], 1.0 + rnd.uniform(-0.08, 0.08))
    tex.paste(lit, (u + ROD_D, v + ROD_D))
    return tex


def block_sprite(face, base):
    """16x16 icon. The banner is 2 blocks tall, so the cloth is squeezed to every other row."""
    img = Image.new("RGBA", (16, 16), CLEAR)
    px = img.load()
    x0 = (16 - ROD_W) // 2
    for x in range(x0, x0 + ROD_W):
        px[x, 0] = base["rod_lit"]
    fpx = face.load()
    for row in range(15):
        for x in range(CLOTH_W):
            c = fpx[x, row * 2]
            if c[3]:
                px[(16 - CLOTH_W) // 2 + x, 1 + row] = c
    return img


for banner_id, base_name, treatments in VARIANTS:
    base = BASES[base_name]
    rnd = Random(zlib.crc32(banner_id.encode()))
    face = build_face(base, treatments, rnd)
    entity_atlas(face, base, rnd).save(os.path.join(OUT, "entity", banner_id + ".png"))
    block_sprite(face, base).save(os.path.join(OUT, "block", banner_id + ".png"))
    print("%-26s base=%-8s %s" % (banner_id, base_name, treatments or "clean"))
