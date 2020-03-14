package com.vinny.wumpacraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vinny.wumpacraft.init.WumpacraftBlocks;
import com.vinny.wumpacraft.init.WumpacraftItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BasicCrate extends Block {
	
	public static final BooleanProperty CRAFTED = BooleanProperty.create("crafted");
	
	public BasicCrate(Properties properties) {
		
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(CRAFTED, true));
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		
		// Block shape is slightly shorter than a normal block.
		// This is so that onEntityCollision is called when
		// players try to break the crate with their head.
		
		return Block.makeCuboidShape(0.0d, 0.1d, 0.0d, 16d, 16d, 16d);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		
		// This is called when players jump up and hit a crate with their head.
		
		dropFruit(worldIn, pos, state.get(CRAFTED));
		worldIn.destroyBlock(pos, false);
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		// This property saves whether the block was crafted or found naturally in the world.
		
		builder.add(CRAFTED);
	}
	
	@Override
	public void onLanded(IBlockReader worldIn, Entity entityIn) {
		
		Vec3d motion = entityIn.getMotion();
		BlockPos pos = entityIn.getPosition().down();
		
		double originalMotionY = motion.y;
		
		if(originalMotionY < 0.0d && worldIn.getBlockState(pos).getBlock() == WumpacraftBlocks.BASIC_CRATE) {
			
			entityIn.setMotion(motion.x, 0.0d, motion.z);
			
			if(originalMotionY < -0.25d) {
				
				// Bounce the player up 2 blocks
				
				entityIn.setMotion(motion.x, 0.75d, motion.z);
				
				// Drop the fruit and destroy the crate
				
				World world = entityIn.getEntityWorld();
				
				dropFruit(world, pos, worldIn.getBlockState(pos).get(CRAFTED));
				world.destroyBlock(pos, false);
			}
			
		}
		
		
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, net.minecraft.world.storage.loot.LootContext.Builder builder) {
		
		// If the crate was crafted by the player, it drops only 1 wumpa fruit.
		// Otherwise, it drops 1-4 wumpa fruit.
		
		int fruitQuantity = 1;
		
		if(!state.get(CRAFTED)) {
			
			Random rand = new Random();
			fruitQuantity = rand.nextInt(4) + 1;
			
		}
		
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(WumpacraftItems.WUMPA_FRUIT, fruitQuantity));
		
		return drops;

	}
	
	protected void dropFruit(World world, BlockPos pos, boolean wasCrafted) {
		
		// If the crate was crafted by the player, it drops only 1 wumpa fruit.
		// Otherwise, it drops 1-4 wumpa fruit.
		
		int fruitQuantity = 1;
		
		if(!wasCrafted) {
			
			Random rand = new Random();
			fruitQuantity = rand.nextInt(4) + 1;
			
		}
		
		world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(WumpacraftItems.WUMPA_FRUIT, fruitQuantity)));
		
	}
	
}
