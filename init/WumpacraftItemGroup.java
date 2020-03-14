package com.vinny.wumpacraft.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WumpacraftItemGroup extends ItemGroup {
	
	public WumpacraftItemGroup() {
		
		super("wumpacraft");
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(Item.BLOCK_TO_ITEM.get(WumpacraftBlocks.BASIC_CRATE));
	}
	
}
