package supersaix.monica.registry;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CrystalRegistry {
	public static Item crystalAttack, crystalAttackSpectrumized, crystalBeast, crystalBeastSpectrumized, crystalChill, crystalChillSpectrumized, crystalCyclone, crystalCycloneSpectrumized,
	crystalDurable, crystalDurableSpectrumized, crystalExorcism, crystalExorcismSpectrumized, crystalFlame, crystalFlameSpectrumized, crystalLightning, crystalLightningSpectrumized,
	crystalScale, crystalScaleSpectrumized, crystalSmash, crystalSmashSpectrumized;
	
	public static ArrayList<Item> Crystals = new ArrayList<Item>();
//	public static Map<String, Item> test = new HashMap<String, Item>();
	
	public static void initialize() {
		crystalAttack = new Item()
				.setUnlocalizedName("crystal_attack")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalAttack.setRegistryName("crystal_attack");
		ForgeRegistries.ITEMS.register(crystalAttack);
		Crystals.add(crystalAttack);

		crystalAttackSpectrumized = new Item().setUnlocalizedName("crystal_attack_spectrumized");
		crystalAttackSpectrumized.setRegistryName("crystal_attack_spectrumized");
		ForgeRegistries.ITEMS.register(crystalAttackSpectrumized);
		Crystals.add(crystalAttackSpectrumized);


		crystalBeast = new Item()
				.setUnlocalizedName("crystal_beast")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalBeast.setRegistryName("crystal_beast");
		ForgeRegistries.ITEMS.register(crystalBeast);
		Crystals.add(crystalBeast);

		crystalBeastSpectrumized = new Item().setUnlocalizedName("crystal_beast_spectrumized");
		crystalBeastSpectrumized.setRegistryName("crystal_beast_spectrumized");
		ForgeRegistries.ITEMS.register(crystalBeastSpectrumized);
		Crystals.add(crystalBeastSpectrumized);


		crystalChill = new Item()
				.setUnlocalizedName("crystal_chill")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalChill.setRegistryName("crystal_chill");
		ForgeRegistries.ITEMS.register(crystalChill);
		Crystals.add(crystalChill);

		crystalChillSpectrumized = new Item().setUnlocalizedName("crystal_chill_spectrumized");
		crystalChillSpectrumized.setRegistryName("crystal_chill_spectrumized");
		ForgeRegistries.ITEMS.register(crystalChillSpectrumized);
		Crystals.add(crystalChillSpectrumized);


		crystalCyclone = new Item()
				.setUnlocalizedName("crystal_cyclone")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalCyclone.setRegistryName("crystal_cyclone");
		ForgeRegistries.ITEMS.register(crystalCyclone);
		Crystals.add(crystalCyclone);

		crystalCycloneSpectrumized = new Item()
				.setUnlocalizedName("crystal_cyclone_spectrumized");
		crystalCycloneSpectrumized.setRegistryName("crystal_cyclone_spectrumized");
		ForgeRegistries.ITEMS.register(crystalCycloneSpectrumized);
		Crystals.add(crystalCycloneSpectrumized);


		crystalDurable = new Item()
				.setUnlocalizedName("crystal_durable")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalDurable.setRegistryName("crystal_durable");
		ForgeRegistries.ITEMS.register(crystalDurable);
		Crystals.add(crystalDurable);

		crystalDurableSpectrumized = new Item().setUnlocalizedName("crystal_durable_spectrumized");
		crystalDurableSpectrumized.setRegistryName("crystal_durable_spectrumized");
		ForgeRegistries.ITEMS.register(crystalDurableSpectrumized);
		Crystals.add(crystalDurableSpectrumized);


		crystalExorcism = new Item()
				.setUnlocalizedName("crystal_exorcism")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalExorcism.setRegistryName("crystal_exorcism");
		ForgeRegistries.ITEMS.register(crystalExorcism);
		Crystals.add(crystalExorcism);

		crystalExorcismSpectrumized = new Item().setUnlocalizedName("crystal_exorcism_spectrumized");
		crystalExorcismSpectrumized.setRegistryName("crystal_exorcism_spectrumized");
		ForgeRegistries.ITEMS.register(crystalExorcismSpectrumized);
		Crystals.add(crystalExorcismSpectrumized);


		crystalFlame = new Item()
				.setUnlocalizedName("crystal_flame")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalFlame.setRegistryName("crystal_flame");
		ForgeRegistries.ITEMS.register(crystalFlame);
		Crystals.add(crystalFlame);

		crystalFlameSpectrumized = new Item().setUnlocalizedName("crystal_flame_spectrumized");
		crystalFlameSpectrumized.setRegistryName("crystal_flame_spectrumized");
		ForgeRegistries.ITEMS.register(crystalFlameSpectrumized);
		Crystals.add(crystalFlameSpectrumized);


		crystalLightning = new Item()
				.setUnlocalizedName("crystal_lightning")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalLightning.setRegistryName("crystal_lightning");
		ForgeRegistries.ITEMS.register(crystalLightning);
		Crystals.add(crystalLightning);

		crystalLightningSpectrumized = new Item().setUnlocalizedName("crystal_lightning_spectrumized");
		crystalLightningSpectrumized.setRegistryName("crystal_lightning_spectrumized");
		ForgeRegistries.ITEMS.register(crystalLightningSpectrumized);
		Crystals.add(crystalLightningSpectrumized);


		crystalScale = new Item()
				.setUnlocalizedName("crystal_scale")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalScale.setRegistryName("crystal_scale");
		ForgeRegistries.ITEMS.register(crystalScale);
		Crystals.add(crystalScale);

		crystalScaleSpectrumized = new Item().setUnlocalizedName("crystal_scale_spectrumized");
		crystalScaleSpectrumized.setRegistryName("crystal_scale_spectrumized");
		ForgeRegistries.ITEMS.register(crystalScaleSpectrumized);
		Crystals.add(crystalScaleSpectrumized);


		crystalSmash = new Item()
				.setUnlocalizedName("crystal_smash")
				.setCreativeTab(CreativeTabs.MATERIALS);
		crystalSmash.setRegistryName("crystal_smash");
		ForgeRegistries.ITEMS.register(crystalSmash);
		Crystals.add(crystalSmash);

		crystalSmashSpectrumized = new Item().setUnlocalizedName("crystal_smash_spectrumized");
		crystalSmashSpectrumized.setRegistryName("crystal_smash_spectrumized");
		ForgeRegistries.ITEMS.register(crystalSmashSpectrumized);
		Crystals.add(crystalSmashSpectrumized);
	}
}
