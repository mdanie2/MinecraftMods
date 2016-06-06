package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.matt.mod.MyMod;

public class LightningIngot extends Item{


	public final String name = "LightningIngot";
	
	public LightningIngot(){
		super();
		
		this.setUnlocalizedName(MyMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMaterials);

	}
}