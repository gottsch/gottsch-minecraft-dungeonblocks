"""
Post-datagen checks for DungeonBlocks. Run from the repo root, after `./gradlew runData`.

    python .claude/skills/dungeonblocks-block-variant/scripts/verify_blocks.py [block_id ...]

Always checks that every texture referenced by every generated model actually exists -- a missing
PNG shows in game as a purple-and-black block rather than as any kind of error.

For each block id given, reports whether it has a tool tag. That matters because a block that
copies requiresCorrectToolForDrops from its base but belongs to no tool tag can never be mined for
a drop, and nothing about it looks wrong until someone tries. The tag generator assigns tags by
substring-matching block ids, so newly added blocks whose names don't happen to contain one of the
expected substrings fall through the gap. This has shipped broken blocks several times.

Exit status is non-zero if anything is missing, so it can gate a commit.
"""
import glob
import json
import os
import sys

REPO_TEXTURES = "src/main/resources/assets/dungeonblocks/textures/"
MODELS = "src/generated/resources/assets/dungeonblocks/models/**/*.json"
TAGS = "src/generated/resources/data/minecraft/tags/blocks/"
LOOT = "src/generated/resources/data/dungeonblocks/loot_tables/blocks/"
BLOCKSTATES = "src/generated/resources/assets/dungeonblocks/blockstates/"
# a few older blocks (the dungeon lantern, for one) predate datagen and keep a hand-written
# blockstate here instead
HAND_BLOCKSTATES = "src/main/resources/assets/dungeonblocks/blockstates/"

TIER_TAGS = ["needs_stone_tool", "needs_iron_tool", "needs_diamond_tool"]


def fail(msg):
    print(f"  FAIL  {msg}")


def load_tag(name):
    path = f"{TAGS}{name}.json"
    if not os.path.exists(path):
        return set()
    with open(path) as fh:
        return set(json.load(fh).get("values", []))


def check_textures():
    """Every dungeonblocks: texture referenced by a generated model must exist."""
    missing = {}
    for path in glob.glob(MODELS, recursive=True):
        with open(path) as fh:
            model = json.load(fh)
        for value in (model.get("textures") or {}).values():
            if isinstance(value, str) and value.startswith("dungeonblocks:"):
                png = REPO_TEXTURES + value.split(":", 1)[1] + ".png"
                if not os.path.exists(png):
                    missing.setdefault(value, []).append(os.path.basename(path))
    print(f"Texture references: {'OK' if not missing else str(len(missing)) + ' MISSING'}")
    for value, models in sorted(missing.items()):
        fail(f"{value} referenced by {', '.join(sorted(models)[:3])}"
             + (" ..." if len(models) > 3 else ""))
    return not missing


def check_block(block_id):
    """Report tag, blockstate and loot status for one block id."""
    ref = f"dungeonblocks:{block_id}"
    ok = True
    print(f"\n{block_id}")

    if os.path.exists(f"{HAND_BLOCKSTATES}{block_id}.json"):
        print("  ok    blockstate is hand-written (src/main/resources), not generated")
    elif not os.path.exists(f"{BLOCKSTATES}{block_id}.json"):
        fail("no blockstate generated -- is it registered, and did runData succeed?")
        ok = False

    if not os.path.exists(f"{LOOT}{block_id}.json"):
        fail("no loot table generated -- it will drop nothing when mined")
        ok = False

    mineable = [t for t in ("pickaxe", "axe", "shovel", "hoe")
                if ref in load_tag(f"mineable/{t}")]
    if mineable:
        tiers = [t for t in TIER_TAGS if ref in load_tag(t)]
        print(f"  ok    mineable_with_{'/'.join(mineable)}"
              f"{', ' + '/'.join(tiers) if tiers else ', any tier'}")
    else:
        fail("in NO mineable tag -- if it requires the correct tool it can never drop. "
             "Tag it explicitly in ModBlockTagGenerator.")
        ok = False

    return ok


def main():
    if not os.path.isdir("src/generated"):
        sys.exit("run me from the repo root (no src/generated here)")

    ok = check_textures()
    for block_id in sys.argv[1:]:
        ok &= check_block(block_id)

    if not sys.argv[1:]:
        print("\n(pass block ids to also check their tags and loot tables)")
    print("\n" + ("all checks passed" if ok else "PROBLEMS FOUND -- see FAIL lines above"))
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
