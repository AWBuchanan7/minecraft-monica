package supersaix.monica.main;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import supersaix.monica.recipe.BuildUpRecipe;
import supersaix.monica.recipe.SynthesisRecipe;
import supersaix.monica.registry.CrystalRegistry;
import supersaix.monica.registry.SwordRegistry;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class EventHandler {
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
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
		final int DEFAULT_ITEM_SUBTYPE = 0;
		
		for(Item sword : SwordRegistry.Swords){
            event.getRegistry().register(sword);
            ModelLoader.setCustomModelResourceLocation(
            		sword,
            		DEFAULT_ITEM_SUBTYPE,
                    new ModelResourceLocation(Main.MODID + ":" + sword.getUnlocalizedName().substring(5))
            );
        }
		
		for(Item crystal : CrystalRegistry.Crystals){
            event.getRegistry().register(crystal);
            ModelLoader.setCustomModelResourceLocation(
            		crystal,
            		DEFAULT_ITEM_SUBTYPE,
                    new ModelResourceLocation(Main.MODID + ":" + crystal.getUnlocalizedName().substring(5))
            );
        }
    }
}
