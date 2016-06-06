package com.camp.entity;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.matt.mod.MyMod;
 
public class RenderCustomBiped extends RenderBiped {
 
	public static String png_name;
    
    public RenderCustomBiped(Class entityClass, ModelBiped model,
            float scale) {
        super(Minecraft.getMinecraft().getRenderManager(), model, scale);
        png_name = entityClass.getSimpleName();
        // TODO Auto-generated constructor stub
    }
 
     
 
    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        // TODO Auto-generated method stub
        return new ResourceLocation(MyMod.MODID, "textures/entity/" + png_name + ".png");
    }

 
}