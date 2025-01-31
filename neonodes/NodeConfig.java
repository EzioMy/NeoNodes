package neonodes;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class NodeConfig {
	
	public static int itemID;
	public static int oreID;
	public static int blockID;

	
	public static boolean ironOreEnabled;
	public static boolean goldOreEnabled;
	public static boolean copperOreEnabled;
	public static boolean tinOreEnabled;
	public static boolean silverOreEnabled;
	public static boolean leadOreEnabled;
	public static boolean nickelOreEnabled;
	
	public static int ironMinY;
    public static int ironMaxY;
    public static int ironNumCluster;
    public static int ironClusterSize;
    public static int ironDropQty;

    public static int goldMinY;
    public static int goldMaxY;
    public static int goldNumCluster;
    public static int goldClusterSize;
    public static int goldDropQty;

    public static int copperMinY;
    public static int copperMaxY;
    public static int copperNumCluster;
    public static int copperClusterSize;
    public static int copperDropQty;

    public static int tinMinY;
    public static int tinMaxY;
    public static int tinNumCluster;
    public static int tinClusterSize;
    public static int tinDropQty;

    public static int silverMinY;
    public static int silverMaxY;
    public static int silverNumCluster;
    public static int silverClusterSize;
    public static int silverDropQty;

    public static int leadMinY;
    public static int leadMaxY;
    public static int leadNumCluster;
    public static int leadClusterSize;
    public static int leadDropQty;

    public static int nickelMinY;
    public static int nickelMaxY;
    public static int nickelNumCluster;
    public static int nickelClusterSize;
    public static int nickelDropQty;

	
	

	
	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		itemID = config.getItem("NodeItems", 700).getInt();
		oreID = config.getBlock("NodeOre", 701).getInt();
		blockID = config.getBlock("NodeBlock", 702).getInt();
		
		ironOreEnabled = config.get(config.CATEGORY_GENERAL, "Iron ore enabled", true).getBoolean(true);
        ironMinY = config.get(config.CATEGORY_GENERAL, "Iron ore minimum y", 0).getInt();
        ironMaxY = config.get(config.CATEGORY_GENERAL, "Iron ore maximum y", 64).getInt();
        ironNumCluster = config.get(config.CATEGORY_GENERAL, "Iron ore number of clusters", 20).getInt();
        ironClusterSize = config.get(config.CATEGORY_GENERAL, "Iron ore cluster size", 9).getInt();
        ironDropQty = config.get(config.CATEGORY_GENERAL, "Raw Iron drop quantity", 1).getInt();

        goldOreEnabled = config.get(config.CATEGORY_GENERAL, "Gold ore enabled", true).getBoolean(true);
        goldMinY = config.get(config.CATEGORY_GENERAL, "Gold ore minimum y", 0).getInt();
        goldMaxY = config.get(config.CATEGORY_GENERAL, "Gold ore maximum y", 31).getInt();
        goldNumCluster = config.get(config.CATEGORY_GENERAL, "Gold ore number of clusters", 2).getInt();
        goldClusterSize = config.get(config.CATEGORY_GENERAL, "Gold ore cluster size", 10).getInt();
        goldDropQty = config.get(config.CATEGORY_GENERAL, "Raw Gold drop quantity", 1).getInt();

        copperOreEnabled = config.get(config.CATEGORY_GENERAL, "Copper ore enabled", true).getBoolean(true);
        copperMinY = config.get(config.CATEGORY_GENERAL, "Copper ore minimum y", 40).getInt();
        copperMaxY = config.get(config.CATEGORY_GENERAL, "Copper ore maximum y", 75).getInt();
        copperNumCluster = config.get(config.CATEGORY_GENERAL, "Copper ore number of clusters", 16).getInt();
        copperClusterSize = config.get(config.CATEGORY_GENERAL, "Copper ore cluster size", 9).getInt();
        copperDropQty = config.get(config.CATEGORY_GENERAL, "Raw Copper drop quantity", 1).getInt();

        tinOreEnabled = config.get(config.CATEGORY_GENERAL, "Tin ore enabled", true).getBoolean(true);
        tinMinY = config.get(config.CATEGORY_GENERAL, "Tin ore minimum y", 25).getInt();
        tinMaxY = config.get(config.CATEGORY_GENERAL, "Tin ore maximum y", 50).getInt();
        tinNumCluster = config.get(config.CATEGORY_GENERAL, "Tin ore number of clusters", 8).getInt();
        tinClusterSize = config.get(config.CATEGORY_GENERAL, "Tin ore cluster size", 5).getInt();
        tinDropQty = config.get(config.CATEGORY_GENERAL, "Raw Tin drop quantity", 1).getInt();

        silverOreEnabled = config.get(config.CATEGORY_GENERAL, "Silver ore enabled", true).getBoolean(true);
        silverMinY = config.get(config.CATEGORY_GENERAL, "Silver ore minimum y", 15).getInt();
        silverMaxY = config.get(config.CATEGORY_GENERAL, "Silver ore maximum y", 35).getInt();
        silverNumCluster = config.get(config.CATEGORY_GENERAL, "Silver ore number of clusters", 4).getInt();
        silverClusterSize = config.get(config.CATEGORY_GENERAL, "Silver ore cluster size", 9).getInt();
        silverDropQty = config.get(config.CATEGORY_GENERAL, "Raw Silver drop quantity", 1).getInt();

        leadOreEnabled = config.get(config.CATEGORY_GENERAL, "Lead ore enabled", true).getBoolean(true);
        leadMinY = config.get(config.CATEGORY_GENERAL, "Lead ore minimum y", 20).getInt();
        leadMaxY = config.get(config.CATEGORY_GENERAL, "Lead ore maximum y", 40).getInt();
        leadNumCluster = config.get(config.CATEGORY_GENERAL, "Lead ore number of clusters", 4).getInt();
        leadClusterSize = config.get(config.CATEGORY_GENERAL, "Lead ore cluster size", 7).getInt();
        leadDropQty = config.get(config.CATEGORY_GENERAL, "Raw Lead drop quantity", 1).getInt();

        nickelOreEnabled = config.get(config.CATEGORY_GENERAL, "Nickel ore enabled", true).getBoolean(true);
        nickelMinY = config.get(config.CATEGORY_GENERAL, "Nickel ore minimum y", 5).getInt();
        nickelMaxY = config.get(config.CATEGORY_GENERAL, "Nickel ore maximum y", 20).getInt();
        nickelNumCluster = config.get(config.CATEGORY_GENERAL, "Nickel ore number of clusters", 2).getInt();
        nickelClusterSize = config.get(config.CATEGORY_GENERAL, "Nickel ore cluster size", 4).getInt();
        nickelDropQty = config.get(config.CATEGORY_GENERAL, "Raw Nickel drop quantity", 1).getInt();
        
        config.save();
		
	}

}
