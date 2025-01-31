package neonodes;

import net.minecraft.item.ItemStack;

public class ItemManager {
	
	public static int getItemWithMeta(int itemId, int metaData){
		return new ItemStack(itemId, 1, metaData).itemID;
	}

}
