package neonodes.blocks;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neonodes.NeoNodes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NodeOre extends Block {

	public NodeOre(int id) {
		super(id, Material.rock);
		
		setBlockName("NodeOre");
		setHardness(3.0f);
		setResistance(5.0f);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(NeoNodes.tabNeoNodes);
		setTextureFile("/neonodes/gfx/NeoNodes.png");
		// TODO Auto-generated constructor stub
	}
	
	public int getBlockTextureFromSideAndMetadata(int i, int j){
		switch(j){
		 	case 0: return 18; // Iron Ore
		    case 1: return 19; // Gold Ore
		    case 2: return 20; // Copper Ore
		    case 3: return 21; // Tin Ore
		    case 4: return 22; // Silver Ore
		    case 5: return 23; // Lead Ore
		    case 6: return 24; // Nickel Ore
			default:return 0;
		}
	}
	
	public int damageDropped(int i){ 
		return i;
	}
	
	public ArrayList<ItemStack> getBlockDropped(World w, int x, int y, int z, int meta, int fortune) {
	    ArrayList<ItemStack> list = new ArrayList<ItemStack>(); // The list of items

	    // One guaranteed drop
	    list.add(new ItemStack(NeoNodes.nodeItem, 1, meta));

	    // Calculate additional drops based on Fortune level
	    if (fortune > 0) {
	        int additionalDrops = w.rand.nextInt(fortune + 1); // This adds extra drops based on the Fortune level

	        for (int i = 0; i < additionalDrops * NeoNodes.oreGenNums.get(meta).getQty(); i++) {
	            list.add(new ItemStack(NeoNodes.nodeItem, 1, meta)); // Adds the additional drops
	        }
	    }

	    return list; // Returns the finished list :)
	}
		
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) //Adds the metadata blocks to the creative inventory
	{
		 for (int index = 0; index < 7; ++index)
		 {
			 par3List.add(new ItemStack(par1, 1, index));
		 }
	}
	

}
