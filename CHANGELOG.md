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
- **Big Potion** and **Flask**, in red, yellow, blue and green — breakable glass potion props in two bottle shapes. They behave exactly like a pot (fall, tip over, shatter on a hard hit or a fall), stand about half the height of one, and throw glass shards instead of ceramic ones. Breaking one releases a lingering effect cloud rather than loot, with vanilla lingering-potion timing and a colour taken from whatever it carries. All four colours share one model and one set of dimensions per shape — colour is a reskin, not a different prop.
- A potion's effects are a per-instance property, set the same way a pot's loot is: an individual potion carries `Potion` and/or `CustomPotionEffects` NBT — the same keys vanilla potion items use — so a structure can make one potion a trap and leave another inert. **A potion with nothing set releases nothing**, and the bottle's colour is unrelated to what it does; a red potion is not implicitly healing.
- **Stone Pots**, **Red Pots**, and **Blue Pots** — the same three shapes in a cool grey stone palette, a brick red one, and a slate blue one. Each shatters into debris of its own colour: a pot's material is fixed by its type and travels to the shards it throws.
- Shattering a pot can drop loot. Each pot type has its own loot table (empty by default, and overridable by a datapack), and an individual pot can additionally carry a `LootTable` NBT tag — so a structure can put specific loot in a specific pot without affecting any other.
- **Banners** — a two-block-tall wall hanging, narrow like a vanilla banner but tapering to a point instead of ending square. The cloth waves gently and continuously, rippling from the rod down to the hem, and neighbouring banners are offset from each other so a row of them does not move as one sheet. A banner hangs from its rod, so only its top block needs a wall behind it — one can drape over a doorway or into a stairwell — and breaking either half, or the single wall block it hangs on, takes the whole thing down for one item. You walk through them, as you would expect of cloth. They are **not** vanilla banners: no patterns, no dyes, no loom and nothing to stack — each one carries one fixed design.
- **Eighteen banners, in six factions**, each in three conditions. **Dungeon** is crimson under a bone cross, and runs plain, **Grimy** and **Tattered**. The other five run plain, **Tattered** and **Bloodstained**: the **Orc War Banner**, daubed on filthy sackcloth with a slit-pupil eye and claw marks; the **Undead Banner**, near-black grave linen carrying a bone skull over a spine; the **Dwarven Banner**, brass mountain and delving-strata on indigo; the **Cult Banner**, a sickly green sigil on deep violet; and the **Plague Banner**, a beak-masked plague doctor on pale sailcloth — the one banner in the set light enough to carry across a dark room. The wear is not cosmetic labelling: tattered banners have genuinely ragged hems and holes torn clean through the cloth that you can see the wall through — though never through the crest itself, so a banner always stays identifiable. All eighteen share one model, one block entity type and one renderer; the faction and the condition live entirely in the texture. The artwork is placeholder for now.
- **Pennants** — a one-block version of the banner, in all six factions: **Dungeon**, **Orc War**, **Undead**, **Dwarven**, **Cult** and **Plague**. Pristine only for now. Same cloth cut short (14px of drop rather than 30), so it hangs entirely inside its own block and needs only the one wall behind it — handy over a door frame, along a corridor, or anywhere a full banner would reach the floor. Each crest is laid out again for the shorter cloth rather than shrunk, and the secondary motifs the tall banners carry (the undead spine, the dwarven strata, the orc claw marks, the cult tally) are dropped so the primary emblem still reads. Pennants wave and can be stilled exactly like the tall banners.
- **A banner's motion can be switched off, per banner** — right-click one with an empty hand and its cloth goes still; right-click again and it resumes. This is a real `animated` blockstate, so it survives saving and can be set by a structure or datapack. `animateBanners`, in the new **visuals** section of the client config, sits over the top of that as a master switch: turning it off stills every banner on your own client, but it will never animate a banner somebody deliberately stilled. Still banners keep a slight bow so they read as cloth rather than as a painted board, and both switches take effect immediately — no reload or chunk rebuild.
- **Swinging Chain** — a decorative chain that sways gently on its own and swings properly when something walks through it, settling over a couple of seconds. Longer chains swing more slowly. Stack them like vanilla chains; each segment is placed and broken individually, and breaking a link drops everything hanging below it.
- A **Lantern**, **Soul Lantern**, or **Dungeon Lantern** can be attached to the bottom of a swinging chain by right-clicking it with one. The lantern swings with the chain and lights the area; right-clicking with an empty hand takes it back off. A Dungeon Lantern attached this way is lit and extinguished with a torch or flint and steel, exactly like a placed one.
- **DungeonBlocks Entities** creative tab, holding the decorative entity props. They no longer appear in the main DungeonBlocks tab.
- Tall (3-block and 4-block) variants of the Spruce, Crimson, Dark Oak, and Mangrove Dungeon Doors, backported from the NeoForge 1.21.1 version. Placed and broken as a single unit like a vanilla door, generalized to any number of segments; the interior of the door reuses a single middle model/texture regardless of height, so a 3-tall and a 4-tall door of the same wood add no extra assets between them.
- **Angle Cobweb**, in two variants — a purely decorative, walk-through web spanning the corner between two perpendicular surfaces (wall-to-ceiling or wall-to-floor) rather than sitting flush on one, tapering away from the junction it gathers into. No collision and none of a vanilla cobweb's movement slowdown.
- **Mossy Chiseled Stone Bricks** — a new STONE material family with no vanilla block to source it from, so it is craftable (Chiseled Stone Bricks + Vine) and usable as its own stonecutting ingredient.
- **Rubble** and **Mossy Rubble** — plain full blocks at cobblestone-grade properties, for filling in where a decorative pattern would be wasted.
- **Square Mud Brick** — the Square Stone Brick pattern in vanilla mud brick colours. One brick filling one block, like its stone counterpart.
- **Stairs, Facade and Quarter Facade** for both Square Stone Brick and Square Mud Brick.
- **Square Stone Brick Slab** and **Mossy Square Stone Brick Slab**.
- **Left and Right Large Mud Brick** — the two halves of a single large brick spanning two blocks, in the same mud brick colours.
- **Mossy Square Mud Brick** and **Mossy Left / Right Large Mud Brick** — mossy variants of all three, carrying the same moss the stone and clay bricks use.
- **Polished Andesite Bricks** and **Polished Andesite Brick Stairs** — a brick pattern in vanilla polished andesite's grey, at polished andesite's own properties. Andesite is the mod's usual trim stone, and until now there was no bricked form of it to run a course or a step in.
- **Mossy Polished Andesite Bricks** and **Mossy Polished Andesite Brick Stairs** — mossy variants of both. Vanilla has no mossy polished andesite to copy properties from, so like Mossy Bricks and Mossy Large Bricks they take theirs from Mossy Stone Bricks.
- **Square Deepslate Brick**, with **Stairs**, a **Slab**, a **Facade** and a **Quarter Facade** — the Square Stone Brick pattern in vanilla deepslate brick colours, one brick filling one block. The dark counterpart to the stone and mud sets, for building down where stone brick reads too bright.
- **Left and Right Large Deepslate Brick** — the two halves of a single large brick spanning two blocks, in the same deepslate colours.
- **Mossy Deepslate Bricks**, **Mossy Deepslate Tiles** and **Mossy Cobbled Deepslate** — three full material families, so each comes with the complete decorative set (facade, quarter facade, fluted, fluted facade, sill, double sill, cornice, crown molding, pillar, pillar base, arrow slit) on top of the full block. Vanilla ships no mossy deepslate in any form; the moss is vanilla's own clump pattern and vanilla's own green, stamped onto the deepslate palette rather than darkened to match it.
- **Mossy Deepslate Brick Stairs**.
- **Mossy Polished Basalt** — a rotated pillar like vanilla polished basalt, so it keeps a distinct top and side. Moss is deliberately kept off the dark vertical striations, which are what make basalt read as basalt rather than as generic grey stone.
- **Mossy Tuff** — a full block of tuff with vanilla's mossy cobblestone moss, kept off tuff's pale ash flecks so it still reads as tuff. Same properties as vanilla tuff.
- **Iron Bars Door** — a two-block cell door built from vanilla's own iron bars, so it sits in a wall of iron bars as a working cell front. Unlike the vanilla iron door it opens by hand, and redstone still opens it too. Villagers will not walk through it and zombies cannot break it down, so a cell holds whatever is kept in it. Crafted from an Iron Door and Iron Bars.
- **Sharpened Logs**, in every vanilla wood (Oak, Spruce, Birch, Jungle, Acacia, Dark Oak, Mangrove and Cherry Logs, Crimson and Warped Stems, and Bamboo) — the sharpened point of a stake. Set one on the end of a log to finish a palisade wall, a spiked barricade or a stockade gate. It points away from whatever face it is placed against, so it caps a sideways or hanging log as well as an upright one. The cut faces show the wood's stripped grain. Crafted from the stripped log (or stem, or bamboo block) and a Flint.
- **Tarnished**, **Rusted** and **Corroded Dark Iron Grates** and **Heavy Trapdoors** — three rust stages for each, in the spirit of the copper grates' four levels of oxidization. They are separate blocks rather than a weathering chain, since iron does not age in vanilla: place whichever stage the build calls for. Same properties as the plain dark iron versions; creative-only for now.
- **Chiseled Deepslate Bricks** and **Mossy Chiseled Deepslate Bricks** — vanilla's chiseled *stone brick* carving in the deepslate brick palette. Not a reskin of vanilla's Chiseled Deepslate, which carries a different carving on a notably darker stone: this one belongs to the deepslate *brick* family and sits at that family's brightness, so it can be set into a deepslate brick wall as a feature block without reading as a different material.
- **Mossy Square Deepslate Brick** (with **Stairs**, a **Slab**, a **Facade** and a **Quarter Facade**) and **Mossy Left / Right Large Deepslate Brick** — mossy variants of all three. This is the only square brick set whose facades come in mossy as well as plain. Vanilla has no mossy deepslate brick to copy properties from, so they take theirs from Deepslate Bricks. The moss is the same green the stone and mud bricks carry, not a darkened version of it — against deepslate it reads as living growth on near-black rock rather than as grime.
- **Mossy Square Stone Brick Stairs** — completes the Square Stone Brick family. The mossy full block and the plain stairs both already existed; the mossy stairs did not, so a run of square stone brick steps had no aged form to weather into.
- **The Brazier has an `embers` state**: glowing coals with no flame, emitting light level 3. Mobs need block light 0 to spawn and block light drops by 1 per block, so a brazier at the usual light 15 sterilises an entire small dungeon room. At light 3 the brazier still reads as hot while most of a room's floor stays spawnable. The coals are drawn full-bright so they are visible in an otherwise dark room. The full range is now `fire=none` (0), `fire=embers` (3), `fire=soul` (10) and `fire=lit` (15), and the default is `none`.

