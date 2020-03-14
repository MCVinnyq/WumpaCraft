package com.vinny.wumpacraft.item;

import com.vinny.wumpacraft.init.WumpacraftEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GoldenWumpaFruit extends Item {

	public GoldenWumpaFruit(Properties properties) {
		super(properties);
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.EAT;
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		
		return 32;
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
       playerIn.setActiveHand(handIn);
       return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		PlayerEntity player = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
		
		if(!player.isCreative() || player == null) {
			
			stack.shrink(1);
			player.addPotionEffect(new EffectInstance(WumpacraftEffects.GOLDEN_HEARTS_EFFECT, 999999999, 4, false, false, false));
			
		}
		
		return stack;
	}
	
}
