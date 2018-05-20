package supersaix.monica.roguelike;

import java.util.Random;

import greymerk.roguelike.treasure.loot.provider.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import supersaix.monica.main.Main;
import supersaix.monica.main.ModSword;
import supersaix.monica.registry.SwordRegistry;

public class ItemSwords extends ItemBase {

	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};

	public ItemSwords(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		Item sword = null;
		if (level == 0) {
			
			switch(rand.nextInt(6)) {
			case 0: sword = SwordRegistry.swordBaselard; break;
			case 1: sword = SwordRegistry.swordGladius; break;
			case 2: sword = SwordRegistry.swordLongSword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		if (level == 1 || level == 2) {
			switch(rand.nextInt(9)) {
			case 0: sword = SwordRegistry.swordGladius; break;
			case 1: sword = SwordRegistry.swordBaselard; break;
			case 2: sword = SwordRegistry.swordLongSword; break;
			case 3: sword = SwordRegistry.swordBastard; break;
			case 4: sword = SwordRegistry.swordCliffKnife; break;
			case 5: sword = SwordRegistry.swordBroadsword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		if (level == 3) {
			switch(rand.nextInt(4)) {
			case 0: sword = SwordRegistry.swordCliffKnife; break;
			case 1: sword = SwordRegistry.swordBroadsword; break;
			default: return null;
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 5);
			return swordStack;
		}
		// ------------------------------------------------------------------------------------
		else {
			switch(rand.nextInt(4)) {
			case 0: sword = SwordRegistry.swordCliffKnife; break;
			case 1: sword = SwordRegistry.swordBroadsword; break;
			default: return null;
			}
			
			if (rand.nextInt(18) == 1) {
				switch(rand.nextInt(3)) {
				case 0: sword = SwordRegistry.swordSax; break;
				case 1: sword = SwordRegistry.swordKitchenKnife; break;
				default: sword = SwordRegistry.swordWiseOwl;
				}
			}
			
			ItemStack swordStack = new ItemStack(sword);
			((ModSword)sword).initSynthesis(swordStack);
			swordStack.getTagCompound().setFloat("Attack", 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 9);
			swordStack.getTagCompound().setFloat(getRandomStat(rand.nextInt(10)), 9);
			return swordStack;
		// ------------------------------------------------------------------------------------
		}
	}

	private String getRandomStat(int i) {
		return synthesisStats[i];
	}
}
