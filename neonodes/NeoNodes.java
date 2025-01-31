package neonodes;

import java.util.ArrayList;

import neonodes.proxy.ClientProxy;
import neonodes.proxy.CommonProxy;
import neonodes.worldgen.NodeOreCluster;
import neonodes.blocks.NodeBlock;
import neonodes.blocks.NodeOre;
import neonodes.handlers.*;
import neonodes.items.NodeItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = true,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"NodesGeneral"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class))
@Mod(modid = "NeoNodes", name = "Neo Nodes", version = "1.0", dependencies = "after:IC2;after:ThermalExpansion|Factory")
public class NeoNodes {
	
	public static CreativeTabs tabNeoNodes = new NodeCreativeTab(CreativeTabs.getNextID(), "Neo Nodes");
	public static ArrayList<NodeOreCluster> oreGenNums = new ArrayList<NodeOreCluster>();
	public static Item nodeItem;
	public static Block nodeOre, nodeBlock;
	
	@Instance("NeoNodes")
	public static NeoNodes instance = new NeoNodes();
	
	@SidedProxy(clientSide = "neonodes.proxy.ClientProxy", serverSide = "neonodes.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@SidedProxy(clientSide = "neonodes.proxy.ClientProxy", serverSide = "neonodes.proxy.CommonProxy")
	public static ClientProxy clientProxy;
	
	@PreInit()
	public void PreInitNodes(FMLPreInitializationEvent e){
		NodeConfig nc = new NodeConfig();
		
		NodeConfig.loadConfig(e);
		
		nodeItem = new NodeItems(nc.itemID);
		nodeOre = new NodeOre(nc.oreID);
		nodeBlock = new NodeBlock(nc.blockID);
		oreGenNums.add(new NodeOreCluster(nc.ironOreEnabled, nc.ironDropQty, nc.ironMinY, nc.ironMaxY, nc.ironNumCluster, nc.ironClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.goldOreEnabled, nc.goldDropQty, nc.goldMinY, nc.goldMaxY, nc.goldNumCluster, nc.goldClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.copperOreEnabled, nc.copperDropQty, nc.copperMinY, nc.copperMaxY, nc.copperNumCluster, nc.copperClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.tinOreEnabled, nc.tinDropQty, nc.tinMinY, nc.tinMaxY, nc.tinNumCluster, nc.tinClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.silverOreEnabled, nc.silverDropQty, nc.silverMinY, nc.silverMaxY, nc.silverNumCluster, nc.silverClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.leadOreEnabled, nc.leadDropQty, nc.leadMinY, nc.leadMaxY, nc.leadNumCluster, nc.leadClusterSize));
		oreGenNums.add(new NodeOreCluster(nc.nickelOreEnabled, nc.nickelDropQty, nc.nickelMinY, nc.nickelMaxY, nc.nickelNumCluster, nc.nickelClusterSize));
		
	}
	
	@Init
	public void initNeoNodes(FMLInitializationEvent event){
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		clientProxy.registerRenderInformation();
		proxy.registerBlocks();
		proxy.registerOre();
		proxy.addNames();
		proxy.addRecipes();
	}
	
	@PostInit
	public void modsLoaded(FMLPostInitializationEvent event){
		WorldGenHandler worldGenHandler = new WorldGenHandler();
		GameRegistry.registerWorldGenerator(worldGenHandler);
		MinecraftForge.ORE_GEN_BUS.register(worldGenHandler);
	}
	
	
}