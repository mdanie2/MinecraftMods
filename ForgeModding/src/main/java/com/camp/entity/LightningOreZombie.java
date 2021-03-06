package com.camp.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.camp.item.ItemManager;

public class LightningOreZombie extends EntityMob {

	//research having other mobs attack my custommob or custom mob attack other mobs
	public LightningOreZombie(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
		//research aiattackoncollide more
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
         
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}


	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0d);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.192324d);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0d);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.05d);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0d);
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public void dropFewItems(boolean recentlyHit, int lootLevel) {
	    int quantity = this.rand.nextInt(2) + 1;
	 
	    for (int i = 0; i < quantity; i++) {        
	            Item drop = ItemManager.lightningIngot;
	            this.dropItem(drop, 1);
	    }
	 
	}


	@Override
	public void onStruckByLightning(EntityLightningBolt lightningBolt) {
		// TODO Auto-generated method stub
		this.heal(30);
	}
	
	
	
}
