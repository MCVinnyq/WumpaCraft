package com.vinny.wumpacraft.init;

import com.vinny.wumpacraft.Wumpacraft;
import com.vinny.wumpacraft.effect.GoldenHeartsEffect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Wumpacraft.MOD_ID)
public class WumpacraftEffects {
	
	public static final Effect GOLDEN_HEARTS_EFFECT = new GoldenHeartsEffect(EffectType.BENEFICIAL, 2445989).setRegistryName("golden_hearts");
	
	@Mod.EventBusSubscriber(modid = Wumpacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerEffects(final RegistryEvent.Register<Effect> event) {
			
			event.getRegistry().register(GOLDEN_HEARTS_EFFECT);
			
		}
		
	}
	
}
