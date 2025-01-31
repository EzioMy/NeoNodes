package thermalexpansion.api.core;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.item.ItemStack;

public final class ItemRegistry {
	private static final Map registry = new TreeMap();
	
	public static ItemStack getItem(String name, int qty){
		ItemStack result = (ItemStack)registry.get(name);
		if (result != null) {
			result = result.copy();
			result.stackSize = qty;		
		}
		
		return result;
	}
	
	public static void registerItem(String name, ItemStack item) {
		registry.put(name, item);
	}
	
	public static void printItemNames() {
		System.out.println("Printing all registered Thermal Expansion items:");
		Iterator i$ = registry.keySet().iterator();
		
		while(i$.hasNext()){
			String itemName = (String)i$.next();
			System.out.println(itemName);
		}
	}

}
