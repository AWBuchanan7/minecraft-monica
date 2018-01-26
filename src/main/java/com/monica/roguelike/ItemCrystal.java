package com.monica.roguelike;

import java.util.Random;
import com.monica.main.Main;
import greymerk.roguelike.treasure.loot.provider.ItemBase;
import net.minecraft.item.ItemStack;

public class ItemCrystal extends ItemBase {

	public ItemCrystal(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {

		if (rand.nextInt(6) == 1) return null;
		
		switch(rand.nextInt(10)) {
		case 0: return new ItemStack(Main.crystalAttack);
		case 1: return new ItemStack(Main.crystalDurable);
		case 2: return new ItemStack(Main.crystalFlame, rand.nextInt(1) + 1);		
		case 3: return new ItemStack(Main.crystalChill, rand.nextInt(1) + 1);
		case 4: return new ItemStack(Main.crystalCyclone, rand.nextInt(1) + 1);
		case 5: return new ItemStack(Main.crystalLightning, rand.nextInt(1) + 1);
		case 6: return new ItemStack(Main.crystalExorcism, rand.nextInt(1) + 1);
		case 7: return new ItemStack(Main.crystalSmash, rand.nextInt(1) + 1);
		case 8: return new ItemStack(Main.crystalScale, rand.nextInt(1) + 1);
		default: return new ItemStack(Main.crystalBeast, rand.nextInt(1) + 1);
		}


	}
}
