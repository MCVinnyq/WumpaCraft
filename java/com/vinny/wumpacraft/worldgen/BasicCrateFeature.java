package com.vinny.wumpacraft.worldgen;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.vinny.wumpacraft.block.BasicCrate;
import com.vinny.wumpacraft.init.WumpacraftBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BasicCrateFeature extends Feature<NoFeatureConfig> {

	public BasicCrateFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		BlockState state = WumpacraftBlocks.BASIC_CRATE.getDefaultState().with(BasicCrate.CRAFTED, false);
		
		if(worldIn.getBlockState(pos.down()) == Blocks.SAND.getDefaultState() && worldIn.isAirBlock(pos) && pos.getY() < 255 && state.isValidPosition(worldIn,pos)) {
			worldIn.setBlockState(pos, state, 2);
		}
		
		return false;
	}
	
	
	
}
