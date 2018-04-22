package com.monica.main;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class BuildUpRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};
	private NBTBase nbt = new NBTTagCompound();
	private Item sword = null;
	ItemStack finalResult = new ItemStack(Main.crystalDurableSpectrumized);
		
	@Override
	public boolean matches(InventoryCrafting inventory, World world) {

		ItemStack oldSword = null;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if(inventory.getStackInSlot(i) != null) {
				ItemStack itemStack = inventory.getStackInSlot(i);
				if (itemStack.getItem() != Items.AIR && !ModSword.class.isInstance(((Object)itemStack.getItem()))) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < inventory.getSizeInventory(); i++) {         
			if(inventory.getStackInSlot(i) != null) {
				ItemStack itemStack = inventory.getStackInSlot(i);

				if (itemStack.getItem() != null) {
					if (ModSword.class.isInstance(((Object)itemStack.getItem())) ) {
						oldSword = itemStack;
						if (oldSword != null && oldSword.getTagCompound() != null) {
							nbt = oldSword.getTagCompound().copy();
						} else {
							((ModSword)oldSword.getItem()).initSynthesis(oldSword);
						}
						sword = oldSword.getItem();
						return true;
					}
				}
			}
		}

		return false;

	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		// Get all synthesis stats for the checks below
		float attackValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[0]);
		float durableValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[1]);
		float flameValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[2]);
		float chillValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[3]);
		float lightningValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[4]);
		float cycloneValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[5]);
		float smashValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[6]);
		float exorcismValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[7]);
		float beastValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[8]);
		float scaleValue = ((NBTTagCompound) nbt).getFloat(synthesisStats[9]);

		finalResult = new ItemStack(sword);
		
		/*
		 * TIER TWO
		 */
		if (((ModSword)sword).getSwordName() == "sword_longsword"
				&& attackValue > 20.0F
				&& smashValue > 18.0F
				&& beastValue > 13.0F) {
			finalResult = new ItemStack(Main.swordBastard);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_longsword"
				&& attackValue > 19.0F
				&& cycloneValue > 18.0F
				&& exorcismValue > 18.0F) {
			finalResult = new ItemStack(Main.swordBroadsword);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_gladius"
				&& attackValue > 19.0F
				&& cycloneValue > 13.0F
				&& beastValue > 13.0F) {
			finalResult = new ItemStack(Main.swordCliffKnife);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_baselard"
				&& attackValue > 19.0F
				&& cycloneValue > 18.0F
				&& exorcismValue > 18.0F) {
			finalResult = new ItemStack(Main.swordBroadsword);
		}
		
		/*
		 * TIER THREE
		 */
		if (((ModSword)sword).getSwordName() == "sword_bastard"
				&& attackValue > 30.0F
				&& flameValue > 22.0F
				&& lightningValue > 8.0F
				&& exorcismValue > 8.0F) {
			finalResult = new ItemStack(Main.swordSandBreaker);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_cliffknife"
				&& attackValue > 28.0F
				&& cycloneValue > 26.0F
				&& beastValue > 35.0F) {
			finalResult = new ItemStack(Main.swordChopper);
		}
		if (((ModSword)sword).getSwordName() == "sword_cliffknife"
				&& attackValue > 30.0F
				&& flameValue > 22.0F
				&& lightningValue > 8.0F
				&& exorcismValue > 8.0F) {
			finalResult = new ItemStack(Main.swordSandBreaker);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_broadsword"
				&& attackValue > 28.0F
				&& cycloneValue > 27.0F
				&& beastValue > 27.0F
				&& exorcismValue > 18.0F
				&& scaleValue > 8.0F) {
			finalResult = new ItemStack(Main.swordSax);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_broadsword"
				&& attackValue > 28.0F
				&& chillValue > 4.0F
				&& lightningValue > 13.0F
				&& scaleValue > 26.0F) {
			finalResult = new ItemStack(Main.swordKitchenKnife);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_broadsword"
				&& attackValue > 23.0F
				&& flameValue > 13.0F
				&& scaleValue > 13.0F
				&& beastValue > 22.0F) {
			finalResult = new ItemStack(Main.swordWiseOwl);
		}
		
		/*
		 * TIER FOUR
		 */
		if (((ModSword)sword).getSwordName() == "sword_chopper"
				&& attackValue > 49.0F
				&& cycloneValue > 49.0F
				&& beastValue > 49.0F
				&& scaleValue > 40.0F) {
			finalResult = new ItemStack(Main.swordChoora);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_kitchenknife"
				&& attackValue > 48.0F
				&& lightningValue > 49.0F
				&& scaleValue > 49.0F) {
			finalResult = new ItemStack(Main.swordSerpentSlicer);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_wiseowl"
				&& attackValue > 80.0F
				&& cycloneValue > 76.0F
				&& beastValue > 76.0F
				&& exorcismValue > 14.0F) {
			finalResult = new ItemStack(Main.swordLambs);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_wiseowl"
				&& attackValue > 80.0F
				&& cycloneValue > 53.0F
				&& lightningValue > 53.0F
				&& beastValue > 53.0F
				&& scaleValue > 53.0F
				&& exorcismValue > 53.0F) {
			finalResult = new ItemStack(Main.swordSmall);
		}
		
		/*
		 * TIER FIVE
		 */
		if (((ModSword)sword).getSwordName() == "sword_serpentslicer"
				&& attackValue > 79.0F
				&& flameValue > 44.0F
				&& chillValue > 44.0F
				&& smashValue > 44.0F
				&& exorcismValue > 44.0F
				&& beastValue > 44.0F) {
			finalResult = new ItemStack(Main.swordSevenBranch);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_serpentslicer"
				&& attackValue > 79.0F
				&& lightningValue > 89.0F
				&& scaleValue > 89.0F) {
			finalResult = new ItemStack(Main.swordTsukikage);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_serpentslicer"
				&& attackValue > 80.0F
				&& chillValue > 80.0F
				&& smashValue > 80.0F
				&& scaleValue > 71.0F) {
			finalResult = new ItemStack(Main.swordSargatanas);
		}
		
		finalResult.setTagCompound((NBTTagCompound) nbt);
		return finalResult.copy();
	}

	@Override
	public ItemStack getRecipeOutput() {
		finalResult.setTagCompound((NBTTagCompound) nbt);
		return finalResult;
	}
	
	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 1;
	}
		
}
