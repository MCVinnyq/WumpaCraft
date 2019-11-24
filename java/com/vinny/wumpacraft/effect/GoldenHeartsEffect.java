package com.vinny.wumpacraft.effect;

import net.minecraft.potion.AbsorptionEffect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class GoldenHeartsEffect extends AbsorptionEffect {
	
	public GoldenHeartsEffect(EffectType effectType, int number) {
		super(effectType, number);
	}
	
	@Override
	public boolean shouldRenderHUD(EffectInstance effect) {
		
		return false;
	}
	
	@Override
	public boolean shouldRender(EffectInstance effect) {
		
		return false;
	}
	
	@Override
	public boolean shouldRenderInvText(EffectInstance effect) {
		
		return false;
	}
	
}
