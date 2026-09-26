"""
Generates the mod's OBJ block models - the shapes vanilla JSON cuboids cannot make: sloped faces,
and boxes at arbitrary angles. Each model is built here from two primitives, boxes and square
pyramids, in PIXEL units (0-16 across a block), then written out in the BLOCK units Forge's OBJ
loader uses as-is.

=============================================================================================
TO ADD A MODEL: write a function returning a list of faces, add it to MODELS, run this script.
=============================================================================================

CONVENTIONS - each is load-bearing, so do not "simplify" them away
------------------------------------------------------------------
- Every face is wound counter-clockwise seen from outside. write_obj asserts it, by checking the
  winding normal against the face's intended outward normal: a wrongly wound face is invisible in
  game (back-face culled), and nothing else would catch it.
- UVs are computed in Minecraft's texture pixel space (u right, v DOWN, 0-16) and written flipped
  for OBJ's v-up convention; every model JSON therefore sets "flip_v": true.
- Box faces take the same UV vanilla derives for a JSON element without an explicit "uv", EXCEPT
  along a box's `grain` axis: faces parallel to it run the texture's v along the member's length,
  so a horizontal timber shows its grain lengthwise, not across. End faces use the `end` material.
- Rotations are applied AFTER the UVs are fixed, so a rotated timber keeps its grain.
- A pyramid facet is a triangular CROP of its texture region (base on the region's bottom edge,
  apex at its top centre), never a squash - brick courses stay level up to the point.
- Faces lying exactly on a block boundary with an outward normal get Forge's automatic cullface;
  that is how a pyramid's base hides against the block it sits on.

The .mtl files are one line per material: "map_Kd #<material>", resolved against the model
JSON's textures, so one OBJ serves every wood or stone that uses the shape.

Run from the repo root:
    python tools/gen_obj_models.py
"""
import math

OUT = "src/main/resources/assets/dungeonblocks/models/block/"

AXES = {"x": 0, "y": 1, "z": 2}


class Face:
    def __init__(self, material, verts, uvs, normal):
        self.material = material
        self.verts = [tuple(v) for v in verts]     # pixels
        self.uvs = [tuple(t) for t in uvs]         # texture pixels, v down
        self.normal = tuple(normal)                # intended outward direction


# ---------------------------------------------------------------------------------------------
# primitives
# ---------------------------------------------------------------------------------------------

def box(frm, to, side, end=None, grain=None, skip=()):
    """An axis-aligned box. `side` and `end` are material names; `grain` ("x", "y" or "z") is the
    member's length axis - its faces take `end`, and the faces along it run v lengthwise.
    `skip` lists face directions to leave out (e.g. faces buried in another part)."""
    fx, fy, fz = frm
    tx, ty, tz = to
    end = end or side
    faces = []

    # each face: its 4 corners CCW from outside, starting top-left as seen from outside, and the
    # vanilla default uv [u0, v0, u1, v1] for it (see the model-uv-default-mapping note)
    spec = {
        "down":  ([(fx, fy, tz), (fx, fy, fz), (tx, fy, fz), (tx, fy, tz)], (0, -1, 0),
                  [fx, 16 - tz, tx, 16 - fz]),
        "up":    ([(fx, ty, fz), (fx, ty, tz), (tx, ty, tz), (tx, ty, fz)], (0, 1, 0),
                  [fx, fz, tx, tz]),
        "north": ([(tx, ty, fz), (tx, fy, fz), (fx, fy, fz), (fx, ty, fz)], (0, 0, -1),
                  [16 - tx, 16 - ty, 16 - fx, 16 - fy]),
        "south": ([(fx, ty, tz), (fx, fy, tz), (tx, fy, tz), (tx, ty, tz)], (0, 0, 1),
                  [fx, 16 - ty, tx, 16 - fy]),
        "west":  ([(fx, ty, fz), (fx, fy, fz), (fx, fy, tz), (fx, ty, tz)], (-1, 0, 0),
                  [fz, 16 - ty, tz, 16 - fy]),
        "east":  ([(tx, ty, tz), (tx, fy, tz), (tx, fy, fz), (tx, ty, fz)], (1, 0, 0),
                  [16 - tz, 16 - ty, 16 - fz, 16 - fy]),
    }
    for name, (corners, normal, uv) in spec.items():
        if name in skip:
            continue
        axis_of_face = [i for i in range(3) if normal[i] != 0][0]
        material = side
        if grain is not None and AXES[grain] == axis_of_face:
            material = end
        u0, v0, u1, v1 = uv
        # corners are top-left, bottom-left, bottom-right, top-right as seen from outside
        uvs = [(u0, v0), (u0, v1), (u1, v1), (u1, v0)]
        g = AXES[grain] if grain is not None else None
        if g is not None and g != axis_of_face:
            # a face running along the member: v follows the length, u the thickness, both
            # centred on the sprite so short members sample its middle rather than an edge
            across_axis = 3 - g - axis_of_face
            length = to[g] - frm[g]
            across = to[across_axis] - frm[across_axis]
            vv0 = max(0.0, 8 - length / 2)
            vv1 = min(16.0, vv0 + length)
            uu0 = 8 - across / 2
            uu1 = uu0 + across
            # which screen direction the length runs in: top-left -> bottom-left is the first
            # edge of the corner list, so compare it with the grain axis
            first_edge = [corners[1][i] - corners[0][i] for i in range(3)]
            if abs(first_edge[g]) > 0:
                # length runs down the screen: the texture's natural orientation
                uvs = [(uu0, vv0), (uu0, vv1), (uu1, vv1), (uu1, vv0)]
            else:
                # length runs across the screen: turn the texture a quarter
                uvs = [(uu0, vv0), (uu1, vv0), (uu1, vv1), (uu0, vv1)]
        faces.append(Face(material, corners, uvs, normal))
    return faces


