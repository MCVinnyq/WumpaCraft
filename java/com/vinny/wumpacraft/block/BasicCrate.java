package com.vinny.wumpacraft.block;

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
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BasicCrate extends Block {
	
	public static final BooleanProperty CRAFTED = BooleanProperty.create("crafted");
	
	public BasicCrate(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(CRAFTED, true));
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
		
		if (motion.y < 0.0D/*&& !entityIn.isSneaking()*/) {
        	double d0 = entityIn instanceof LivingEntity ? 1.0D : 0.8D;
            entityIn.setMotion(motion.x, -motion.y * d0, motion.z);
        }
		
		// Break the crate and drop wumpa fruit
		
		if(originalMotionY < -0.25d) {
			World world = entityIn.getEntityWorld();
			BlockPos pos = entityIn.getPosition().down();
			
			dropFruit(world, pos.getX(), pos.getY(), pos.getZ(), worldIn.getBlockState(pos).get(CRAFTED));
			world.destroyBlock(pos, false);
		}
		
	}
	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		
		// Drop wumpa fruit when block is broken
		
		dropFruit(worldIn.getWorld(), pos.getX(), pos.getY(), pos.getZ(), state.get(CRAFTED));
		
	}
	
	private void dropFruit(World world, double x, double y, double z, boolean wasCrafted) {
		
		int fruitQuantity = 1;
		
		if(!wasCrafted) {
			
			Random rand = new Random();
			fruitQuantity = rand.nextInt(4) + 1;
			
		}
		
		world.addEntity(new ItemEntity(world, x, y, z, new ItemStack(WumpacraftItems.WUMPA_FRUIT, fruitQuantity)));
		
	}
	
}
