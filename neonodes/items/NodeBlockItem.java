package neonodes.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neonodes.NeoNodes;
import neonodes.blocks.NodeOre;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class NodeBlockItem extends ItemBlock {

	public NodeBlockItem(int id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		// TODO Auto-generated constructor stub
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int metadata){
		return NeoNodes.nodeOre.getBlockTextureFromSideAndMetadata(2, metadata);
	}
	
	public int getMetadata(int metadata){
		return metadata;
	}
	
	public String getItemNameIS(ItemStack is){
		String[] types = {"ModIron","ModGold","Copper","Tin","Silver","Lead","Nickel"};
		if(is.getItem().equals((new ItemStack(NeoNodes.nodeOre,1).getItem()))){
			return "Ore" + types[is.getItemDamage()];
		}else {
			return "Block" + types[is.getItemDamage()+2];
		}
	}
	
}
