package thermalexpansion.api.crafting;

import net.minecraft.item.ItemStack;

public interface IPulverizerManager {
	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput, boolean overwrite);
	
	/** @deprecated */
	@Deprecated
	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput);
	
	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, boolean overwrite);
	

	/** @deprecated */
	@Deprecated
	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput);

	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance, boolean overwrite);

	/** @deprecated */
	@Deprecated
	boolean addRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance);
	
	IPulverizerRecipe[] getRecipeList();
	
}
