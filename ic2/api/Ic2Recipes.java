package ic2.api;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class Ic2Recipes {
   private static List TileEntityCompressor_recipes;
   private static List TileEntityExtractor_recipes;
   private static List TileEntityMacerator_recipes;
   private static List TileEntityRecycler_blacklist;
   private static List TileEntityMatter_amplifiers;

   public static void addCraftingRecipe(ItemStack result, Object... args) {
      try {
         Class.forName(getPackage() + ".core.AdvRecipe").getMethod("addAndRegister", ItemStack.class, Array.newInstance(Object.class, 0).getClass()).invoke((Object)null, result, args);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public static void addShapelessCraftingRecipe(ItemStack result, Object... args) {
      try {
         Class.forName(getPackage() + ".core.AdvShapelessRecipe").getMethod("addAndRegister", ItemStack.class, Array.newInstance(Object.class, 0).getClass()).invoke((Object)null, result, args);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public static List getCompressorRecipes() {
      if (TileEntityCompressor_recipes == null) {
         try {
            TileEntityCompressor_recipes = (List)Class.forName(getPackage() + ".core.block.machine.tileentity.TileEntityCompressor").getField("recipes").get((Object)null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }

      return TileEntityCompressor_recipes;
   }

   public static void addCompressorRecipe(ItemStack input, ItemStack output) {
      getCompressorRecipes().add(new SimpleEntry(input, output));
   }

   public static ItemStack getCompressorOutputFor(ItemStack input, boolean adjustInput) {
      return getOutputFor(input, adjustInput, getCompressorRecipes());
   }

   public static List getExtractorRecipes() {
      if (TileEntityExtractor_recipes == null) {
         try {
            TileEntityExtractor_recipes = (List)Class.forName(getPackage() + ".core.block.machine.tileentity.TileEntityExtractor").getField("recipes").get((Object)null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }

      return TileEntityExtractor_recipes;
   }

   public static void addExtractorRecipe(ItemStack input, ItemStack output) {
      getExtractorRecipes().add(new SimpleEntry(input, output));
   }

   public static ItemStack getExtractorOutputFor(ItemStack input, boolean adjustInput) {
      return getOutputFor(input, adjustInput, getExtractorRecipes());
   }

   public static List getMaceratorRecipes() {
      if (TileEntityMacerator_recipes == null) {
         try {
            TileEntityMacerator_recipes = (List)Class.forName(getPackage() + ".core.block.machine.tileentity.TileEntityMacerator").getField("recipes").get((Object)null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }

      return TileEntityMacerator_recipes;
   }

   public static void addMaceratorRecipe(ItemStack input, ItemStack output) {
      getMaceratorRecipes().add(new SimpleEntry(input, output));
   }

   public static ItemStack getMaceratorOutputFor(ItemStack input, boolean adjustInput) {
      return getOutputFor(input, adjustInput, getMaceratorRecipes());
   }

   private static ItemStack getOutputFor(ItemStack input, boolean adjustInput, List recipeList) {
      assert input != null;

      Iterator i$ = recipeList.iterator();

      Entry entry;
      do {
         if (!i$.hasNext()) {
            return null;
         }

         entry = (Entry)i$.next();
      } while(!((ItemStack)entry.getKey()).isItemEqual(input) || input.stackSize < ((ItemStack)entry.getKey()).stackSize);

      if (adjustInput) {
         input.stackSize -= ((ItemStack)entry.getKey()).stackSize;
      }

      return ((ItemStack)entry.getValue()).copy();
   }

   public static List getRecyclerBlacklist() {
      if (TileEntityRecycler_blacklist == null) {
         try {
            TileEntityRecycler_blacklist = (List)Class.forName(getPackage() + ".core.block.machine.tileentity.TileEntityRecycler").getField("blacklist").get((Object)null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }

      return TileEntityRecycler_blacklist;
   }

   public static void addRecyclerBlacklistItem(ItemStack newBlacklistedItem) {
      getRecyclerBlacklist().add(newBlacklistedItem);
   }

   public static void addRecyclerBlacklistItem(Item newBlacklistedItem) {
      addRecyclerBlacklistItem(new ItemStack(newBlacklistedItem, 1, -1));
   }

   public static void addRecyclerBlacklistItem(Block newBlacklistedBlock) {
      addRecyclerBlacklistItem(new ItemStack(newBlacklistedBlock, 1, -1));
   }

   public static boolean isRecyclerInputBlacklisted(ItemStack itemStack) {
      Iterator i$ = getRecyclerBlacklist().iterator();

      ItemStack blackItem;
      do {
         if (!i$.hasNext()) {
            return false;
         }

         blackItem = (ItemStack)i$.next();
      } while(!itemStack.isItemEqual(blackItem));

      return true;
   }

   public static List getScrapboxDrops() {
      try {
         return (List)Class.forName(getPackage() + ".core.item.ItemScrapbox").getMethod("getDropList").invoke((Object)null);
      } catch (Exception var1) {
         throw new RuntimeException(var1);
      }
   }

   public static void addScrapboxDrop(ItemStack dropItem, float chance) {
      try {
         Class.forName(getPackage() + ".core.item.ItemScrapbox").getMethod("addDrop", ItemStack.class, Float.TYPE).invoke((Object)null, dropItem, chance);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public static void addScrapboxDrop(Item dropItem, float chance) {
      addScrapboxDrop(new ItemStack(dropItem, 1), chance);
   }

   public static void addScrapboxDrop(Block dropItem, float chance) {
      addScrapboxDrop(new ItemStack(dropItem), chance);
   }

   public static List getMatterAmplifiers() {
      if (TileEntityMatter_amplifiers == null) {
         try {
            TileEntityMatter_amplifiers = (List)Class.forName(getPackage() + ".core.block.machine.tileentity.TileEntityMatter").getField("amplifiers").get((Object)null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }

      return TileEntityMatter_amplifiers;
   }

   public static void addMatterAmplifier(ItemStack amplifierItem, int value) {
      getMatterAmplifiers().add(new SimpleEntry(amplifierItem, value));
   }

   public static void addMatterAmplifier(Item amplifierItem, int value) {
      addMatterAmplifier(new ItemStack(amplifierItem, 1, -1), value);
   }

   public static void addMatterAmplifier(Block amplifierItem, int value) {
      addMatterAmplifier(new ItemStack(amplifierItem, 1, -1), value);
   }

   private static String getPackage() {
      Package pkg = Ic2Recipes.class.getPackage();
      return pkg != null ? pkg.getName().substring(0, pkg.getName().lastIndexOf(46)) : "ic2";
   }
}
