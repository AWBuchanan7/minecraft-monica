package com.monica.main;

import java.util.Arrays;
import java.util.Iterator;

import com.google.gson.JsonObject;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class SynthesisRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};
	private Item[] synthesisCrystals = {Main.crystalAttackSpectrumized, Main.crystalDurableSpectrumized, Main.crystalFlameSpectrumized, Main.crystalChillSpectrumized,
			Main.crystalLightningSpectrumized, Main.crystalCycloneSpectrumized, Main.crystalSmashSpectrumized, Main.crystalExorcismSpectrumized,
			Main.crystalBeastSpectrumized, Main.crystalScaleSpectrumized};

	private NBTBase nbt = new NBTTagCompound();
	private Item sword = null;
	ItemStack synthCrystal = null;
	ItemStack finalResult;
	
	@Override
	public boolean matches(InventoryCrafting inventory, World world) {

		ItemStack oldSword = null;
		synthCrystal = null;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {         
			if(inventory.getStackInSlot(i) != null) {
				ItemStack itemStack = inventory.getStackInSlot(i);

				if (itemStack.getItem() != null && (ModSword.class.isInstance(((Object)itemStack.getItem())))) {
					oldSword = itemStack;
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
		Iterator<String> iteratorStats = (Arrays.asList(synthesisStats)).iterator();
		Iterator<Item> iteratorCrystals = (Arrays.asList(synthesisCrystals)).iterator();

		while(iteratorStats.hasNext() && iteratorCrystals.hasNext()) {
			String stat = (String)iteratorStats.next();
			Item crystal = (Item)iteratorCrystals.next();

			if (synthCrystal.getItem().equals(crystal)) {
				float value = ((NBTTagCompound) nbt).getFloat(stat);
				finalResult = new ItemStack(sword);
				finalResult.setTagCompound((NBTTagCompound) nbt);
				finalResult.getTagCompound().setFloat(stat, value + 1.0F);
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

	public static class Factory implements IRecipeFactory {

		@Override
		public IRecipe parse(final JsonContext context, final JsonObject json) {

			return new SynthesisRecipe();
		}
	}

}
