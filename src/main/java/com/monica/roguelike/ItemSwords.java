package com.monica.roguelike;

import java.util.Random;
import com.monica.main.Main;
import com.monica.main.ModSword;

import greymerk.roguelike.treasure.loot.provider.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemSwords extends ItemBase {

	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};
	
	public ItemSwords(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		
		if (level == 0) {
			if (rand.nextInt(3) == 1) return null;
			
			Item sword = Main.swordBaselard;
			ItemStack y = new ItemStack(sword);
			((ModSword)sword).initSynthesis(y);
			y.getTagCompound().setFloat("Attack", 5);
			return new ItemStack(Main.swordBaselard);
		}
		
		if (level == 1 || level == 2) {
			if (rand.nextInt(2) == 1) return null;
			
			if (rand.nextInt(20) == 1) {
				Item sword = Main.swordBroadsword;
				ItemStack y = new ItemStack(sword);
				((ModSword)sword).initSynthesis(y);
				y.getTagCompound().setFloat("Attack", 10);
				y.getTagCompound().setFloat(getRandomStat(rand), 5);
				y.getTagCompound().setFloat(getRandomStat(rand), 8);
				return y;
			}
			
			switch(rand.nextInt(14)){
			case 0: return new ItemStack(Main.swordSax);
			case 1: return new ItemStack(Main.swordKitchenKnife);
			case 2: return new ItemStack(Main.swordWiseOwl);
			case 3: return new ItemStack(Main.swordBroadsword);
			case 4: return new ItemStack(Main.swordBroadsword);
			case 5: return new ItemStack(Main.swordBroadsword);
			default: return new ItemStack(Main.swordBaselard);
			}
		}
		
		else {
			if (rand.nextInt(3) == 1) return null;
			ItemStack x = new ItemStack(Main.swordBroadsword);
			switch(rand.nextInt(10)){
			case 0: x = new ItemStack(Main.swordSax);
			case 1: x = new ItemStack(Main.swordKitchenKnife);
			case 2: x = new ItemStack(Main.swordWiseOwl);
			case 3: x = new ItemStack(Main.swordSerpentSlicer);
			case 4: x = new ItemStack(Main.swordChoora);
			default: x = new ItemStack(Main.swordBroadsword);
			(new ModSword(ToolMaterial.STONE)).initSynthesis(x);
			x.getTagCompound().setFloat("Attack", 15);
			return x;
			}
		}
	}
	
	private String getRandomStat(Random rand) {
		switch(rand.nextInt(10)){
		case 0: return synthesisStats[0];
		case 1: return synthesisStats[1];
		case 2: return synthesisStats[2];
		case 3: return synthesisStats[3];
		case 4: return synthesisStats[4];
		case 5: return synthesisStats[5];
		case 6: return synthesisStats[6];
		case 7: return synthesisStats[7];
		case 8: return synthesisStats[8];
		default: return synthesisStats[9];
		}
	}
}
