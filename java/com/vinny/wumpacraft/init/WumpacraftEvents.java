package com.vinny.wumpacraft.init;

import com.vinny.wumpacraft.Wumpacraft;

import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Wumpacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WumpacraftEvents {
	
	@SubscribeEvent
	public static void whenLivingEntityTakesDamage(final LivingDamageEvent event) {
		
		if(event.getEntityLiving().getActivePotionEffect(WumpacraftEffects.GOLDEN_HEARTS_EFFECT) != null || event.getEntityLiving().getAbsorptionAmount() - event.getAmount() <= 0) {
			
			event.getEntityLiving().removePotionEffect(WumpacraftEffects.GOLDEN_HEARTS_EFFECT);
			
		}
		
	}
	
	
	
}
