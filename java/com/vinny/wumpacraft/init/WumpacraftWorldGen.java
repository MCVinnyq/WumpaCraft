package com.vinny.wumpacraft.init;

import com.vinny.wumpacraft.Wumpacraft;
import com.vinny.wumpacraft.worldgen.BasicCrateFeature;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Wumpacraft.MOD_ID)
public class WumpacraftWorldGen {
	
	@Mod.EventBusSubscriber(modid = Wumpacraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Biome> event) {
			
			Biomes.BEACH.addFeature(Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new BasicCrateFeature(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(10)));
			
		}
		
	}
	
	
}
