---
name: dungeonblocks-block-variant
description: How to add a block or block variant to the DungeonBlocks Forge mod — mossy overlays, rust/weathering stages, palette retones, and the registration, datagen, tag and verification steps they all share. Use this whenever the user asks for a mossy, rusted, weathered, cracked, chiseled, polished or otherwise retextured version of a block, a new stone material or block family, or any new block in this repo at all — the block-tag trap in step 3 silently breaks drops on new blocks and applies even when no new texture is involved.
---

# Adding a block variant to DungeonBlocks

This repo has a lot of machinery that makes most of this a table entry rather than new code. The
expensive mistakes are not in the code, though — they are in the texture judgement (step 1) and in
one tag trap that has silently shipped broken blocks four separate times (step 3). Spend your care
there.

## First, decide the shape of the work

**How many blocks?** A `ModMaterials.STONE` entry produces **11 decorative blocks** (facade,
quarter facade, fluted, fluted facade, sill, double sill, cornice, crown molding, pillar base,
pillar, arrow slit). That is the right call when the stone should behave like a full building
material. A single block is right when the stone is a pillar with a distinct top, or when nothing
else in the mod has that stone's decorative pieces. **Ask the user which they want if the request
is ambiguous** — the difference is 1 block versus 37, and it is not recoverable cheaply once
players have placed them.

**Does the texture already exist?** If so, skip to step 2.

## Step 1: The texture

Generate it. Do not hand-paint, and do not write a new script — extend an existing one by adding a
row to its table, then run it from the repo root. Each script's docstring is the authority on its
method.

| Want | Script | Add |
|---|---|---|
| Moss on a stone | `tools/gen_mossy_textures.py` | a `Job` to `JOBS` |
| Rust / age stages | `tools/gen_rusted_dark_iron_textures.py` | a stage to `STAGES` |
| One stone's pattern in another stone's colours | `tools/gen_deepslate_brick_textures.py` | a pair to `PAIRS` |

Generated PNGs are overwritten on the next run, so never hand-edit them — fix the table instead.
(`tools/gen_banner_textures.py` is the same deal for the 36 banner textures.)

### Moss

Moss is harvested from a vanilla pair that has both halves (`stone_bricks`/`mossy_stone_bricks`,
`cobblestone`/`mossy_cobblestone`): diff them, keep the pixels that turned green with their exact
colours, stamp that onto the target. Green pixels **only** — vanilla also nudges a few greys
between a base and its mossy twin, and those must not travel onto a foreign palette.

Two rules, each learned by getting it wrong and being corrected:

- **Moss is never re-toned to match its host.** It keeps vanilla's green on any rock, including
  near-black deepslate. Scaling moss darker to preserve a moss/stone luma ratio — which vanilla's
  own `mossy_cobblestone` happens to do — reads as grey-green grime rather than living growth. On
  dark stone the extra contrast is the point, not an error to calibrate away.
- **Protect the shade class that carries the stone's identity** (`Job.protect`). Identity can be a
  *hue* (polished andesite: only its brightest class is warm; every other class is
  indistinguishable from plain stone) or a *structure* (polished basalt: its dark blue-grey
  vertical striations). Cover it and you get something that reads as generic mossy grey stone.
  Deepslate needs no protection — its identity is that it is dark, and moss cannot bury darkness.

Pick the mask whose geometry suits the target (brick-like vs lumpy), and set `mirror=True` when two
textures share a mask, so they do not carry a pixel-identical moss pattern — that shows instantly
when the two are placed side by side.

### Rust and other ageing stages

Stages must read as *one object ageing*, not as three unrelated textures. The way to get that is
nested coverage: rank every pixel once, then a pixel rusted at one stage stays rusted at every
later stage, with coverage set by quantile so it is exact. Colour comes from how far inside the
coverage edge a pixel sits — new rust at the edges is dull brown, old rust in the middle turns
orange — and the un-aged metal dulls slightly each stage so it does not look freshly polished next
to heavy corrosion.

Three first-pass mistakes worth avoiding, all caught by eye:

- The earliest stage reading as orange. Tarnish is dull brown staining; orange belongs later.
- Full-height drip streaks. They read as painted stripes. Keep streaks short and weak.
- Saturated orange. It reads as terracotta rather than iron. Keep rust orange near `(130, 78, 47)`.

### Retone (one stone's pattern in another stone's colours)

When both source and target are flat palettes with the same number of shade classes, the retone is
a straight per-shade remap by luma rank, brightest to brightest. Check the result's mean luma lands
near the stone it is meant to sit beside — that is the objective test for "does this belong". The
luminance formula used for the pot textures is only needed for continuous-tone sources.

### Judge it on the model, not the swatch

**A flat 16×16 preview is not enough.** A texture sampled as thin strips — grates, bars, pillars,
trapdoors — reads completely differently in place. Render the actual model and look at it before
showing the user. `C:\Development\claude\minecraft\forge\dungeonblocks\3.0.0\rusted-grate\preview.py`
composites a model's faces over a floor/wall and is worth copying for this.

Then show the user the image and **wait**. Brightness and moss-placement calls have been wrong
before and were only caught by eye. Do not wire 37 blocks around an unapproved texture.

## Step 2: Registration and datagen

### Full material family

One entry in `ModMaterials.STONE`. For a stone vanilla ships no variant of:

