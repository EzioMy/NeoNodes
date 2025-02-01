package neonodes.proxy;

import thermalexpansion.api.core.ItemRegistry;
import thermalexpansion.api.crafting.CraftingManagers;
import ic2.api.Ic2Recipes;
import ic2.api.Items;
import neonodes.NeoNodes;
import neonodes.items.NodeBlockItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy implements IGuiHandler  {
	
	public void registerRenderInformation(){}
	private String[] metals = {"Iron","Gold","Copper","Tin","Silver","Lead","Nickel"};
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {	
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}
	
	public void registerTiles(){
		
	}
	
	public void registerBlocks(){
		
		// Ore Harvest Level
		GameRegistry.registerBlock(NeoNodes.nodeOre, NodeBlockItem.class,"NodeOre");
		
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 2, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 3, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 4, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 5, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeOre, 6, "pickaxe", 2);
		
		// Block Harvest Level
		GameRegistry.registerBlock(NeoNodes.nodeBlock, NodeBlockItem.class,"NodeBlock");
		
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeBlock, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeBlock, 1, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeBlock, 2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeBlock, 3, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(NeoNodes.nodeBlock, 4, "pickaxe", 2);
		
	}
	
	public void addNames(){
		// Raw Ore Names
		int i = 0;
		for(String name : metals){
			LanguageRegistry.addName(new ItemStack(NeoNodes.nodeItem, 1, i), String.format("Raw %s",name));
			i++;
		}
		
		// Nugget Names
		for(String name : metals){
			if(name != "Gold"){
			LanguageRegistry.addName(new ItemStack(NeoNodes.nodeItem, 1, i), String.format("%s Nugget",name));
			i++;
			}
			
		}
		
		// Ingot Names
		for(String name : metals){
			if(name != "Gold" && name != "Iron"){
			LanguageRegistry.addName(new ItemStack(NeoNodes.nodeItem, 1, i), String.format("%s Ingot",name));
			i++;
			}
			
		}
		
		// Block Names
		i = 0;
		for(String name : metals){
			if(name != "Gold" && name != "Iron"){
			LanguageRegistry.addName(new ItemStack(NeoNodes.nodeBlock, 1, i), String.format("%s Block",name));
			i++;
			}
		}

		// Ore Names
		i = 0;
		for(String name : metals){
			LanguageRegistry.addName(new ItemStack(NeoNodes.nodeOre, 1, i), String.format("%s Ore",name));
			i++;
		}
	}
	
	public void addRecipes(){
		// Raw Ore Smelting
		FurnaceRecipes.smelting().addSmelting(NeoNodes.nodeItem.itemID,0, new ItemStack(Item.ingotIron,1), 0.7f);
		FurnaceRecipes.smelting().addSmelting(NeoNodes.nodeItem.itemID,1, new ItemStack(Item.ingotGold,1), 1.0f);
		
		for(int i = 2; i < metals.length; i++){
			FurnaceRecipes.smelting().addSmelting(NeoNodes.nodeItem.itemID,i, new ItemStack(NeoNodes.nodeItem.itemID,1,i+11), 1.0f);
		}
		// Nugget Recipes
		// Ingot To Nugget
		GameRegistry.addRecipe(new ItemStack(Item.ingotIron,1), "XXX","XXX","XXX", Character.valueOf('X'), new ItemStack(NeoNodes.nodeItem,1,7));
		for(int i = 2;i < metals.length;i++){
			GameRegistry.addRecipe(new ItemStack(NeoNodes.nodeItem,1,i+11), "XXX","XXX","XXX", Character.valueOf('X'), new ItemStack(NeoNodes.nodeItem,1,i+6));
			}
		
		
		//Nugget To Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(NeoNodes.nodeItem,9,7), new ItemStack(Item.ingotIron,1));
		for(int i = 2;i < metals.length;i++){
			GameRegistry.addShapelessRecipe(new ItemStack(NeoNodes.nodeItem,9,i+6), new ItemStack(NeoNodes.nodeItem,1,i+11));
			}
		
		// Ingot To Block
		for(int i = 2;i < metals.length;i++){
			GameRegistry.addRecipe(new ItemStack(NeoNodes.nodeBlock,1,i-2), "XXX","XXX","XXX", Character.valueOf('X'), new ItemStack(NeoNodes.nodeItem,1,i+11));
			}
		
		// Block To Ingot
		for(int i = 2;i < metals.length;i++){
			GameRegistry.addShapelessRecipe(new ItemStack(NeoNodes.nodeItem,9,i+11), new ItemStack(NeoNodes.nodeBlock,1,i-2));
			}
		
		if(Loader.isModLoaded("IC2")){
			// Ore Block to Raw Ore
			for(int i = 0;i< metals.length;i++){ 
				Ic2Recipes.addMaceratorRecipe(new ItemStack(NeoNodes.nodeOre,1,i), new ItemStack(NeoNodes.nodeItem,2,i));
			}
			
			// Raw Ore to Dust
			Ic2Recipes.addMaceratorRecipe(new ItemStack(NeoNodes.nodeItem, 1,0),
	                new ItemStack(Items.getItem("ironDust").getItem(), 2));
	        
	        Ic2Recipes.addMaceratorRecipe(new ItemStack(NeoNodes.nodeItem,1,1),
	                new ItemStack(Items.getItem("goldDust").getItem(), 2));
	        
		}
		
		if(Loader.isModLoaded("ThermalExpansion")){
			/**Pulverizer*/
			
			for(int i = 0;i< metals.length;i++){ 
				CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(NeoNodes.nodeOre,1,i),
						new ItemStack(NeoNodes.nodeItem,2,i), null, false);
			}
			
	        CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(NeoNodes.nodeItem, 1, 0),
	                ItemRegistry.getItem("dustIron", 2),
	                ItemRegistry.getItem("dustNickel",1), 10, false);    
	        
	        CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(NeoNodes.nodeItem, 1,1),
	                ItemRegistry.getItem("dustGold", 2), false);
	        
	        /**Smelter*/
	        CraftingManagers.smelterManager.addRecipe(320, new ItemStack(NeoNodes.nodeItem, 1,0),
	        		new ItemStack(Block.sand, 1),   		
	        		new ItemStack(Item.ingotIron, 2),
	        		ItemRegistry.getItem("slagRich", 1), 5 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(400, new ItemStack(NeoNodes.nodeItem, 1,0),
	        		ItemRegistry.getItem("slagRich", 1),       		
	        		new ItemStack(Item.ingotIron, 2),
	        		ItemRegistry.getItem("slag", 1), 75 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(320,new ItemStack(NeoNodes.nodeOre, 1, 0),
	        		new ItemStack(Block.sand, 1),   		
	        		new ItemStack(Item.ingotIron, 2),
	        		ItemRegistry.getItem("slagRich", 1), 5 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(400, new ItemStack(NeoNodes.nodeOre, 1, 0),
	        		ItemRegistry.getItem("slagRich", 1), 
	        		new ItemStack(Item.ingotIron, 2),
	        		ItemRegistry.getItem("slag", 1), 75 , false);
	        
	        
	        
	        CraftingManagers.smelterManager.addRecipe(320, new ItemStack(NeoNodes.nodeItem, 1,2),
	        		new ItemStack(Block.sand, 1), 
	        		new ItemStack(Item.ingotGold, 2),
	        		ItemRegistry.getItem("slagRich", 1), 5 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(400, new ItemStack(NeoNodes.nodeItem, 1,1), 
	        		ItemRegistry.getItem("slagRich", 1), 
	        		new ItemStack(Item.ingotGold, 2),
	        		ItemRegistry.getItem("slag", 1), 75 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(320, new ItemStack(NeoNodes.nodeOre, 1, 1),
	        		new ItemStack(Block.sand, 1), 
	        		new ItemStack(Item.ingotGold, 2),
	        		ItemRegistry.getItem("slagRich", 1), 5 , false);
	        
	        CraftingManagers.smelterManager.addRecipe(400, new ItemStack(NeoNodes.nodeOre, 1, 1), 
	        		ItemRegistry.getItem("slagRich", 1), 
	        		new ItemStack(Item.ingotGold, 2),
	        		ItemRegistry.getItem("slag", 1), 75 , false);
	        
	        
	        
		}
		
		
		
	}
	
	public void registerOre(){
				// Raw Ore OreDict
				int i = 0;
				for(String name : metals){
					OreDictionary.registerOre("ore" + name, new ItemStack(NeoNodes.nodeItem, 1, i));
					i++;
				}
				
				// Nugget OreDict
				for(String name : metals){
					if(name != "Gold"){
						OreDictionary.registerOre("nugget" + name, new ItemStack(NeoNodes.nodeItem, 1, i));
						i++;
					}
					
				}
				
				// Ingot OreDict
				for(String name : metals){
					if(name != "Gold" && name != "Iron"){
						OreDictionary.registerOre("ingot" + name, new ItemStack(NeoNodes.nodeItem, 1, i));
						i++;
					}
					
				}
				
				// Block OreDict
				i = 0;
				for(String name : metals){
					if(name != "Gold" && name != "Iron"){
						OreDictionary.registerOre("block" + name, new ItemStack(NeoNodes.nodeBlock, 1, i));
						i++;
					}
				}

				// Ore OreDict
				i = 0;
				for(String name : metals){
					OreDictionary.registerOre("neoore" + name, new ItemStack(NeoNodes.nodeOre, 1, i));
					i++;
				}
	}

}
