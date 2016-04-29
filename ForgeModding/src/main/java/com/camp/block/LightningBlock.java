package com.camp.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.camp.item.ItemManager;
import com.matt.mod.MyMod;

public class LightningBlock extends Block{

	public final String name = "LightningBlock";
	
	public LightningBlock(){
		super(Material.iron);
        this.setUnlocalizedName(MyMod.MODID + "_" + name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(1.0f);
        this.setResistance(1000.0f);
        this.setHardness(27.0f);
	}
	
	@Override
	public boolean canProvidePower()
    {
        return true;
    }

	@Override
	public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return 10;
    }
    
	@Override
	public int quantityDropped(Random random)
	{
		int quantity = random.nextInt(5);
		return quantity;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		int chance = rand.nextInt(100);
		if(chance <= 5)
			return ItemManager.lightningRod;
		else if(chance <= 24)
			return Item.getItemFromBlock(this);
		else if(chance <= 29)
			return Item.getItemFromBlock(Blocks.beacon);
		else if(chance <= 39)
			return Item.getItemFromBlock(Blocks.redstone_block);
		else if(chance <= 59)
			return Item.getItemFromBlock(Blocks.tnt);
		else if(chance <= 69)
			return Items.ender_pearl;
		else if(chance <= 89)
			return ItemManager.lightningIngot;
		else
			return Items.emerald;
	}
    
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos,
            Entity entityIn) {
        // TODO Auto-generated method stub
        super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
         
        if(entityIn instanceof EntityLivingBase){
        	Random rand = new Random();
        	int chanceX = rand.nextInt(21);
        	int chanceZ = rand.nextInt(21);
            worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, pos.getX() + 10 - chanceX, 
            		pos.getY(), pos.getZ() + 10 - chanceZ));
        }   
    }
   
    
}
