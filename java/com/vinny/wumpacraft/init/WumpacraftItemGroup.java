package com.vinny.wumpacraft.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WumpacraftItemGroup extends ItemGroup {
	
	public WumpacraftItemGroup() {
		
		super("wumpacraft");
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(WumpacraftItems.WUMPA_FRUIT);
	}
	
}
