package com.monica.main;

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

public class BuildUpRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};
	private NBTBase nbt = new NBTTagCompound();
	private Item sword = null;
		
	@Override
	public boolean matches(InventoryCrafting inventory, World world) {

		ItemStack oldSword = null;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {         
			if(inventory.getStackInSlot(i) != null) {
				ItemStack itemStack = inventory.getStackInSlot(i);

				if (itemStack.getItem() != null && ModSword.class.isInstance(((Object)itemStack.getItem())) ) {
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
		
		ItemStack result = new ItemStack(sword);
		return result.copy();
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}
	
	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 1;
	}
	
	public static class Factory implements IRecipeFactory {

		@Override
		public IRecipe parse(final JsonContext context, final JsonObject json) {

			return new BuildUpRecipe();
		}
	}
	
}