def pyramid(x0, z0, x1, z1, y0, height, facet, base=None, region=None, with_base=True):
    """A square pyramid on the base rectangle [x0,x1]x[z0,z1] at y0, apex `height` px above.
    `region` is the (u0, u1) span of the texture its facets are cropped from; default is the
    base's own x extent, so a full-width pyramid uses the whole sprite. Leave the base out
    (with_base=False) when it sits flush on another part and can never be seen."""
    base = base or facet
    cx, cz = (x0 + x1) / 2, (z0 + z1) / 2
    apex = (cx, y0 + height, cz)
    u0, u1 = region or (x0, x1)
    half = (x1 - x0) / 2
    slant = math.sqrt(height * height + half * half)
    v_apex = max(0.0, 16 - slant)
    faces = []
    # base-left, base-right as seen from outside; CCW with the apex
    for a, b, n in (((x1, y0, z0), (x0, y0, z0), (0, 0, -1)),
                    ((x0, y0, z0), (x0, y0, z1), (-1, 0, 0)),
                    ((x0, y0, z1), (x1, y0, z1), (0, 0, 1)),
                    ((x1, y0, z1), (x1, y0, z0), (1, 0, 0))):
        faces.append(Face(facet, [a, b, apex], [(u0, 16), (u1, 16), ((u0 + u1) / 2, v_apex)],
                          (n[0], 1, n[2])))
    if with_base:
        faces.append(Face(base, [(x0, y0, z0), (x1, y0, z0), (x1, y0, z1), (x0, y0, z1)],
                          [(x0, z0), (x1, z0), (x1, z1), (x0, z1)], (0, -1, 0)))
    return faces


def rotate(faces, axis, degrees, pivot):
    """Rotate faces about an axis through `pivot` (pixels). UVs are untouched, so a timber keeps
    its grain."""
    a = math.radians(degrees)
    c, s = math.cos(a), math.sin(a)
    i, j = {"x": (1, 2), "y": (2, 0), "z": (0, 1)}[axis]

    def rot(p, origin):
        p = list(p)
        di, dj = p[i] - origin[i], p[j] - origin[j]
        p[i] = origin[i] + di * c - dj * s
        p[j] = origin[j] + di * s + dj * c
        return tuple(p)

    zero = (0, 0, 0)
    for f in faces:
        f.verts = [rot(v, pivot) for v in f.verts]
        f.normal = rot(f.normal, zero)
    return faces


# ---------------------------------------------------------------------------------------------
# models
# ---------------------------------------------------------------------------------------------

def model_pyramid():
    """Sharpened logs and capstones: a full-block square pyramid, apex 16px up."""
    return pyramid(0, 0, 16, 16, 0, 16, "facet", "base")


def model_spikes():
    """Floor spikes: a 1px plate carrying a 3x3 grid of tall thin spikes."""
    faces = box((0, 0, 0), (16, 1, 16), "plate")
    for cx in (3, 8, 13):
        for cz in (3, 8, 13):
            # region: each spike crops the middle 4px of the sprite, so all nine match
            faces += pyramid(cx - 2, cz - 2, cx + 2, cz + 2, 1, 11, "spike", region=(6, 10),
                             with_base=False)
    return faces


