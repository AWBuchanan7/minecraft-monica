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
		//Add spectrumization recipes
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_attack_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalAttackSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalAttack))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_beast_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalBeastSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalBeast))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_chill_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalChillSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalChill))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_cyclone_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalCycloneSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalCyclone))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_durable_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalDurableSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalDurable))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_exorcism_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalExorcismSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalExorcism))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_flame_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalFlameSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalFlame))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_lightning_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalLightningSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalLightning))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_scale_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalScaleSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalScale))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_smash_spectrumized"), new ResourceLocation(""),
				new ItemStack(CrystalRegistry.crystalSmashSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(CrystalRegistry.crystalSmash))}
				);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		DungeonTaskRegistry tasks = Dungeon.getTaskRegistry();
    	tasks.addTask(new SettingsLootRules(), DungeonStage.LOOT);
	}
}
