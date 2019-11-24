package com.vinny.wumpacraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vinny.wumpacraft.init.WumpacraftItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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
		
		return Block.makeCuboidShape(0.1d, 0.1d, 0.1d, 15.9d, 15.9d, 15.9d);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		
		if(entityIn.getPosition().up(2).equals(pos)) {
			
			dropFruit(worldIn, pos, state.get(CRAFTED));
			worldIn.destroyBlock(pos, false);
			
		}
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		builder.add(CRAFTED);
	}
	
	@Override
	public void onLanded(IBlockReader worldIn, Entity entityIn) {
		
		// Bounce the player
		
		Vec3d motion = entityIn.getMotion();
        double originalMotionY = motion.y;
		
		if (motion.y < 0.0d) {
        	double d0 = entityIn instanceof LivingEntity ? 1.0d : 0.8d;
            entityIn.setMotion(motion.x, -motion.y * d0, motion.z);
        }
		
		// Break the crate and drop wumpa fruit
		
		if(originalMotionY < -0.25d) {
			World world = entityIn.getEntityWorld();
			BlockPos pos = entityIn.getPosition();
			
			dropFruit(world, pos, worldIn.getBlockState(pos).get(CRAFTED));
			world.destroyBlock(pos, false);
		}
		
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, net.minecraft.world.storage.loot.LootContext.Builder builder) {
		
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
		
		int fruitQuantity = 1;
		
		if(!wasCrafted) {
			
			Random rand = new Random();
			fruitQuantity = rand.nextInt(4) + 1;
			
		}
		
		world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(WumpacraftItems.WUMPA_FRUIT, fruitQuantity)));
		
	}
	
}
