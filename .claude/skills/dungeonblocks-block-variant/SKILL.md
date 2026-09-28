---
name: dungeonblocks-block-variant
description: How to add a block or block variant to the DungeonBlocks Forge mod — mossy overlays, rust/weathering stages, palette retones, non-cube shapes (points, slopes, angled timbers via OBJ), see-through doors, multi-block props with moving parts and their Blockbench models, and the registration, datagen, tag and verification steps they all share. Use this whenever the user asks for a mossy, rusted, weathered, cracked, chiseled, polished or otherwise retextured version of a block, a new stone material or block family, a new shape, door, prop or piece of furniture, or any new block in this repo at all — the block-tag trap in step 3 silently breaks drops on new blocks and applies even when no new texture is involved.
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
players have placed them. One standing answer: "make a mossy version of X" means **the full block
only** — the user said so (Mossy Tuff); offer the family, stairs or slab in one line instead.

**Is it a new shape, a door, or a multi-block prop?** Those have their own sections in step 2:
[shapes JSON cannot make](#shapes-json-cannot-make-points-slopes-angled-timbers),
[see-through doors](#see-through-doors) and
[multi-block props, moving parts and Blockbench models](#multi-block-props-moving-parts-and-blockbench-models).

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
| A mob's texture turned to stone, for its statue | `tools/gen_statue_textures.py` | a row to `JOBS` |
| A flat inventory icon for a prop whose model reads badly in a slot | `tools/gen_prop_item_icons.py` | a row to `HIDDEN_DOORS`, or a pixel mask |
| A tapestry scene (pristine + worn, icons) | `tools/gen_tapestry_textures.py` | a draw function in `SCENES`, then two `ModBlocks.tapestry(...)` lines and a `Recipes.tapestry(...)` |
| A crumbling floor in a new stone | `tools/gen_crumbling_floor_textures.py` | a stone to `STONES`, then a `crumblingFloor(...)` line in `ModBlocks` |
| A mob's head changed for a prop (blood on it) | `tools/gen_pike_head_textures.py` | a function, called from `main` |

Generated PNGs are overwritten on the next run, so never hand-edit them — fix the table instead.
(`tools/gen_banner_textures.py` is the same deal for the 36 banner textures.) One-off generators
exist too, each with its method in its docstring: `gen_iron_bars_door_textures.py` (its door FACES
were hand-touched by the user, so a plain run writes only the edge texture; `--faces` discards
their edits), `gen_polished_dark_iron_texture.py`, `gen_dirty_hay_texture.py`.

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
showing the user. `scripts/preview.py` (in this skill) renders block model JSONs, OBJ models and
plain cubes with their real textures, from any angle - its docstring has a worked example. It is
not the game's lighting: trust it for shape, UV mapping and texture choice, not brightness.

**But only when the user asks for one** - they have said rendered previews cost too many tokens
(memory `feedback-no-previews-unless-asked`); by default describe the result and let them judge it
in game. Whenever you tell the user a preview exists, **actually send it** (SendUserFile) and check the
send succeeded. A preview that silently fails to send reads to them as no preview at all.

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

### Shapes JSON cannot make (points, slopes, angled timbers)

JSON block models are axis-aligned boxes, rotatable only 22.5/45 degrees on one axis. Anything
sloped or pointed - the sharpened logs, capstones, spikes, cheval-de-frise, walkway bracket,
portcullis - is an **OBJ model through Forge's OBJ loader**, not a block entity renderer: it bakes
into the chunk mesh once and costs nothing per frame.

- **Add the shape to `tools/gen_obj_models.py`** (boxes and pyramids in pixel units, `grain` for
  wood direction, `rotate` for angles) and run it. Never hand-write an OBJ. The script asserts face
  winding (a backwards face is invisible) and that every UV lies on its sprite - an off-sprite UV
  silently samples the next texture in the atlas, which is how the iron maiden's spikes first came
  out gold.
- **Datagen:** `ModBlockStateProvider.objModel(name, obj, textures...)`; add the OBJ's material
  slots to its switch. Models root at `block_no_ao` (a child's own ambientocclusion flag is ignored).
- **One OBJ per shape, textures per block**, via the .mtl's `#slot` references - 11 woods or 34
  stones share one file.
- A block whose flat base must hide against what it sits on needs a real **occlusion shape** on
  that side only (see `PyramidBlock.slabs`) - not `noOcclusion`, and not a full cube, which would
  cull its neighbours' faces and leave holes.
- **Porting:** NeoForge 21.1 registers the loader as `neoforge:obj`, not `forge:obj`. Datagen writes
  the id, so a ported datagen emits the right one; the .obj/.mtl files carry over unchanged.

### See-through doors

Vanilla door models cut BOTH thin side edges from the hinge side's texture columns 0-2, and the caps
from the end rows. On a see-through door that shows gaps and hinges on the handle edge. Use
`ModBlockStateProvider.edgedDoor(block, textureName)`, whose `template_edged_door_*` parents read
the edges from a dedicated `<name>_edge.png` (strip layout in `gen_iron_bars_door_textures.py`).
A door that opens by hand but must keep villagers out and survive zombies keeps `BlockSetType.IRON`
and overrides `use()` (see `IronBarsDoorBlock`) - a hand-openable set type makes it a wooden door
to the AI. `ModBlockLootTables` has a `DoorBlock` branch so only the lower half drops.

### Multi-block props, moving parts and Blockbench models

The sarcophagus, iron maiden and gibbet are the worked examples.

- **Blockbench is the source.** One `blockbench/<name>_<part>.bbmodel` per block of the prop (the
  java_block format only allows -16..32). `tools/bbmodel_to_block_models.py` builds the game models:
  its JOBS table turns element GROUPS on or off per output (`doors_closed`/`doors_open`), splits a
  moving part out on its own, adds cullface to flush faces and converts per-texture UV sizes. A
  texture's NAME in Blockbench is the model's texture key. Never hand-edit the output.
- **A new prop's project is scaffolded, then belongs to Blockbench.** Describe it as boxes in
  `tools/gen_bbmodels.py` (its `bone`/`skull`/`head`/`candle`/`chain`/`iron_ring` helpers, groups for
  the converter to switch) and run it: it writes only the projects that do not exist yet, and never
  overwrites one without `--force <name>`, which discards the user's Blockbench edits. Then add its
  outputs to the converter's JOBS. Keep to whole pixels and 22.5-degree turns - the user wants the
  props "minecrafty" (memory `feedback-keep-props-minecrafty`). A part that rises above or sinks
  below the block (the pike's point) needs explicit UVs: vanilla's default mapping runs off the
  sprite there and samples its atlas neighbour, and the converter now stops on any UV off 0-16.
- **A statue of a mob** is its own model baked, not re-modelled: copy the mob model's
  `createBodyLayer()` into `tools/entity_models/`, pose it and bake it with `tools/entity_model.py`
  through `gen_obj_models.py` (the gargoyles), stone texture from `tools/gen_statue_textures.py`. A
  mob's flat planes are painted one side only - the baker handles it (memory `entity-model-baking`).
- **Parts:** two horizontal - extend `SlabTableBlock` (FOOT where clicked, HEAD ahead); two tall -
  a still prop is a `TallPropBlock` (the skull pike, the gargoyle statue: pass its two shapes), one
  with moving parts copies `IronMaidenBlock`; three tall - copy `GibbetBlock`'s enum PART. A tall
  prop that can hang (the gibbet) reads the clicked face: DOWN places its TOP part where clicked
  and grows down, anything else its BOTTOM part, growing up. Each: placement returns null
  unless every part's space is free, `updateShape` destroys the rest when a part goes,
  `playerWillDestroy` clears the dropping part with flag 35 in creative, and ONE part carries the
  drop in `ModBlockLootTables` (enum property - the helper rejects an IntegerProperty).
- **Layering models:** a MULTIPART blockstate draws every entry whose `when` matches, so a
  Blockbench body and OBJ spikes can share one state (the iron maiden).
- **A moving part is drawn like a chest lid: always by a renderer, never baked.** The sarcophagus
  tried stepped baked frames (choppy) and then baking at rest with a renderer only while moving,
  which **flickered at both hand-offs** - the renderer switches on the frame the state changes, the
  chunk re-mesh lands a frame or more later. Never split one visible part between the baked mesh
  and a renderer over time. No ticking is needed: keep client-only animation fields on the block
  entity and start a slide when the state differs from what is shown (`SarcophagusRenderer`).
  Keep a baked "closed" model for the item, which has no renderer. Register the part-only models in
  `ClientSetup` (`ModelEvent.RegisterAdditional`).
- **A baked model drawn by a renderer gets no directional light in a chunk render type.**
  `ModelBlockRenderer.renderModel` into `RenderType.cutout()`/`solid()` from a block entity renderer
  draws every face at full brightness, and dark iron comes out visibly lighter (the chain fixtures
  did). Two fixes: draw into `Sheets.cutoutBlockSheet()`, the entity sheet `renderSingleBlock` uses,
  lit by normal - match this when the part sits beside vanilla blocks a renderer draws (the chain's
  links); or apply `getShade` per face yourself, turned by the facing, to match the chunk exactly -
  when the part must match its own baked body (the sarcophagus lid).
- **A prop that holds items** (the weapon rack): keep the items in a block entity (a `NonNullList`,
  synced with `getUpdatePacket`/`getUpdateTag`, cleared before `loadAllItems`), make it
  `Clearable` so a structure can replace it without spilling, and drop the contents in `onRemove`.
  Draw them with `ItemRenderer.renderStatic(..., ItemDisplayContext.FIXED, ...)` in a renderer, so
  glint and modded models come free. The transform math is in memory `item-sprite-upright-in-ber`.
  An item has no renderer, so give the item model a static stand-in for what the renderer draws:
  `weapon_rack_item` uses item sprites on planes, which works because `textures/item/` is on the
  block atlas.
- **Mob textures in block models** need the texture added to the block atlas:
  `assets/minecraft/atlases/blocks.json` (the gibbet's skeleton). See-through textures need
  `render_type: cutout`, or the gaps draw black.
  A mob's HEAD on a prop takes its texture's head-box corner as it is: the `head` helper maps an
  8px cube from vanilla's skin layout, so a whole 64x64 mob texture (the zombie head pike, via the
  atlas) and a 32x16 head cut from one (the bloody Steve head) take the same UVs.
- **Hanging, as a lantern hangs** (the chandelier, the manacles, meat hook and censer):
  `Block.canSupportCenter(level, pos.above(), Direction.DOWN)` in `canSurvive`, and pop in
  `updateShape` when the block above changes. That accepts a sturdy ceiling and a vanilla chain
  (its 3px core covers the centre) and refuses a swinging chain, which has no collision shape.
- **Variety without a player choosing:** a state picked from `Mth.getSeed(pos)` on placement
  (the niche's REMAINS) varies a row of them with no effort, and client and server agree on it
  without a roll. A state the player builds up instead: stages added by using more of the same
  item on it, as pink petals do (the rubble scatter's CHIPS: `canBeReplaced` +
  `getStateForPlacement`), with a loot table that gives one back per stage. Either way the DEFAULT
  state is what a structure gets when it names none - keep it the look the block had before.
- **Wall hangings** (banners, pennants, tapestries): the ROD sits flush on the wall, the cloth
  hangs about 1px out from it - the user rejected both a floating rod and a cloth pressed flat.
  `TapestryBlock` is a 4x3 grid of parts placed as one (COLUMN/ROW ints, loot on (0,0) via a
  StatePropertiesPredicate); its part models are built in datagen as UV windows of one sprite, so
  a texture may be any whole multiple of 64x48 (the necromancer is 128x96 for detail).
- **Scene art:** cartoon shorthand - a round moon, V bats, stick limbs, a triangle body - reads as a
  child's drawing (the necromancer took three tries). Use silhouette, folds, rim light, dithered
  shading and atmosphere, and more resolution when a figure needs a face.
- **Flat item icons** (`tools/gen_prop_item_icons.py`): a door's lower half, or a 1px hook, turns
  into a slab or a hairline as a 3D item. Draw a sprite instead, as vanilla does for its doors,
  chain and lanterns, and give the item `basicItem(..., modLoc("item/<name>"))`.

### Properties traps

- **Never `Properties.copy` a vanilla log** onto a block without an `AXIS` property: its map-colour
  function reads AXIS and crashes on first lookup. Spell the properties out (see the palisade
  helper in `ModBlocks`).
- **`stateDefinition.any()` gives every unset boolean `true`.** A subclass that adds boolean
  properties to an inherited default must set them in `registerDefaultState`, or it places in the
  wrong state - every sarcophagus came out open and stuck.
- A carpet-like block with a see-through texture needs `noOcclusion()`, or it culls the top face of
  the block beneath and its gaps look through a hole in the ground.

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

**The same kind of silent trap in recipes:** a recipe whose RESULT is a vanilla item is saved by
default under that item's id - in the `minecraft` namespace - and **replaces vanilla's recipe**. The
hay-patch recipe did exactly this and removed wheat-to-hay-bale for as long as the mod was
installed. Give such a recipe its own id: `.save(recipe, new ResourceLocation(MOD_ID, "..."))`.
`src/generated/resources/data/minecraft/recipes/` should not exist.

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
