package com.monica.roguelike;

import java.util.Random;
import com.monica.main.Main;
import com.monica.main.ModSword;

import greymerk.roguelike.treasure.loot.provider.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSwords extends ItemBase {

	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};

	public ItemSwords(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		Item sword = null;
		if (level == 0) {
			switch(rand.nextInt(4)) {
			case 0: sword = Main.swordBaselard; break;
			case 1: sword = Main.swordGladius; break;
			case 2: sword = Main.swordLongSword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		if (level == 1 || level == 2) {
			switch(rand.nextInt(8)) {
			case 0: sword = Main.swordGladius; break;
			case 1: sword = Main.swordBaselard; break;
			case 2: sword = Main.swordLongSword; break;
			case 3: sword = Main.swordBastard; break;
			case 4: sword = Main.swordCliffKnife; break;
			case 5: sword = Main.swordBroadsword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		if (level == 3) {
			switch(rand.nextInt(3)) {
			case 0: sword = Main.swordCliffKnife; break;
			case 1: sword = Main.swordBroadsword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		else {
			switch(rand.nextInt(3)) {
			case 0: sword = Main.swordCliffKnife; break;
			case 1: sword = Main.swordBroadsword; break;
			default: return null;
			}
			
			if (rand.nextInt(16) == 1) {
				switch(rand.nextInt(3)) {
				case 0: sword = Main.swordSax; break;
				case 1: sword = Main.swordKitchenKnife; break;
				default: sword = Main.swordWiseOwl;
				}
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10) + 1), 9);
			return swordStack;
		// ------------------------------------------------------------------------------------
		}
	}

	private String getRandomStat(int i) {
		return synthesisStats[i];
	}
}
