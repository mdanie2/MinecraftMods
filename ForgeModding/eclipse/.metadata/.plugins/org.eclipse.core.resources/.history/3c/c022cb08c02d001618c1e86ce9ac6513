package com.camp.item;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.matt.mod.MyMod;

public class LightningRod extends Item{
	
	public static final String name = "LightningRod";
	
	public LightningRod(){
		super();
		
		this.setUnlocalizedName(MyMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		Random rand = new Random();
		int prev = (int) worldIn.thunderingStrength;
		worldIn.thunderingStrength = rand.nextInt(20) + 1;
		worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, pos.getX() + hitX , pos.getY() + hitY, pos.getZ() + hitZ));
		worldIn.thunderingStrength = prev;
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}
	
	

}
