package neonodes.worldgen;

public class NodeOreCluster {
	
	private int qty;
	private int minY;
	private int maxY;
	private int numCluster;
	private int clusterSize;
	private boolean enabled;
	
	/**
	 * Ore Cluster
	 * @param qty
	 * @param minY
	 * @param maxY
	 * @param numCluster
	 * @param clusterSize
	 */
	public NodeOreCluster(boolean enabled, int qty, int minY, int maxY, int numCluster, int clusterSize) {
		this.enabled = enabled;
		this.qty = qty;
		this.minY = minY;
		this.maxY = maxY;
		this.numCluster = numCluster;
		this.clusterSize = clusterSize;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public int getQty() {
		return qty;
	}


	public int getMinY() {
		return minY;
	}


	public int getMaxY() {
		return maxY;
	}


	public int getNumCluster() {
		return numCluster;
	}


	public int getClusterSize() {
		return clusterSize;
	}
		


}
