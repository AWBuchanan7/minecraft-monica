package supersaix.monica.main;

import greymerk.roguelike.dungeon.Dungeon;
import greymerk.roguelike.dungeon.DungeonStage;
import greymerk.roguelike.dungeon.tasks.DungeonTaskRegistry;
import supersaix.monica.roguelike.SettingsLootRules;

public class Roguelike {

	public static void Initialize() {
		DungeonTaskRegistry tasks = Dungeon.getTaskRegistry();
		tasks.addTask(new SettingsLootRules(), DungeonStage.LOOT);
	}
}
