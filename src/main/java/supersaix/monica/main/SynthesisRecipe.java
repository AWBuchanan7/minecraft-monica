package supersaix.monica.main;

import java.util.Arrays;
import java.util.Iterator;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;
import supersaix.monica.registry.CrystalRegistry;

public class SynthesisRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};
	private Item[] synthesisCrystals = {CrystalRegistry.crystalAttackSpectrumized, CrystalRegistry.crystalDurableSpectrumized, CrystalRegistry.crystalFlameSpectrumized,
			CrystalRegistry.crystalChillSpectrumized, CrystalRegistry.crystalLightningSpectrumized, CrystalRegistry.crystalCycloneSpectrumized,
			CrystalRegistry.crystalSmashSpectrumized, CrystalRegistry.crystalExorcismSpectrumized, CrystalRegistry.crystalBeastSpectrumized, CrystalRegistry.crystalScaleSpectrumized};

	private NBTBase nbt = new NBTTagCompound();
	private Item sword = null;
	ItemStack synthCrystal = null;
	ItemStack finalResult = new ItemStack(CrystalRegistry.crystalDurableSpectrumized);
	
	@Override
	public boolean matches(InventoryCrafting inventory, World world) {

		ItemStack oldSword = null;
		synthCrystal = null;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {         
			if(inventory.getStackInSlot(i) != null) {
				ItemStack itemStack = inventory.getStackInSlot(i);

				if (itemStack.getItem() != null && (ModSword.class.isInstance(((Object)itemStack.getItem())))) {
					oldSword = itemStack;
					if (oldSword.getTagCompound() == null) {
						((ModSword)oldSword.getItem()).initSynthesis(oldSword);
					}
				}

				for (Item crystal : synthesisCrystals) {
					if (itemStack.getItem() != null && itemStack.getItem() == crystal) {
						synthCrystal = itemStack;
					} 
				}

			}
		}

		if (synthCrystal != null && oldSword != null && oldSword.getTagCompound() != null) { 
			nbt = oldSword.getTagCompound().copy();
			sword = oldSword.getItem();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		Float valueIncrease;
			
		Iterator<String> iteratorStats = (Arrays.asList(synthesisStats)).iterator();
		Iterator<Item> iteratorCrystals = (Arrays.asList(synthesisCrystals)).iterator();

		while(iteratorStats.hasNext() && iteratorCrystals.hasNext()) {
			String stat = (String)iteratorStats.next();
			Item crystal = (Item)iteratorCrystals.next();

			if (synthCrystal.getItem().equals(crystal)) {
				if (stat == "Attack" || stat == "Durable") {
					valueIncrease = 2.0F;
				} else {
					valueIncrease = 3.0F;
				}
				
				float value = ((NBTTagCompound) nbt).getFloat(stat);
				finalResult = new ItemStack(sword);
				finalResult.setTagCompound((NBTTagCompound) nbt);
				finalResult.getTagCompound().setFloat(stat, value + valueIncrease);
				return finalResult.copy();
			}
		}

		return null;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return finalResult;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height > 1;
	}

}