def model_cheval_de_frise():
    """A log beam along x with two sharpened stakes through it, crossed at 45 degrees, so a row
    of them reads as the classic X-section barricade."""
    faces = box((0, 6, 6), (16, 10, 10), "bark", "end", grain="x")
    for cx, angle in ((4, 45), (12, -45)):
        stake = box((cx - 1.5, 8 - 8.5, 6.5), (cx + 1.5, 8 + 8.5, 9.5), "bark", "end", grain="y",
                    skip=("up", "down"))
        # sharpened tips on both ends; the bottom one is built pointing up, then flipped
        top = pyramid(cx - 1.5, 6.5, cx + 1.5, 9.5, 16.5, 2.5, "tip", region=(6.5, 9.5),
                      with_base=False)
        bottom = rotate(pyramid(cx - 1.5, 6.5, cx + 1.5, 9.5, 16.5, 2.5, "tip", region=(6.5, 9.5),
                                with_base=False), "x", 180, (cx, 8, 8))
        faces += rotate(stake + top + bottom, "x", angle, (cx, 8, 8))
    return faces


def model_walkway_bracket():
    """A knee brace for a wall: a post against the wall (the wall is at z=16), an arm along the
    top out to z=0, and a 45-degree strut between them. Authored facing north."""
    faces = box((6, 0, 12), (10, 16, 16), "wood", "end", grain="y")                  # post
    faces += box((6, 12, 0), (10, 16, 12), "wood", "end", grain="z", skip=("south",))  # arm
    # strut: a 3x3 timber from the post's face near the bottom to the arm's underside near its
    # end, built vertical through the midpoint and leaned 45 degrees toward the wall's front
    mz, my = 6.75, 6.75
    length = 15.6       # longer and the strut's lower corner dips below the block
    strut = box((6.5, my - length / 2, mz - 1.5), (9.5, my + length / 2, mz + 1.5), "wood", "end",
                grain="y")
    faces += rotate(strut, "x", -45, (8, my, mz))
    return faces


def _portcullis(bottom):
    """One cell of a portcullis lattice in the x-y plane (the gate spans along x). Vertical bars at
    x 3-5 and 11-13 and crossbars at y 3-5 and 11-13 repeat every 8px, so stacked and side-by-side
    blocks join into one continuous grid. The crossbars sit 1px proud of the uprights on both
    faces, the way a real portcullis is riveted from two layers. The bottom row's uprights stop
    at the lowest crossbar and end in spiked tips instead."""
    faces = []
    for x in (3, 11):
        if bottom:
            faces += box((x, 3, 7), (x + 2, 16, 9), "bar", grain="y", skip=("down",))
            tip = pyramid(x, 7, x + 2, 9, 16, 3, "bar", region=(x, x + 2), with_base=False)
            faces += rotate(tip, "z", 180, (x + 1, 9.5, 8))
        else:
            faces += box((x, 0, 7), (x + 2, 16, 9), "bar", grain="y")
    for y in (3, 11):
        faces += box((0, y, 6), (16, y + 2, 10), "bar", grain="x")
    return faces


def model_portcullis():
    return _portcullis(False)


def model_portcullis_bottom():
    return _portcullis(True)


def model_portcullis_winch():
    """The winch that raises a portcullis: a timber drum on an iron axle between two iron cheeks,
    drum along x. It sits on the floor of the room above the gate's slot."""
    faces = box((0, 0, 3), (2, 13, 13), "iron", grain="y")                     # cheeks
    faces += box((14, 0, 3), (16, 13, 13), "iron", grain="y")
    faces += box((2, 7, 7), (14, 9, 9), "iron", grain="x")                     # axle
    faces += box((3, 3, 3), (13, 13, 13), "drum", "drum_end", grain="x")       # drum
    # chain wound on the drum: three bands proud of it
    for x in (5, 7.5, 10):
        faces += box((x, 2.5, 2.5), (x + 1.5, 13.5, 13.5), "chain_band", grain="x")
    return faces


def spike(base, direction, length, width=1.5, material="spike"):
    """A square spike, `width` across, its base centred on `base`, pointing along `direction`
    (one of "+x", "-x", "+z", "-z", "+y")."""
    # region: crop from the middle of the sprite. The default (the base's own x extent) would be
    # -0.75..0.75 here - off the sprite's edge, into its neighbour in the atlas: that is how the
    # iron maiden's spikes first came out gold.
    p = pyramid(-width / 2, -width / 2, width / 2, width / 2, 0, length, material, with_base=False,
                region=(8 - width / 2, 8 + width / 2))
    turn = {"+z": ("x", 90), "-z": ("x", -90), "+x": ("z", -90), "-x": ("z", 90), "+y": None}[direction]
    if turn:
        p = rotate(p, turn[0], turn[1], (0, 0, 0))
    for f in p:
        f.verts = [(v[0] + base[0], v[1] + base[1], v[2] + base[2]) for v in f.verts]
    return p


