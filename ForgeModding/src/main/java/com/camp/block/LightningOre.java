package com.camp.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.camp.entity.LightningOreZombie;
import com.matt.mod.MyMod;

public class LightningOre extends Block{
	public static final String name = "lightningOre";

	public LightningOre(){
		super(Material.iron);
		this.setUnlocalizedName(MyMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(15.0f);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#onEntityCollidedWithBlock(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.entity.Entity)
	 * When an EntityPlayer collides with a LightningOre, the world spawns in
	 * several LightningOreZombies around the player to swarm them.
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos,
			Entity entityIn) {
		// TODO Auto-generated method stub
		super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
		if(entityIn instanceof EntityPlayer){
			Random rand = new Random();
			int chance = rand.nextInt(100);
			if(chance <= 10){
				if(!worldIn.isRemote){
					int randX = rand.nextInt(11);
					int randY = rand.nextInt(5);
					int randZ = rand.nextInt(11);
					BlockPos newPos = new BlockPos(pos.getX() + randX - 5, 
							pos.getY() + randY - 2, pos.getZ() + randZ - 5 );
					BlockPos justAboveNew = new BlockPos(pos.getX() + randX - 5, 
							pos.getY() + randY - 2 + 1, pos.getZ() + randZ - 5 );
					if(!worldIn.checkBlockCollision(new AxisAlignedBB(newPos, justAboveNew))){
						LightningOreZombie myZombie = new LightningOreZombie(worldIn);
						myZombie.setPosition(pos.getX() + randX - 5, 
								pos.getY() + randY - 2, pos.getZ() + randZ - 5);
						worldIn.spawnEntityInWorld(myZombie);
					}	
				}
			}
		}
	}
	
}
	
