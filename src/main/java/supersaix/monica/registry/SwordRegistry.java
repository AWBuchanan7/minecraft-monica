package supersaix.monica.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supersaix.monica.main.ModSword;

public class SwordRegistry {
	//TODO: Chopper, Sand Breaker
		public static ModSword swordLongSword, swordGladius, swordBaselard, swordBastard, swordCliffKnife, swordBroadsword, swordShamshir, swordSax, swordChopper, swordSandBreaker, swordKitchenKnife, swordWiseOwl, swordChoora, swordSerpentSlicer, swordSevenBranch,
		swordTsukikage, swordLambs, swordSmall, swordSargatanas, swordDarkCloud;
		
		public static ArrayList<ModSword> Swords = new ArrayList<ModSword>();

		public static ToolMaterial tierTwo, tierThree, tierFour, tierFive, tierSix,tierSeven, tierEight, tierNine;
				
		public static void initializeSwords() {
			/*
			 * TIER TWO
			 */
			swordLongSword = (ModSword)(new ModSword(tierTwo).setUnlocalizedName("sword_longsword"));
			swordLongSword.setRegistryName("sword_longsword");
			ForgeRegistries.ITEMS.register(swordLongSword);
			Swords.add(swordLongSword);
			
			swordGladius = (ModSword)(new ModSword(tierTwo).setUnlocalizedName("sword_gladius"));
			swordGladius.setRegistryName("sword_gladius");
			ForgeRegistries.ITEMS.register(swordGladius);
			Swords.add(swordGladius);
			
			swordBaselard = (ModSword)(new ModSword(tierTwo).setUnlocalizedName("sword_baselard"));
			swordBaselard.setRegistryName("sword_baselard");
			ForgeRegistries.ITEMS.register(swordBaselard);
			Swords.add(swordBaselard);
			
			/*
			 * TIER THREE
			 */

			swordBastard = (ModSword)(new ModSword(tierThree).setUnlocalizedName("sword_bastard"));
			swordBastard.setRegistryName("sword_bastard");
			ForgeRegistries.ITEMS.register(swordBastard);
			Swords.add(swordBastard);
			
			swordCliffKnife = (ModSword)(new ModSword(tierThree).setUnlocalizedName("sword_cliffknife"));
			swordCliffKnife.setRegistryName("sword_cliffknife");
			ForgeRegistries.ITEMS.register(swordCliffKnife);
			Swords.add(swordCliffKnife);
			
			swordBroadsword = (ModSword)(new ModSword(tierThree).setUnlocalizedName("sword_broadsword"));
			swordBroadsword.setRegistryName("sword_broadsword");
			ForgeRegistries.ITEMS.register(swordBroadsword);
			Swords.add(swordBroadsword);

			/*
			 * TIER FOUR
			 */

			swordShamshir = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_shamshir"));
			swordShamshir.setRegistryName("sword_shamshir");
			ForgeRegistries.ITEMS.register(swordShamshir);
			Swords.add(swordShamshir);
			
			swordSax = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_sax"));
			swordSax.setRegistryName("sword_sax");
			ForgeRegistries.ITEMS.register(swordSax);
			Swords.add(swordSax);
			
			swordChopper = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_chopper"));
			swordChopper.setRegistryName("sword_chopper");
			ForgeRegistries.ITEMS.register(swordChopper);
			Swords.add(swordChopper);
			
			swordSandBreaker = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_sandbreaker"));
			swordSandBreaker.setRegistryName("sword_sandbreaker");
			ForgeRegistries.ITEMS.register(swordSandBreaker);
			Swords.add(swordSandBreaker);
			
			swordKitchenKnife = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_kitchenknife"));
			swordKitchenKnife.setRegistryName("sword_kitchenknife");
			ForgeRegistries.ITEMS.register(swordKitchenKnife);
			Swords.add(swordKitchenKnife);

			swordWiseOwl = (ModSword)(new ModSword(tierFour).setUnlocalizedName("sword_wiseowl"));
			swordWiseOwl.setRegistryName("sword_wiseowl");
			ForgeRegistries.ITEMS.register(swordWiseOwl);
			Swords.add(swordWiseOwl);

			/*
			 * TIER FIVE
			 */

			swordChoora = (ModSword)(new ModSword(tierFive).setUnlocalizedName("sword_choora"));
			swordChoora.setRegistryName("sword_choora");
			ForgeRegistries.ITEMS.register(swordChoora);
			Swords.add(swordChoora);

			swordSerpentSlicer = (ModSword)(new ModSword(tierFive).setUnlocalizedName("sword_serpentslicer"));
			swordSerpentSlicer.setRegistryName("sword_serpentslicer");
			ForgeRegistries.ITEMS.register(swordSerpentSlicer);
			Swords.add(swordSerpentSlicer);
			

			/*
			 * TIER SIX
			 */

			swordSevenBranch = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_sevenbranch"));
			swordSevenBranch.setRegistryName("sword_sevenbranch");
			ForgeRegistries.ITEMS.register(swordSevenBranch);
			Swords.add(swordSevenBranch);

			swordTsukikage = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_tsukikage"));
			swordTsukikage.setRegistryName("sword_tsukikage");
			ForgeRegistries.ITEMS.register(swordTsukikage);
			Swords.add(swordTsukikage);

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
			Swords.add(swordLambs);

			swordSmall = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_small"));
			swordSmall.setRegistryName("sword_small");
			ForgeRegistries.ITEMS.register(swordSmall);
			Swords.add(swordSmall);

			swordSargatanas = (ModSword)(new ModSword(tierSix).setUnlocalizedName("sword_sargatanas"));
			swordSargatanas.setRegistryName("sword_sargatanas");
			ForgeRegistries.ITEMS.register(swordSargatanas);
			Swords.add(swordSargatanas);


			/*
			 * TIER SEVEN
			 */

			/*
			 * TIER EIGHT
			 */

			swordDarkCloud = (ModSword)(new ModSword(tierEight).setUnlocalizedName("sword_darkcloud"));
			swordDarkCloud.setRegistryName("sword_darkcloud");
			ForgeRegistries.ITEMS.register(swordDarkCloud);
			Swords.add(swordDarkCloud);
		}
		
		public static ArrayList<ModSword> getWeaponsByTier(ToolMaterial tier) {
			ArrayList<ModSword> Results = new ArrayList<ModSword>();
			
			for(ModSword sword : SwordRegistry.Swords) {
				if (sword.getToolMaterial() == tier) {
					Results.add(sword);
				}
			}
			
			return Results;
		}
		
		public static ModSword getRandomWeaponByTier(ToolMaterial tier, Random rand) {
			ArrayList<ModSword> swords = getWeaponsByTier(tier);
			return swords.get(rand.nextInt(swords.size()));
		}
		
		public static void initializeToolMaterials() {
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
