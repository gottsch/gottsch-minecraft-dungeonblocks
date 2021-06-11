/**
 * 
 */
package com.someguyssoftware.dungeonblocks.item;

import java.util.function.Supplier;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.gottschcore.item.ModItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
	
    public static final Item LOGO = new ModItem(DungeonBlocks.MOD_ID, "dungeonblocks_logo", new Item.Properties());

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
            LOGO
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
    	public ItemStack makeIcon() {
    		return iconSupplier.get();
    	}
    }
}
