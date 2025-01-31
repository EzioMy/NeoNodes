package neonodes.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neonodes.NeoNodes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NodeItems extends Item {
	public NodeItems(int id){
		super(id);
		setTextureFile("/neonodes/gfx/NeoNodes.png");
		setItemName("NodeItems");
		setCreativeTab(NeoNodes.tabNeoNodes);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT) 
	public int getIconFromDamage(int i){
	switch(i){ 
		case 0: return 0;   // Iron raw ore
	    case 1: return 1;   // Gold raw ore
	    case 2: return 2;   // Copper raw ore
	    case 3: return 3;   // Tin raw ore
	    case 4: return 4;   // Silver raw ore
	    case 5: return 5;   // Lead raw ore
	    case 6: return 6;   // Nickel raw ore
	
	    // Nuggets
	    case 7: return 7;   // Iron nugget
	    case 8: return 8;   // Copper nugget
	    case 9: return 9;   // Tin nugget
	    case 10: return 10; // Silver nugget
	    case 11: return 11; // Lead nugget
	    case 12: return 12; // Nickel nugget
	
	    // Ingots
	    case 13: return 13; // Copper ingot
	    case 14: return 14; // Tin ingot
	    case 15: return 15; // Silver ingot
	    case 16: return 16; // Lead ingot
	    case 17: return 17; // Nickel ingot
		}
	return 0;
	}
	
	public String getItemNameIS(ItemStack is){ //Gets the metadata sensitive item name
		switch(is.getItemDamage()){ //Checks what damage is
			 // Raw ores
		    case 0: return "IronRawOre";
		    case 1: return "GoldRawOre";
		    case 2: return "CopperRawOre";
		    case 3: return "TinRawOre";
		    case 4: return "SilverRawOre";
		    case 5: return "LeadRawOre";
		    case 6: return "NickelRawOre";
	
		    // Nuggets
		    case 7: return "IronNugget";
		    case 8: return "CopperNugget";
		    case 9: return "TinNugget";
		    case 10: return "SilverNugget";
		    case 11: return "LeadNugget";
		    case 12: return "NickelNugget";
	
		    // Ingots
		    case 13: return "CopperIngot";
		    case 14: return "TinIngot";
		    case 15: return "SilverIngot";
		    case 16: return "LeadIngot";
		    case 17: return "NickelIngot";
			}
		return "itemUnknown";
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList){
		for(int index=0;index<18;index++){
			itemList.add(new ItemStack(itemID,1,index));
			}
		}	
}
