package supersaix.monica.main;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModSword extends ItemSword {
	private String swordName;
	private ToolMaterial toolMaterial;
	private boolean hasEffect = false;
	private Object effect[] = new Object[2];


	private String[] synthesisStats = {"Attack", "Durable", "Flame", "Chill", "Lightning", "Cyclone", "Smash", "Exorcism", "Beast", "Scale"};

	public ModSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.toolMaterial = toolMaterial;
	}

	public ToolMaterial getToolMaterial() {
		return this.toolMaterial;
	}

	/**
	 * Adds an enchantment to the item.
	 * @param enchantment The enchantment you want to add.
	 * @param level The level of the enchantment. Check the Enchantment class to find the max level for each.
	 * @return SimpleSword
	 */
	public ModSword setEffect(Enchantment enchantment, int level) {
		this.hasEffect = true;
		this.effect[0] = enchantment;
		this.effect[1] = level;
		return this;
	}

	/**
	 * Sets which creative tab the item will appear in in Creative Mode.
	 * @param creativeTab The CreativeTabs tab for the item to appear in.
	 * @return SimpleSword
	 */
	public ModSword setTab(CreativeTabs creativeTab)
	{
		this.setCreativeTab(creativeTab);
		return this;
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(this.hasEffect) { itemStack.addEnchantment((Enchantment)this.effect[0], (Integer)this.effect[1]); }

		initSynthesis(itemStack);

	}

	public void initSynthesis(ItemStack itemStack) {
		UUID uuid = UUID.randomUUID();
		NBTTagCompound nbt = new NBTTagCompound();
		if(!itemStack.hasTagCompound()) {
			nbt.setLong("globalIDLeast", uuid.getLeastSignificantBits());
			nbt.setLong("globalIDMost", uuid.getMostSignificantBits());
			for (int i = 0; i <= 9; i++) {	
				if (!nbt.hasKey(synthesisStats[i])) {
					nbt.setFloat(synthesisStats[i], 0);
				}
			}
			itemStack.setTagCompound(nbt);
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.toolMaterial.getRepairItemStack().getItem() == par2ItemStack.getItem() 
				? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		for (String stat : synthesisStats) {
			//if (stack.hasTagCompound() && stack.getTagCompound().getFloat(stat) != 0.0F) {
			if (stack.hasTagCompound()) {
				tooltip.add(stat + ": " + stack.getTagCompound().getFloat(stat));
			}
		}
    }
	
	@Override
	public Item setUnlocalizedName(String x) {
		this.swordName = x;
		return super.setUnlocalizedName(x);
	}
	
	public String getSwordName() {
		return this.swordName;
	}
	
}