# The iron maiden's spikes, in whole-object coordinates (it is 32 tall; front to the north). Its
# body and doors are Blockbench models (blockbench/iron_maiden_*.bbmodel); only the spikes are
# here, because JSON models cannot taper. Rows are placed so no spike straddles the half boundary
# at y=16. Door spikes are listed per door state: they swing with the doors.
MAIDEN_ROWS = (3.5, 9, 14.5, 20)


def _maiden_spikes(state):
    out = []
    for y in MAIDEN_ROWS:
        for x in (5, 8, 11):
            out.append(((x, y, 13), "-z", 3))              # back wall, pointing at the victim
        if state == "closed":
            for x in (5, 11):
                out.append(((x, y, 8), "+z", 2.5))         # door insides, pointing in
        else:
            out.append(((3, y, 4), "+x", 2.5))            # doors swung open: points across
            out.append(((13, y, 4), "-x", 2.5))
    return out


def _maiden(half, state):
    lo = 0 if half == "lower" else 16
    faces = []
    for base, direction, length in _maiden_spikes(state):
        if lo <= base[1] < lo + 16:
            faces += spike((base[0], base[1] - lo, base[2]), direction, length)
    return faces


MODELS = {
    "iron_maiden_spikes_lower_closed": (lambda: _maiden("lower", "closed"), ["spike"]),
    "iron_maiden_spikes_lower_open": (lambda: _maiden("lower", "open"), ["spike"]),
    "iron_maiden_spikes_upper_closed": (lambda: _maiden("upper", "closed"), ["spike"]),
    "iron_maiden_spikes_upper_open": (lambda: _maiden("upper", "open"), ["spike"]),
    "portcullis": (model_portcullis, ["bar"]),
    "portcullis_bottom": (model_portcullis_bottom, ["bar"]),
    "portcullis_winch": (model_portcullis_winch, ["iron", "drum", "drum_end", "chain_band"]),
    "pyramid": (model_pyramid, ["facet", "base"]),
    "spikes": (model_spikes, ["plate", "spike"]),
    "cheval_de_frise": (model_cheval_de_frise, ["bark", "end", "tip"]),
    "walkway_bracket": (model_walkway_bracket, ["wood", "end"]),
}


# ---------------------------------------------------------------------------------------------
# output
# ---------------------------------------------------------------------------------------------

def cross(u, v):
    return (u[1] * v[2] - u[2] * v[1], u[2] * v[0] - u[0] * v[2], u[0] * v[1] - u[1] * v[0])


def write_obj(name, faces, materials):
    lines = [f"# Generated by tools/gen_obj_models.py - edit that, not this.",
             f"mtllib {name}.mtl", f"o {name}"]
    vi = ti = ni = 0
    body = {m: [] for m in materials}
    for f in faces:
        a, b, c = f.verts[0], f.verts[1], f.verts[2]
        wn = cross(tuple(b[i] - a[i] for i in range(3)), tuple(c[i] - a[i] for i in range(3)))
        if all(abs(x) < 1e-9 for x in wn):      # degenerate first corner (a pyramid apex duplicate)
            continue
        # a uv off the sprite samples its neighbour in the texture atlas - some other block's
        # texture, silently (the iron maiden's spikes came out gold that way)
        assert all(-1e-6 <= c <= 16 + 1e-6 for t in f.uvs for c in t),             f"{name}: uv off the sprite ({f.material}): {f.uvs}"
        dot = sum(wn[i] * f.normal[i] for i in range(3))
        assert dot > 0, f"{name}: face wound inside-out ({f.material}, normal {f.normal})"
        ln = math.sqrt(sum(x * x for x in wn))
        n = tuple(round(x / ln, 6) for x in wn)
        refs = []
        for v, t in zip(f.verts, f.uvs):
            lines.append("v %.6g %.6g %.6g" % (v[0] / 16, v[1] / 16, v[2] / 16))
            lines.append("vt %.6g %.6g" % (t[0] / 16, 1 - t[1] / 16))
            vi += 1
            ti += 1
            refs.append((vi, ti))
        lines.append("vn %.6g %.6g %.6g" % n)
        ni += 1
        body[f.material].append("f " + " ".join(f"{v}/{t}/{ni}" for v, t in refs))
    for m in materials:
        if body[m]:
            lines.append(f"usemtl {m}")
            lines += body[m]
    open(OUT + name + ".obj", "w", newline="\n").write("\n".join(lines) + "\n")
    open(OUT + name + ".mtl", "w", newline="\n").write(
        "# Generated by tools/gen_obj_models.py. Each slot is filled per block by its model JSON.\n"
        + "".join(f"newmtl {m}\nmap_Kd #{m}\n\n" for m in materials))
    print(f"{name}.obj: {len(faces)} faces")


def main():
    for name, (build, materials) in MODELS.items():
        write_obj(name, build(), materials)


if __name__ == "__main__":
    main()
