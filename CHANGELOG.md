# Changelog for DungeonBlocks 1.20.1

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [3.0.0] - 2026-07-26

### ⚠️ Breaking changes

- **Corner pieces on Ledge, Facade, Fluted Facade, Quarter Facade, Cornice, and Crown Molding blocks change meaning.** Their corner shape is now defined *relative to the direction the block faces*, the way vanilla stairs do it, instead of by absolute compass direction. This is what makes east- and west-facing corners work at all — previously only north–south runs rendered and collided correctly. There is no upgrade path: **corner pieces already placed in existing worlds will visibly change orientation** and need to be re-placed. Straight (non-corner) pieces are unaffected.
- **The Brazier's `lit` and `soul` blockstate properties are replaced by a single `fire` property**, with the values `none`, `embers`, `soul` and `lit`. Braziers already placed in existing worlds go back to `none` (unlit) on load, and any datapack or structure that set `lit`/`soul` on a Brazier needs updating.

### Added

- **Decorative entity props** — a new category of content. These are entities rather than blocks, so they sit anywhere in a block, react to being walked into, and are not limited to the block grid.
- **Terracotta Pots**, in three shapes. They fall under gravity, tip over when something walks into them, and shatter into a spray of ceramic debris on a fast enough collision or a fall of more than two blocks. Placing one against a wall spawns it already lying on its side. All three shapes share the name "Terracotta Pot" — they are a visual variation of one prop, not three things to tell apart by name.
- **Stone Pots**, **Red Pots**, and **Blue Pots** — the same three shapes in a cool grey stone palette, a brick red one, and a slate blue one. Each shatters into debris of its own colour: a pot's material is fixed by its type and travels to the shards it throws.
- Shattering a pot can drop loot. Each pot type has its own loot table (empty by default, and overridable by a datapack), and an individual pot can additionally carry a `LootTable` NBT tag — so a structure can put specific loot in a specific pot without affecting any other.
- **Swinging Chain** — a decorative chain that sways gently on its own and swings properly when something walks through it, settling over a couple of seconds. Longer chains swing more slowly. Stack them like vanilla chains; each segment is placed and broken individually, and breaking a link drops everything hanging below it.
- A **Lantern**, **Soul Lantern**, or **Dungeon Lantern** can be attached to the bottom of a swinging chain by right-clicking it with one. The lantern swings with the chain and lights the area; right-clicking with an empty hand takes it back off. A Dungeon Lantern attached this way is lit and extinguished with a torch or flint and steel, exactly like a placed one.
- **DungeonBlocks Entities** creative tab, holding the decorative entity props. They no longer appear in the main DungeonBlocks tab.
- Tall (3-block and 4-block) variants of the Spruce, Crimson, Dark Oak, and Mangrove Dungeon Doors, backported from the NeoForge 1.21.1 version. Placed and broken as a single unit like a vanilla door, generalized to any number of segments; the interior of the door reuses a single middle model/texture regardless of height, so a 3-tall and a 4-tall door of the same wood add no extra assets between them.
- **The Brazier has an `embers` state**: glowing coals with no flame, emitting light level 3. Mobs need block light 0 to spawn and block light drops by 1 per block, so a brazier at the usual light 15 sterilises an entire small dungeon room. At light 3 the brazier still reads as hot while most of a room's floor stays spawnable. The coals are drawn full-bright so they are visible in an otherwise dark room. The full range is now `fire=none` (0), `fire=embers` (3), `fire=soul` (10) and `fire=lit` (15), and the default is `none`.

### ⚙️ Changed

- Ceramic Pot items render as 3D models in the inventory, in hand, on the ground and in item frames, the way block items do, instead of as flat sprites.

### 🛠️ Fixed

- East- and west-facing corner pieces on Ledge, Facade, Fluted Facade, Quarter Facade, Cornice, and Crown Molding blocks now render at the correct rotation and have the correct collision box. Previously the two corner variants of an east- or west-facing run were drawn identically, and both fell back to a south-facing corner's collision box.
- Corner pieces inside a rotated structure keep their shape. A dungeon room placed at a 90 or 270 degree rotation used to come out with its corner pieces turned the wrong way.
- Corner pieces are now handled correctly in mirrored structure placements, which previously left the piece untouched.
- The collision box of a Crown Molding outer corner now matches its model; its lower moulding was two pixels shallower than it looked.
- Fluted Block and Fluted Facade blocks (straight, inner corner, and outer corner, in every material) no longer render dark when placed against full blocks. The flutes reach the sides of their own block, so ambient occlusion treated the neighbouring full block as shadowing them and shaded their faces almost black — the same problem the Sill and Sconce blocks had.
- Sill, Double Sill, Skeleton, Brazier (all three), Wall Sconce, and Candle Sconce (all variants) blocks no longer show an almost-black face where they sit against a neighbouring block. These models have steeply angled parts that reach the edge of their block, and shading them against the block next door darkened them far too much.
- The tops of the candles on a Candle Sconce are no longer black. Every sconce except a north-facing one had its candle tops mapped onto an empty region of the candle texture, so they drew as solid black. North-facing sconces were the only ones unaffected.
- Two-candle and three-candle Candle Sconce models were also missing their transparency setting, so see-through parts of the candle texture were drawn as solid black. The one-candle model was already correct.
- The top face of each candle on a Candle Sconce now shows the wax top of the candle rather than a slice of the candle's side.
- The third arm of the Candle Sconce sat almost entirely outside its own block, roughly three pixels into the neighbouring block. It is now positioned as a true mirror of the first arm, so the three arms are evenly spaced.
- 265 block models across 20 base models no longer render one or more faces as a magenta/black missing-texture checkerboard. Affected: every Crown Molding piece, Corbel, Barred Window Facade, Ledge inner corners, five Dungeon Door pieces, three Heavy Trapdoor pieces, two Sewer pieces, Wall Ring, Torch Sconce, and all three Braziers. The models referenced a texture variable nothing in their parent chain ever declared.
- Pillar Base blocks now render facing the direction they were placed against (previously always rendered in the default orientation, though the collision box rotated correctly).

