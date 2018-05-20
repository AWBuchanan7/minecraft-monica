package supersaix.monica.main;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;

import greymerk.roguelike.dungeon.Dungeon;
import greymerk.roguelike.dungeon.DungeonStage;
import greymerk.roguelike.dungeon.tasks.DungeonTaskRegistry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supersaix.monica.registry.CrystalRegistry;
import supersaix.monica.registry.SwordRegistry;
import supersaix.monica.roguelike.SettingsLootRules;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
	public static final String MODID = "monica";
	public static final String NAME = "Supersaix Monica";
	public static final String VERSION = "0.1A";

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		SwordRegistry.initializeToolMaterials();
		CrystalRegistry.initialize();
		SwordRegistry.initializeSwords();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		addBasicShapelessRecipe(CrystalRegistry.crystalAttack, CrystalRegistry.crystalAttackSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalBeast, CrystalRegistry.crystalBeastSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalChill, CrystalRegistry.crystalChillSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalCyclone, CrystalRegistry.crystalCycloneSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalDurable, CrystalRegistry.crystalDurableSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalExorcism, CrystalRegistry.crystalExorcismSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalFlame, CrystalRegistry.crystalFlameSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalLightning, CrystalRegistry.crystalLightningSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalScale, CrystalRegistry.crystalScaleSpectrumized);
		addBasicShapelessRecipe(CrystalRegistry.crystalSmash, CrystalRegistry.crystalSmashSpectrumized);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		DungeonTaskRegistry tasks = Dungeon.getTaskRegistry();
    	tasks.addTask(new SettingsLootRules(), DungeonStage.LOOT);
	}
	
	
	private static void addBasicShapelessRecipe(Item ingredient, Item result) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(MODID + result.getUnlocalizedName()), new ResourceLocation(""),
				new ItemStack(result),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(ingredient))}
				);
	}
}
