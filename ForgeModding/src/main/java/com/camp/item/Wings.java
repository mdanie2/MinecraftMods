package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.mod.MyMod;

public class Wings extends Item{
	
	public static final String name = "wings";
	
	public Wings(){
		super();
		
		this.setUnlocalizedName(MyMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		playerIn.capabilities.allowFlying = !playerIn.capabilities.allowFlying;
		if(playerIn.capabilities.isFlying){
			if(playerIn.capabilities.getFlySpeed() >= 0.25F){
				playerIn.capabilities.setFlySpeed(0.0F);
			}
			playerIn.capabilities.setFlySpeed(playerIn.capabilities.getFlySpeed() + 0.05F);
		}	
		itemStackIn.damageItem(1, playerIn);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	
}