### Known limitations

- Manacles as a chain fixture are planned but not yet implemented.
- Swinging chains must hang from a ceiling or from another chain, and cannot be placed in mid-air.
- Ceramic Pots drop nothing by default; the loot plumbing is in place but the shipped loot tables are intentionally empty.
- Tall doors currently reuse each door's own bottom texture as a placeholder for the middle segment texture pending dedicated tiling art.
- Tall doors have no crafting recipe yet (obtainable via creative/give only).

## [2.3.1] - 2026-07-12

### 🛠️ Fixed

- Pillar Base blocks now render facing the direction they were placed against (previously always rendered in the default orientation, though the collision box rotated correctly).

## [2.3.0] - 2025-05-12

### ⚙️ Changed

- now use DataGen for Cornice, Crown Molding, Facade, Pillar, Pillar Base, and Quarter Facade blocks, items, and loot tables.
- fixed weathering of all Copper variant blocks.
- remodeled Plate Bracket block slightly.
- uses GottschCore 2.4.0 (required)
- stone block families are now registered from a single data-driven material table, making new material variants a one-line addition (internal; no gameplay change).
- normalized stone-family block properties (hardness, blast resistance, sound, and tool requirement) to match their base vanilla material.
- copper Door and Trapdoor blockstates and models are now generated via DataGen (internal; no gameplay change).

### Added

- Angle Plate Bracket block
- Corner Plate Bracket block
- Copper variants for Plate, Angle Plate, and Corner Plate Bracket blocks.
- Tuff variants for all stone block types (Facade, Quarter Facade, Fluted, Fluted Facade, Sill, Double Sill, Cornice, Crown Molding, Pillar, and Pillar Base).
- Iron Angle Plate Bracket block
- Iron Corner Plate Bracket block
- Roots block (weeping-vines style hanging plant)
- Arrow Slit block for all stone material types

### 🛠️ Fixed

- Valve Wheels, Greek Blocks, and the Square/Large/Cobblestone/Gravel Brick blocks now drop when mined (they previously had no loot table and dropped nothing).
- Waxed Oxidized Copper Grate now uses the correct oxidized map color.
- corrected Stripped Cherry, Stripped Dark Oak, and Stripped Jungle Corbel textures and stonecutting recipes.
- Dark Iron Angle Plate Bracket now shows the correct (angle) model as its inventory icon instead of the corner model.
- Corner Plate Bracket and Valve Wheel blocks no longer render a missing-texture (magenta/black) speck on a small face (model referenced an undefined texture slot).
- Creative tab icon no longer appears jagged (now uses the Mossy Stone Bricks block instead of the non-square logo texture).

## [2.2.0] - 2025-05-05

### ⚙️ Changed

- now use DataGen for Double Sill, Sill, Fluted, and Fluted Facade blocks, items, and loot tables.
- rename Grate block to Heavy Grate.
- rename Grate Trapdoor block to Heavy Trapdoor.

### Added

- Square Brick block
- Mossy Square Brick block
- Square Stone Brick block
- Mossy Square Stone Brick block
- Left & Right Large Brick block
- Left & Right Large Stone Brick block
- Mossy Bricks block
- Large Bricks block
- Mossy Large Bricks block
- Copper Door variants (from 1.21)
- Copper Grate variants (from 1.21)
- Copper Trapdoor variants (from 1.21)
- Copper Heavy Grate variants
- Copper Heavy Trapdoor variants

## [2.1.0] - 2023-12-24

### ⚙️ Changed

- Fixed tool requirements for blocks

## [2.0.0] - 2023-12-15

### ⚙️ Changed

- Removed all variants of wall sconce
- Replaced wall sconce's torches with candles
- Updated grate to be a full block
- Fixed Cornice texture positioning
- All new blocks assets and data files are generated. Some older files were ported to generation.

### Added

- Grate Trapdoor (with variant)
- Barred window (with variants)
- Barred window facade (with variants)
- Torch sconce
- Brazier
- Sewer block (with variant)
- Dungeon Lantern (lit/unlit)
- Dungeon Door (with variants)
- Hay Patch (with variant)
- Wall Ring
- Pattern block (greek-esque)
- Corbel (with variants)
- Ledge (with variants)
- Plate Bracket

## [1.2.0] - 2023-10-24

### ⚙️ Changed

- Port from 1.19.3-1.2.0