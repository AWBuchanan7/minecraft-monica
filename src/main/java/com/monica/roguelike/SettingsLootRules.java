package com.monica.roguelike;

import greymerk.roguelike.dungeon.settings.DungeonSettings;
import greymerk.roguelike.dungeon.settings.SettingIdentifier;
import greymerk.roguelike.dungeon.settings.SettingsContainer;
import greymerk.roguelike.treasure.loot.LootRuleManager;
import greymerk.roguelike.util.IWeighted;
import net.minecraft.item.ItemStack;

public class SettingsLootRules extends DungeonSettings {
	
	public static final SettingIdentifier ID = new SettingIdentifier(SettingsContainer.DEFAULT_NAMESPACE, "monicaloot");
	
	public SettingsLootRules(){
		this.id = ID;
		this.lootRules = new LootRuleManager();
		
		for(int i = 0; i < 5; ++i) {
			IWeighted<ItemStack> itemCrystal = new ItemCrystal(0, i);
			lootRules.add(null, itemCrystal,  i, true, 3);
			
			IWeighted<ItemStack> itemSword = new ItemSwords(0, i);			
			lootRules.add(null, itemSword,  i, true, 1);
			
		}
		
	}

}
