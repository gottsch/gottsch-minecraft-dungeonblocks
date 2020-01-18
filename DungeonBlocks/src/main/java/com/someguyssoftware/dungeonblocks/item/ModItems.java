/**
 * 
 */
package com.someguyssoftware.dungeonblocks.item;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

/**
 * @author Mark Gottschling on Jan 13, 2020
 * This class has the register event handler for all custom items.
 * This class uses @Mod.EventBusSubscriber so the event handler has to be static
 * This class uses @ObjectHolder to get a reference to the items
 *
 */
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DungeonBlocks.MOD_ID)
public class ModItems {
//	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(DungeonBlocks.MOD_ID,
//			() -> new ItemStack(Items.ACACIA_SAPLING)); // TODO change my icon
	
	
    public static final Item test_item = null;

    /**
     * The actual event handler that registers the custom items.
     *
     * @param event The event this event handler handles
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //In here you pass in all item instances you want to register.
        //Make sure you always set the registry name.
        event.getRegistry().registerAll(

            new Item(new Item.Properties()).setRegistryName(DungeonBlocks.MOD_ID, "test_item")
        );
    }

    /**
     * 
     * @author Mark Gottschling on Jan 17, 2020
     *
     */
    public static class ModItemGroup extends ItemGroup {
    	private final Supplier<ItemStack> iconSupplier;

    	public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
    		super(name);
    		this.iconSupplier = iconSupplier;
    	}

    	@Override
    	public ItemStack createIcon() {
    		return iconSupplier.get();
    	}
    }
}