### ⚙️ Changed

- Ceramic Pot items render as 3D models in the inventory, in hand, on the ground and in item frames, the way block items do, instead of as flat sprites.

### 🛠️ Fixed

- **Doors no longer drop twice.** Breaking any of the mod's two-block doors — the Copper Doors in every stage, waxed or not, and the Spruce, Dark Oak, Crimson and Mangrove Dungeon Doors — dropped two doors, one for each half. Only the lower half drops now, as with vanilla doors.
- **Copper grates, heavy grates, valve wheels, trapdoors, heavy trapdoors and plate brackets drop themselves again.** All 64, in every oxidization stage and waxed, required the correct tool for drops but belonged to no tool tag, so nothing could mine them for a drop. They now need a stone pickaxe or better, like vanilla copper. Copper Doors and the Copper Sewer Block were never affected, but now also mine faster with a pickaxe.
- Dark Iron Grates and Dark Iron Heavy Trapdoors now mine faster with a pickaxe. They belonged to no tool tag, so a pickaxe broke them no quicker than a bare hand. They still drop to any tool, as before.
- **Arrow Slit blocks drop themselves again.** 30 of the 39 Arrow Slits belonged to no tool tag while still requiring the correct tool for drops, so they could never be mined for a drop by anything. Only the ones whose material name happened to contain a block-type keyword ("brick", "square") were tagged — meaning the Stone, Cobblestone, Granite, Diorite, Andesite, Blackstone, Sandstone, Tuff, Obsidian and most Deepslate variants were all affected.
- East- and west-facing corner pieces on Ledge, Facade, Fluted Facade, Quarter Facade, Cornice, and Crown Molding blocks now render at the correct rotation and have the correct collision box. Previously the two corner variants of an east- or west-facing run were drawn identically, and both fell back to a south-facing corner's collision box.
- Corner pieces inside a rotated structure keep their shape. A dungeon room placed at a 90 or 270 degree rotation used to come out with its corner pieces turned the wrong way.
- Corner pieces are now handled correctly in mirrored structure placements, which previously left the piece untouched.
- The collision box of a Crown Molding outer corner now matches its model; its lower moulding was two pixels shallower than it looked.
- Facade, Quarter Facade, Fluted Facade, Sill and Double Sill blocks (straight, inner corner and outer corner, in every material) no longer render almost black when placed against full blocks. These models reach the edges of their own block, so ambient occlusion treated the neighbouring full block as shadowing them. The models had asked for ambient occlusion to be turned off for some time, but the request was being silently discarded: Minecraft reads that setting from the *root* of a model's parent chain, and these models inherited from a vanilla model that leaves it switched on. They now inherit from a model that turns it off.
- Faces of Facade, Quarter Facade and Fluted Facade blocks that sit flush against a neighbouring full block are no longer drawn at all. Previously they were still rendered, taking their light level from inside the solid block next door and fighting with that block's own face for the same pixels, which showed as a black flickering seam.
- The tops of the candles on a Candle Sconce are no longer black. Every sconce except a north-facing one had its candle tops mapped onto an empty region of the candle texture, so they drew as solid black. North-facing sconces were the only ones unaffected.
- Two-candle and three-candle Candle Sconce models were also missing their transparency setting, so see-through parts of the candle texture were drawn as solid black. The one-candle model was already correct.
- The top face of each candle on a Candle Sconce now shows the wax top of the candle rather than a slice of the candle's side.
- The third arm of the Candle Sconce sat almost entirely outside its own block, roughly three pixels into the neighbouring block. It is now positioned as a true mirror of the first arm, so the three arms are evenly spaced.
- 265 block models across 20 base models no longer render one or more faces as a magenta/black missing-texture checkerboard. Affected: every Crown Molding piece, Corbel, Barred Window Facade, Ledge inner corners, five Dungeon Door pieces, three Heavy Trapdoor pieces, two Sewer pieces, Wall Ring, Torch Sconce, and all three Braziers. The models referenced a texture variable nothing in their parent chain ever declared.
- Pillar Base blocks now render facing the direction they were placed against (previously always rendered in the default orientation, though the collision box rotated correctly).
- The side of a Sill block no longer shows a seam down its middle. The sill is built from two halves and both were drawing the same half of the texture, so the pattern restarted midway along the block. The underside had the same fault. Cornice, Facade and Quarter Facade inner corners were affected in the same way.
- Angle Cobwebs break quickly again. A sword now cuts one in 8 ticks, the same as a vanilla cobweb, and anything else takes 12. They previously took a full 20 seconds to break with any tool and then dropped nothing at all: they took their hardness and their "requires the correct tool" flag from the vanilla cobweb, but nothing counts as the correct tool for them, because vanilla only grants a sword its speed and its harvesting ability on the vanilla cobweb block specifically.
- A Crown Molding outer corner now blends with the straight pieces either side of it. Its top surface was taking its colours from the corner of the texture, where many materials keep a lighter edge, while its neighbours took theirs from the middle — so the corner read as a brighter patch rather than as a continuation of the run.
- Dungeon Lanterns and Sconces placed by a structure, a datapack or a command are no longer waterlogged. Their default state had every on/off property switched on, so anything that started from the default and did not explicitly say otherwise got a lantern that was hanging and full of water, and the water poured out across the floor around it. Lanterns and sconces placed by hand were never affected.

### Known limitations

- Manacles as a chain fixture are planned but not yet implemented.
- Swinging chains must hang from a ceiling or from another chain, and cannot be placed in mid-air.
- Ceramic Pots drop nothing by default; the loot plumbing is in place but the shipped loot tables are intentionally empty.
- Tall doors have no crafting recipe yet (obtainable via creative/give only).
- Square Stone Brick and Square Mud Brick stairs and facades have no crafting recipe yet (obtainable via creative/give only).
- Polished Andesite Brick blocks and stairs, in both plain and mossy, have no crafting recipe yet (obtainable via creative/give only), and neither do Mossy Square Stone Brick Stairs.

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