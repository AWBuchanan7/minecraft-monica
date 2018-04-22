package com.monica.roguelike;

import java.util.List;
import java.util.Random;

import greymerk.roguelike.dungeon.IDungeon;
import greymerk.roguelike.dungeon.settings.ISettings;
import greymerk.roguelike.dungeon.settings.SettingIdentifier;
import greymerk.roguelike.dungeon.settings.SettingsContainer;
import greymerk.roguelike.dungeon.tasks.IDungeonTask;
import greymerk.roguelike.treasure.ITreasureChest;
import greymerk.roguelike.worldgen.IWorldEditor;

public class SettingsLootRules implements IDungeonTask {
	
	public static final SettingIdentifier ID = new SettingIdentifier(SettingsContainer.DEFAULT_NAMESPACE, "monicaloot");
	
	@Override
	public void execute(IWorldEditor editor, Random rand, IDungeon dungeon, ISettings settings) {
		List<ITreasureChest> chests = dungeon.getChests();
		
		for(ITreasureChest chest : chests) {
			
			ItemCrystal itemCrystal = new ItemCrystal(0, chest.getLevel());
			chest.setRandomEmptySlot(itemCrystal.getLootItem(rand, chest.getLevel()));
			chest.setRandomEmptySlot(itemCrystal.getLootItem(rand, chest.getLevel()));
			chest.setRandomEmptySlot(itemCrystal.getLootItem(rand, chest.getLevel()));
			
			ItemSwords itemSword = new ItemSwords(0, chest.getLevel());
			chest.setRandomEmptySlot(itemSword.getLootItem(rand, chest.getLevel()));
		}

	}

}