```java
new Material("mossy_deepslate_bricks", Blocks.DEEPSLATE_BRICKS, modTexture("mossy_deepslate_bricks")),
```

`base` is **only** the properties source, so pass the plain vanilla block; `modTexture(...)` points
at the mod-owned PNG. A `Material` carries one texture, so every face of every decorative piece
uses it — fine for brick-like stones, wrong for anything with a distinct top.

Then, because the family loop only makes the 11 decorative types and never the plain cube:

- `ModBlocks` — register the full block by hand (follow `MOSSY_DEEPSLATE_BRICKS`).
- `ModBlockStateProvider` — `simpleBlock(...)` for it.
- `ItemModelsProvider` — `blockItemParent(ModBlocks.MAP.get(...))` for it.
- `DataGenMaps` — an `m2.put(...)` override pointing at the **variant** block, near the existing
  ones. `Material.base` is the plain vanilla block, so without this a future stonecutting recipe
  would produce mossy output from a plain ingredient. Only corbel and ledge generate stonecutting
  today, so it changes nothing now; it closes the trap.

### Single block

`MOSSY_POLISHED_BASALT` is the worked example: a `RotatedPillarBlock` copying vanilla properties,
`axisBlock(...)` in `ModBlockStateProvider`, one `blockItemParent(...)`. Use a rotated pillar
whenever the stone has a distinct top, so the top texture is actually used.

### Stairs and slabs

Not among the 11 family types — register explicitly (`MOSSY_DEEPSLATE_BRICK_STAIRS`). A slab also
needs adding to `BlockTags.SLABS` by hand; `ModBlockLootTables` already has a `SlabBlock` branch so
a double slab drops two.

### Why datagen mostly just works

The blockstate, item-model and recipe providers dispatch on **block-id substrings** against
`DataGenMaps.names`, in an order-dependent if/else chain (`fluted_facade` before `fluted`,
`quarter_facade` before `facade`). Name a block conventionally and it is picked up for free. That
same substring dispatch is what causes the trap below.

## Step 3: The tag trap — check this every single time

`ModBlockTagGenerator` tags by substring match against `DataGenMaps.stone_blocks`. **A block whose
id contains none of those substrings gets no tool tag at all, and if it copies
`requiresCorrectToolForDrops` from its base it then can never be mined for a drop.** It looks fine
in-world and silently drops nothing.

This is the single most repeated bug in this repo: the 2.3.0 loot incident, 30 of 39 arrow slits,
all 64 tool-requiring copper blocks, and it would have caught `mossy_deepslate_tiles` and
`mossy_cobbled_deepslate` (neither id contains "brick", "square", …).

The 11 decorative types are always safe — they match on "facade", "pillar", "sill". **It is the
plain full block, and any one-off block, that gets missed.** Verify rather than assume; step 4's
script checks this for you.

When a block is missed, prefer tagging it explicitly in `ModBlockTagGenerator` (see the Rubble and
mossy-deepslate-tiles comments) over adding a new substring to `stone_blocks` — a new substring
also pulls blocks into model and recipe generation. Adding a substring is right only when a whole
*category* is missing, as with `arrow_slit`. Match the tier the mod already uses for that family
rather than inventing one, and say so if that differs from vanilla.

## Step 4: Verify

```bash
./gradlew runData
./gradlew runData
```

Run it **twice**. The second run must report `removed stale: 0, written: 0`. That is the regression
test — it proves the block set and every generated file are stable. `written: 0` on a second run is
the strongest single signal that nothing drifted.

Then:

```bash
python .claude/skills/dungeonblocks-block-variant/scripts/verify_blocks.py <block_id> [<block_id> ...]
```

It checks every model texture reference in the mod resolves to a real PNG, and reports the tag and
loot-table status of each id you name. Run it with no arguments for the texture check alone.

Also confirm the tag diffs are purely additive:

```bash
git diff -U0 src/generated/resources/data/minecraft/tags | grep "^-" | grep -v "^---"
```

Expect no output. A single line for the previously-last entry in a list is fine — it only lost its
position and gained a trailing comma; confirm it is still present rather than assuming.

Never write files into `src/generated/` by hand. The next `runData` deletes them silently.

## Step 5: Naming and CHANGELOG

Follow vanilla's wording: `mossy_deepslate_bricks` (plural — the texture shows several bricks),
`mossy_polished_basalt`. The mod's square/large bricks are singular (`square_deepslate_brick`)
because one brick fills one block. Lang is generated from the id, so a good id gives a good name.

One real consequence: creative-tab **search matches display names as a contiguous string**. Blocks
named "Mossy *Square* Deepslate Brick" do not match a search for "mossy deepslate". The tab lists
every registered item with no opt-in, so "it's missing from the tab" is far more likely to be a
naming problem than a registration one — check the generated lang before hunting for a bug.

Update `CHANGELOG.md` in the repo root — the one doc that lives in the repo; everything else goes
under `C:\Development\claude\minecraft\forge\dungeonblocks\`. Write entries for a player: what the
block is and when they would use it, not which provider you touched.

## Reporting back

Say plainly what is verified and what is not. `runData` proves the files are consistent; it proves
nothing about whether the block looks right or drops correctly in game. Both have been wrong here
before and were only caught by playing. Flag anything you inferred by reading code rather than
observing — the copper drop bug was traced through properties, not witnessed.

If you fixed something outside what was asked, say so separately and explain why it was in scope.
