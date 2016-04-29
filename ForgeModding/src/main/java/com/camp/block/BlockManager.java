package com.camp.block;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockManager {
	public static LightningBlock lightningBlock;
	public static LightningOre lightningOre;
	public static ZeusOre zeusOre;
	
    public static void mainRegistry() {
        initializeBlock();
        registerBlock();
    }
 
    public static void initializeBlock() {
    	lightningBlock = new LightningBlock();
    	lightningOre = new LightningOre();
    	zeusOre = new ZeusOre();
    }
 
    public static void registerBlock() {
    	GameRegistry.registerBlock(lightningBlock, lightningBlock.name);
    	GameRegistry.registerBlock(lightningOre, lightningOre.name);
    	GameRegistry.registerBlock(zeusOre, zeusOre.name);
    }
 
}
