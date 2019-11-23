package com.vinny.wumpacraft.init;

import com.vinny.wumpacraft.Wumpacraft;
import com.vinny.wumpacraft.item.GoldenWumpaFruit;
import com.vinny.wumpacraft.item.WumpaFruit;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Wumpacraft.MOD_ID)
public class WumpacraftItems {
	
	public static final Item WUMPA_FRUIT = new WumpaFruit(new Item.Properties().group(Wumpacraft.WUMPACRAFT_CREATIVE_TAB)).setRegistryName("wumpa_fruit");
	public static final Item GOLDEN_WUMPA_FRUIT = new GoldenWumpaFruit(new Item.Properties().group(Wumpacraft.WUMPACRAFT_CREATIVE_TAB).maxStackSize(1)).setRegistryName("golden_wumpa_fruit");
	
	@Mod.EventBusSubscriber(modid = Wumpacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			final Item[] items = {
					
					WUMPA_FRUIT,
					GOLDEN_WUMPA_FRUIT
					
			};
			
			event.getRegistry().registerAll(items);
			
		}
		
	}
	
}
