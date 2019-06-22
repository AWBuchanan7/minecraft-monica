package supersaix.monica.main;

import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supersaix.monica.registry.CrystalRegistry;
import supersaix.monica.registry.SwordRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
	public static final String MODID = "monica";
	public static final String NAME = "Supersaix Monica";
	public static final String VERSION = "0.1A";
	
	public static boolean roguelikeDungeons;
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
		
		roguelikeDungeons = Loader.isModLoaded("roguelike");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (roguelikeDungeons) {
			try {
				Class.forName("supersaix.monica.main.Roguelike").asSubclass(Roguelike.class).newInstance();
				Roguelike.Initialize();
			} catch (Exception e) {
				// This shouldn't happen, either the mod is loaded and we're cool, or it's not and we won't reach this.
				e.printStackTrace();
			}

		}
	}
	
	
	private static void addBasicShapelessRecipe(Item ingredient, Item result) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(MODID + result.getUnlocalizedName()), new ResourceLocation(""),
				new ItemStack(result),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(ingredient))}
				);
	}
}
