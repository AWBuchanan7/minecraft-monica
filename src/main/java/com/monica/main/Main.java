package com.monica.main;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;

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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
	public static final String MODID = "monica";
	public static final String NAME = "Dark Cloud 2 Monica";
	public static final String VERSION = "1.0";

	public static Logger logger;

	public static Item  swordBroadsword, swordSax, swordKitchenKnife, swordWiseOwl, swordChoora, swordSerpentSlicer, swordSevenBranch,
	swordTsukikage, swordLambs, swordSmall, swordSargatanas, swordDarkCloud;

	public static Item crystalAttack, crystalAttackSpectrumized, crystalBeast, crystalBeastSpectrumized, crystalChill, crystalChillSpectrumized, crystalCyclone, crystalCycloneSpectrumized,
	crystalDurable, crystalDurableSpectrumized, crystalExorcism, crystalExorcismSpectrumized, crystalFlame, crystalFlameSpectrumized, crystalLightning, crystalLightningSpectrumized,
	crystalScale, crystalScaleSpectrumized, crystalSmash, crystalSmashSpectrumized;


	public static ToolMaterial tierTwo, tierThree, tierFour, tierFive, tierSix,tierSeven, tierEight, tierNine;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		createToolMaterials();
		createCrystals();
		createSwords();

	}
	
	@Mod.EventBusSubscriber(modid = Main.MODID)
	public static class RegistryEventHandler {
		@SubscribeEvent
		public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
		{
			IRecipe buildup = new BuildUpRecipe();
			buildup.setRegistryName(new ResourceLocation(Main.MODID, "recipe_buildup"));
			IRecipe synthesis = new SynthesisRecipe()
					.setRegistryName(new ResourceLocation(Main.MODID, "recipe_synthesis"));
	
			(event.getRegistry()).register(buildup);
			(event.getRegistry()).register(synthesis);
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Add synthesis recipe
//		IRecipe recipe = new BuildUpRecipe()
//				.setRegistryName(new ResourceLocation("monica:recipe_buildup"));
		
//		This causes the game to hang when loading a world, before the "Building Terrain" step.
//		Commenting out all the code in the recipe does not change whether the game hangs.
//		GameData.register_impl(recipe);
		
//		This also causes the game to hang:
//		IForgeRegistry<IRecipe> registry = GameRegistry.findRegistry(recipe.getRegistryType());
//		registry.register(recipe);
		
		//Add spectrumization recipes
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_attack_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalAttackSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalAttack))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_beast_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalBeastSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalBeast))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_chill_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalChillSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalChill))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_cyclone_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalCycloneSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalCyclone))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_durable_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalDurableSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalDurable))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_exorcism_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalExorcismSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalExorcism))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_flame_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalFlameSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalFlame))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_lightning_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalLightningSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalLightning))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_scale_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalScaleSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalScale))}
				);
		GameRegistry.addShapelessRecipe(new ResourceLocation("monica:crystal_smash_spectrumized"), new ResourceLocation(""),
				new ItemStack(crystalSmashSpectrumized),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(crystalSmash))}
				);
	}

	@EventHandler
	public void initClientOnly(FMLPreInitializationEvent event)
	{
		final int DEFAULT_ITEM_SUBTYPE = 0;

		assignCrystalModels();

		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("monica:sword_broadsword");
		ModelLoader.setCustomModelResourceLocation(swordBroadsword, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_sax");
		ModelLoader.setCustomModelResourceLocation(swordSax, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation("monica:sword_kitchenknife");
		ModelLoader.setCustomModelResourceLocation(swordKitchenKnife, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_wiseowl");
		ModelLoader.setCustomModelResourceLocation(swordWiseOwl, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_choora");
		ModelLoader.setCustomModelResourceLocation(swordChoora, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_serpentslicer");
		ModelLoader.setCustomModelResourceLocation(swordSerpentSlicer, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_sevenbranch");
		ModelLoader.setCustomModelResourceLocation(swordSevenBranch, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_tsukikage");
		ModelLoader.setCustomModelResourceLocation(swordTsukikage, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_lambs");
		ModelLoader.setCustomModelResourceLocation(swordLambs, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_small");
		ModelLoader.setCustomModelResourceLocation(swordSmall, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_sargatanas");
		ModelLoader.setCustomModelResourceLocation(swordSargatanas, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:sword_darkcloud");
		ModelLoader.setCustomModelResourceLocation(swordDarkCloud, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

	}

	private void assignCrystalModels() {
		final int DEFAULT_ITEM_SUBTYPE = 0;

		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("monica:crystal_attack");
		ModelLoader.setCustomModelResourceLocation(crystalAttack, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_attack_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalAttackSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_beast");
		ModelLoader.setCustomModelResourceLocation(crystalBeast, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_beast_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalBeastSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_chill");
		ModelLoader.setCustomModelResourceLocation(crystalChill, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_chill_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalChillSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_cyclone");
		ModelLoader.setCustomModelResourceLocation(crystalCyclone, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_cyclone_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalCycloneSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_durable");
		ModelLoader.setCustomModelResourceLocation(crystalDurable, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_durable_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalDurableSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_exorcism");
		ModelLoader.setCustomModelResourceLocation(crystalExorcism, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_exorcism_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalExorcismSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_flame");
		ModelLoader.setCustomModelResourceLocation(crystalFlame, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_flame_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalFlameSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_lightning");
		ModelLoader.setCustomModelResourceLocation(crystalLightning, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_lightning_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalLightningSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_scale");
		ModelLoader.setCustomModelResourceLocation(crystalScale, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_scale_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalScaleSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_smash");
		ModelLoader.setCustomModelResourceLocation(crystalSmash, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		itemModelResourceLocation = new ModelResourceLocation("monica:crystal_smash_spectrumized");
		ModelLoader.setCustomModelResourceLocation(crystalSmashSpectrumized, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}

	private static void createCrystals() {
		crystalAttack = new Item()
				.setUnlocalizedName("crystal_attack")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalAttack.setRegistryName("crystal_attack");
		ForgeRegistries.ITEMS.register(crystalAttack);

		crystalAttackSpectrumized = new Item().setUnlocalizedName("crystal_attack_spectrumized");
		crystalAttackSpectrumized.setRegistryName("crystal_attack_spectrumized");
		ForgeRegistries.ITEMS.register(crystalAttackSpectrumized);


		crystalBeast = new Item()
				.setUnlocalizedName("crystal_beast")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalBeast.setRegistryName("crystal_beast");
		ForgeRegistries.ITEMS.register(crystalBeast);

		crystalBeastSpectrumized = new Item().setUnlocalizedName("crystal_beast_spectrumized");
		crystalBeastSpectrumized.setRegistryName("crystal_beast_spectrumized");
		ForgeRegistries.ITEMS.register(crystalBeastSpectrumized);


		crystalChill = new Item()
				.setUnlocalizedName("crystal_chill")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalChill.setRegistryName("crystal_chill");
		ForgeRegistries.ITEMS.register(crystalChill);

		crystalChillSpectrumized = new Item().setUnlocalizedName("crystal_chill_spectrumized");
		crystalChillSpectrumized.setRegistryName("crystal_chill_spectrumized");
		ForgeRegistries.ITEMS.register(crystalChillSpectrumized);


		crystalCyclone = new Item()
				.setUnlocalizedName("crystal_cyclone")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalCyclone.setRegistryName("crystal_cyclone");
		ForgeRegistries.ITEMS.register(crystalCyclone);

		crystalCycloneSpectrumized = new Item()
				.setUnlocalizedName("crystal_cyclone_spectrumized");
		crystalCycloneSpectrumized.setRegistryName("crystal_cyclone_spectrumized");
		ForgeRegistries.ITEMS.register(crystalCycloneSpectrumized);


		crystalDurable = new Item()
				.setUnlocalizedName("crystal_durable")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalDurable.setRegistryName("crystal_durable");
		ForgeRegistries.ITEMS.register(crystalDurable);

		crystalDurableSpectrumized = new Item().setUnlocalizedName("crystal_durable_spectrumized");
		crystalDurableSpectrumized.setRegistryName("crystal_durable_spectrumized");
		ForgeRegistries.ITEMS.register(crystalDurableSpectrumized);


		crystalExorcism = new Item()
				.setUnlocalizedName("crystal_exorcism")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalExorcism.setRegistryName("crystal_exorcism");
		ForgeRegistries.ITEMS.register(crystalExorcism);

		crystalExorcismSpectrumized = new Item().setUnlocalizedName("crystal_exorcism_spectrumized");
		crystalExorcismSpectrumized.setRegistryName("crystal_exorcism_spectrumized");
		ForgeRegistries.ITEMS.register(crystalExorcismSpectrumized);


		crystalFlame = new Item()
				.setUnlocalizedName("crystal_flame")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalFlame.setRegistryName("crystal_flame");
		ForgeRegistries.ITEMS.register(crystalFlame);

		crystalFlameSpectrumized = new Item().setUnlocalizedName("crystal_flame_spectrumized");
		crystalFlameSpectrumized.setRegistryName("crystal_flame_spectrumized");
		ForgeRegistries.ITEMS.register(crystalFlameSpectrumized);


		crystalLightning = new Item()
				.setUnlocalizedName("crystal_lightning")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalLightning.setRegistryName("crystal_lightning");
		ForgeRegistries.ITEMS.register(crystalLightning);

		crystalLightningSpectrumized = new Item().setUnlocalizedName("crystal_lightning_spectrumized");
		crystalLightningSpectrumized.setRegistryName("crystal_lightning_spectrumized");
		ForgeRegistries.ITEMS.register(crystalLightningSpectrumized);


		crystalScale = new Item()
				.setUnlocalizedName("crystal_scale")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalScale.setRegistryName("crystal_scale");
		ForgeRegistries.ITEMS.register(crystalScale);

		crystalScaleSpectrumized = new Item().setUnlocalizedName("crystal_scale_spectrumized");
		crystalScaleSpectrumized.setRegistryName("crystal_scale_spectrumized");
		ForgeRegistries.ITEMS.register(crystalScaleSpectrumized);


		crystalSmash = new Item()
				.setUnlocalizedName("crystal_smash")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalSmash.setRegistryName("crystal_smash");
		ForgeRegistries.ITEMS.register(crystalSmash);

		crystalSmashSpectrumized = new Item().setUnlocalizedName("crystal_smash_spectrumized");
		crystalSmashSpectrumized.setRegistryName("crystal_smash_spectrumized");
		ForgeRegistries.ITEMS.register(crystalSmashSpectrumized);
	}

	private void createSwords() {
		/*
		 * TIER TWO
		 */

		/*
		 * TIER THREE
		 */

		swordBroadsword = (ModSword)(new ModSword(tierThree).setUnlocalizedName("sword_broadsword"));
		swordBroadsword.setRegistryName("sword_broadsword");
		ForgeRegistries.ITEMS.register(swordBroadsword);

		/*
		 * TIER FOUR
		 */

		swordSax = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_sax"));
		swordSax.setRegistryName("sword_sax");
		ForgeRegistries.ITEMS.register(swordSax);
		
		swordKitchenKnife = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_kitchenknife"));
		swordKitchenKnife.setRegistryName("sword_kitchenknife");
		ForgeRegistries.ITEMS.register(swordKitchenKnife);

		swordWiseOwl = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_wiseowl"));
		swordWiseOwl.setRegistryName("sword_wiseowl");
		ForgeRegistries.ITEMS.register(swordWiseOwl);

		/*
		 * TIER FIVE
		 */

		swordChoora = (ModSword)(new ModSword(tierFive).setUnlocalizedName("sword_choora"));
		swordChoora.setRegistryName("sword_choora");
		ForgeRegistries.ITEMS.register(swordChoora);

		swordSerpentSlicer = (ModSword)(new ModSword(tierFive).setUnlocalizedName("sword_serpentslicer"));
		swordSerpentSlicer.setRegistryName("sword_serpentslicer");
		ForgeRegistries.ITEMS.register(swordSerpentSlicer);

		/*
		 * TIER SIX
		 */

		swordSevenBranch = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_sevenbranch"));
		swordSevenBranch.setRegistryName("sword_sevenbranch");
		ForgeRegistries.ITEMS.register(swordSevenBranch);

		swordTsukikage = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_tsukikage"));
		swordTsukikage.setRegistryName("sword_tsukikage");
		ForgeRegistries.ITEMS.register(swordTsukikage);

		swordLambs = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_lambs"));
		swordLambs.setRegistryName("sword_lambs");
		ForgeRegistries.ITEMS.register(swordLambs);
		swordLambs.addPropertyOverride(new ResourceLocation("time"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			double rotation;
			@SideOnly(Side.CLIENT)
			double rota;
			@SideOnly(Side.CLIENT)
			long lastUpdateTick;
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				boolean flag = entityIn != null;
				Entity entity = (Entity)(flag ? entityIn : stack.getItemFrame());

				if (worldIn == null && entity != null)
				{
					worldIn = entity.world;
				}

				if (worldIn == null)
				{
					return 0.0F;
				}
				else
				{
					double d0;

					if (worldIn.provider.isSurfaceWorld())
					{
						d0 = (double)worldIn.getCelestialAngle(1.0F);
					}
					else
					{
						d0 = Math.random();
					}

					d0 = this.wobble(worldIn, d0);
					return (float)d0;
				}
			}
			@SideOnly(Side.CLIENT)
			private double wobble(World p_185087_1_, double p_185087_2_)
			{
				if (p_185087_1_.getTotalWorldTime() != this.lastUpdateTick)
				{
					this.lastUpdateTick = p_185087_1_.getTotalWorldTime();
					double d0 = p_185087_2_ - this.rotation;
					d0 = MathHelper.positiveModulo(d0 + 0.5D, 1.0D) - 0.5D;
					this.rota += d0 * 0.1D;
					this.rota *= 0.9D;
					this.rotation = MathHelper.positiveModulo(this.rotation + this.rota, 1.0D);
				}

				return this.rotation;
			}
		});

		swordSmall = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_small"));
		swordSmall.setRegistryName("sword_small");
		ForgeRegistries.ITEMS.register(swordSmall);

		swordSargatanas = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_sargatanas"));
		swordSargatanas.setRegistryName("sword_sargatanas");
		ForgeRegistries.ITEMS.register(swordSargatanas);


		/*
		 * TIER SEVEN
		 */

		/*
		 * TIER EIGHT
		 */

		swordDarkCloud = (ModSword)(new ModSword(tierEight).setUnlocalizedName("sword_darkcloud"));
		swordDarkCloud.setRegistryName("sword_darkcloud");
		ForgeRegistries.ITEMS.register(swordDarkCloud);


	}

	private void createToolMaterials() {
		// Name, Mining Level, Uses, Mining Speed, Damage v Entity, Enchantability
		tierTwo = EnumHelper.addToolMaterial("DC_TIER_TWO", 3, 750, 7.0F, 2.5F, 5);
		tierThree = EnumHelper.addToolMaterial("DC_TIER_THREE", 3, 750, 7.0F, 3.0F, 5);
		tierFour = EnumHelper.addToolMaterial("DC_TIER_FOUR", 3, 750, 7.0F, 3.5F, 5);
		tierFive = EnumHelper.addToolMaterial("DC_TIER_FIVE", 3, 750, 7.0F, 4.0F, 5);
		tierSix = EnumHelper.addToolMaterial("DC_TIER_SIX", 3, 750, 7.0F, 4.5F, 5);
		tierSeven = EnumHelper.addToolMaterial("DC_TIER_SEVEN", 3, 750, 7.0F, 5.0F, 5);
		tierEight = EnumHelper.addToolMaterial("DC_TIER_EIGHT", 3, 750, 7.0F, 5.5F, 5);
		tierNine = EnumHelper.addToolMaterial("DC_TIER_NINE", 3, 750, 7.0F, 6.0F, 5);
	}


}
