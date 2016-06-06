package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.mod.MyMod;

public class ZeussStaff extends Item{
	
	public static final String name = "ZeusStaff";
	
	public ZeussStaff(){
		super();	
		this.setUnlocalizedName(MyMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
		this.setMaxDamage(250);
		this.setNoRepair();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		EntityLightningBolt bolt = new EntityLightningBolt(worldIn, playerIn.posX+ 4, playerIn.posY, playerIn.posZ+4);
		worldIn.setThunderStrength(3);
		worldIn.spawnEntityInWorld(bolt);
		worldIn.setThunderStrength(1);
		itemStackIn.damageItem(1, playerIn);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
}
