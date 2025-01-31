package neonodes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class NodeCreativeTab extends CreativeTabs {

	public NodeCreativeTab(int position, String tabID) {
		super(position, tabID);
		// TODO Auto-generated constructor stub
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex(){
		return NeoNodes.nodeItem.itemID;
	}

	public String getTranslatedTabLabel(){
		return "NeoNodes";
	}
	
}
