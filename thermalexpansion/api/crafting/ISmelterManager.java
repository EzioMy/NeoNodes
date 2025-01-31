package thermalexpansion.api.crafting;

import net.minecraft.item.ItemStack;

public interface ISmelterManager {
	boolean addRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack output, boolean overwrite);
	

	boolean addRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput,ItemStack secondaryOutput, boolean overwrite);

	boolean addRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput,ItemStack secondaryOutput,int secondaryChance, boolean overwrite);
}
