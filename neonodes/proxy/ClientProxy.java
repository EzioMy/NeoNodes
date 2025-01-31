package neonodes.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	public void registerRenderInformation(){
		MinecraftForgeClient.preloadTexture("/neonodes/gfx/NeoNodes.png");
	}
	
}
