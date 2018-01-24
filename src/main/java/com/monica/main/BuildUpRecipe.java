package com.monica.main;

import com.google.gson.JsonObject;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
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

		/* To Do:
		 *  Add build up checks here
		 */
		
		finalResult = new ItemStack(sword);
		if (((ModSword)sword).getSwordName() == "sword_broadsword"
				&& attackValue > 29.0F
				&& chillValue > 5.0F
				&& lightningValue > 14.0F
				&& scaleValue > 27.0F) {
			finalResult = new ItemStack(Main.swordKitchenKnife);
		}
		
		if (((ModSword)sword).getSwordName() == "sword_broadsword"
				&& attackValue > 24.0F
				&& flameValue > 14.0F
				&& scaleValue > 14.0F
				&& beastValue > 23.0F) {
			finalResult = new ItemStack(Main.swordWiseOwl);
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
