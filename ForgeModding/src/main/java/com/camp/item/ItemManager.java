package com.camp.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.matt.mod.MyMod;
 
public class ItemManager {
 
	public static LightningRod lightningRod;
	public static LightningIngot lightningIngot;
	public static LightningSword lightningSword;
	public static Wings wings;
	public static ZeussStaff staff;
	
    public static void mainRegistry() {
        initializeItem();
        registerItem();
    }

    public static void initializeItem() {
    	lightningRod = new LightningRod();
    	lightningIngot = new LightningIngot();
    	lightningSword = new LightningSword(MyMod.customToolMaterial);
    	wings = new Wings();
    	staff = new ZeussStaff();
    }

    public static void registerItem() {
    	GameRegistry.registerItem(lightningRod, lightningRod.name);
    	GameRegistry.registerItem(lightningIngot, lightningIngot.name);
    	GameRegistry.registerItem(lightningSword, lightningSword.name);
    	GameRegistry.registerItem(wings, wings.name);
    	GameRegistry.registerItem(staff, staff.name);
    }
 
}
