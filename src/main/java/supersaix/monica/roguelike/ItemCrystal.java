package supersaix.monica.roguelike;

import java.util.Random;

import greymerk.roguelike.treasure.loot.provider.ItemBase;
import net.minecraft.item.ItemStack;
import supersaix.monica.main.Main;
import supersaix.monica.registry.CrystalRegistry;

public class ItemCrystal extends ItemBase {

	public ItemCrystal(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {

		if (rand.nextInt(6) == 1) return null;
		
		switch(rand.nextInt(10)) {
		case 0: return new ItemStack(CrystalRegistry.crystalAttack);
		case 1: return new ItemStack(CrystalRegistry.crystalDurable);
		case 2: return new ItemStack(CrystalRegistry.crystalFlame, rand.nextInt(2) + 1);		
		case 3: return new ItemStack(CrystalRegistry.crystalChill, rand.nextInt(2) + 1);
		case 4: return new ItemStack(CrystalRegistry.crystalCyclone, rand.nextInt(2) + 1);
		case 5: return new ItemStack(CrystalRegistry.crystalLightning, rand.nextInt(2) + 1);
		case 6: return new ItemStack(CrystalRegistry.crystalExorcism, rand.nextInt(2) + 1);
		case 7: return new ItemStack(CrystalRegistry.crystalSmash, rand.nextInt(2) + 1);
		case 8: return new ItemStack(CrystalRegistry.crystalScale, rand.nextInt(2) + 1);
		default: return new ItemStack(CrystalRegistry.crystalBeast, rand.nextInt(2) + 1);
		}


	}
}
