package com.vinny.wumpacraft.init;

import com.vinny.wumpacraft.Wumpacraft;
import com.vinny.wumpacraft.block.BasicCrate;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Wumpacraft.MOD_ID)
public class WumpacraftBlocks {
	
	public static final Block BASIC_CRATE = new BasicCrate(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f)).setRegistryName("basic_crate");
	
	@Mod.EventBusSubscriber(modid = Wumpacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			
			final Block[] blocks = {
					
					BASIC_CRATE
					
			};
			
			event.getRegistry().registerAll(blocks);
			
		}
		
		@SubscribeEvent
		public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
			
			final Item BASIC_CRATE_ITEM = new BlockItem(BASIC_CRATE, new Item.Properties().group(Wumpacraft.WUMPACRAFT_CREATIVE_TAB)).setRegistryName("basic_crate");
			
			final Item[] blockItems = {
					
					BASIC_CRATE_ITEM
					
			};
			
			event.getRegistry().registerAll(blockItems);
			
		}
		
	}
	
}
