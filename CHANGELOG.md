# Changelog for DungeonBlocks 1.20.1

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [3.0.0] - 2026-07-26

### Added

- **Decorative entity props** — a new category of content. These are entities rather than blocks, so they sit anywhere in a block, react to being walked into, and are not limited to the block grid.
- Ceramic Pots, in three shapes: **Ceramic Pot**, **Tall Ceramic Pot**, and **Thin Ceramic Pot**. They fall under gravity, tip over when something walks into them, and shatter into a spray of ceramic debris on a fast enough collision or a fall of more than two blocks. Placing one against a wall spawns it already lying on its side.
- Shattering a pot can drop loot. Each pot type has its own loot table (empty by default, and overridable by a datapack), and an individual pot can additionally carry a `LootTable` NBT tag — so a structure can put specific loot in a specific pot without affecting any other.
- **Swinging Chain** — a decorative chain that sways gently on its own and swings properly when something walks through it, settling over a couple of seconds. Longer chains swing more slowly. Stack them like vanilla chains; each segment is placed and broken individually, and breaking a link drops everything hanging below it.
- A **Lantern**, **Soul Lantern**, or **Dungeon Lantern** can be attached to the bottom of a swinging chain by right-clicking it with one. The lantern swings with the chain and lights the area; right-clicking with an empty hand takes it back off. A Dungeon Lantern attached this way is lit and extinguished with a torch or flint and steel, exactly like a placed one.
- **DungeonBlocks Entities** creative tab, holding the decorative entity props. They no longer appear in the main DungeonBlocks tab.
- Tall (3-block and 4-block) variants of the Spruce, Crimson, Dark Oak, and Mangrove Dungeon Doors, backported from the NeoForge 1.21.1 version. Placed and broken as a single unit like a vanilla door, generalized to any number of segments; the interior of the door reuses a single middle model/texture regardless of height, so a 3-tall and a 4-tall door of the same wood add no extra assets between them.

### ⚙️ Changed

- Ceramic Pot items render as 3D models in the inventory, in hand, on the ground and in item frames, the way block items do, instead of as flat sprites.

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