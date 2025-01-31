package neonodes.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neonodes.NeoNodes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NodeBlock extends Block {
	
	public NodeBlock(int id) {
		super(id, Material.rock);
		
		setBlockName("NodeBlock");
		setHardness(5.0f);
		setResistance(6.0f);
		setStepSound(Block.soundMetalFootstep);
		setCreativeTab(NeoNodes.tabNeoNodes);
		setTextureFile("/neonodes/gfx/NeoNodes.png");
		// TODO Auto-generated constructor stub
	}
	
	public int getBlockTextureFromSideAndMetadata(int i, int j){
		switch(j){
		 	case 0: return 25; // Copper Block
		    case 1: return 26; // Tin Block
		    case 2: return 27; // Silver Block
		    case 3: return 28; // Lead Block
		    case 4: return 29; // Nickel Block
			default:return 0;
		}
	}
	
	public int damageDropped(int i){ 
		return i;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) //Adds the metadata blocks to the creative inventory
	{
		 for (int var4 = 0; var4 < 5; ++var4)
		 {
			 par3List.add(new ItemStack(par1, 1, var4));
		 }
	}
}
