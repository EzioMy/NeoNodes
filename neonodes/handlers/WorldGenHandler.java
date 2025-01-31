package neonodes.handlers;
import java.util.Random;

import neonodes.NeoNodes;
import neonodes.worldgen.NodeOreCluster;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.isSurfaceWorld()){
			generateSurface(random, chunkX, chunkZ, world);
		}
	}
	
	public void generateSurface(Random random, int chunkX, int chunkZ, World world){
		int blockX = chunkX * 16;
    	int blockZ = chunkZ * 16;
    	for(int i = 0; i < NeoNodes.oreGenNums.size(); i++) {
    		NodeOreCluster cluster = (NodeOreCluster)NeoNodes.oreGenNums.get(i);
    		if(cluster.isEnabled()){
	    		for(int j = 0; j < cluster.getNumCluster(); j++) {
	    			int randPosX = blockX + random.nextInt(16);
	    			int randPosY = cluster.getMinY() + random.nextInt(cluster.getMaxY() - cluster.getMinY());
	    			int randPosZ = blockZ + random.nextInt(16);
	    			(new WorldGenMinable(NeoNodes.nodeOre.blockID,i, cluster.getClusterSize())).generate(world, random, randPosX, randPosY, randPosZ);
	    		}
    		}
    	}
	}
	
	@ForgeSubscribe
    public void onOreGen(OreGenEvent.GenerateMinable event) {
    	if(event.type == OreGenEvent.GenerateMinable.EventType.IRON && NeoNodes.oreGenNums.get(0).isEnabled()){
    		event.setResult(OreGenEvent.Result.DENY);
    	}
    	
    	if(event.type == OreGenEvent.GenerateMinable.EventType.GOLD && NeoNodes.oreGenNums.get(1).isEnabled()) {
    		event.setResult(OreGenEvent.Result.DENY);
    	}
    	
    }

}
