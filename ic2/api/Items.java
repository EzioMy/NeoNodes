package ic2.api;

import net.minecraft.item.ItemStack;

public final class Items {
   private static Class Ic2Items;

   public static ItemStack getItem(String name) {
      try {
         if (Ic2Items == null) {
            Ic2Items = Class.forName(getPackage() + ".core.Ic2Items");
         }

         Object ret = Ic2Items.getField(name).get((Object)null);
         return ret instanceof ItemStack ? (ItemStack)ret : null;
      } catch (Exception var2) {
         System.out.println("IC2 API: Call getItem failed for " + name);
         return null;
      }
   }

   private static String getPackage() {
      Package pkg = Items.class.getPackage();
      return pkg != null ? pkg.getName().substring(0, pkg.getName().lastIndexOf(46)) : "ic2";
   }
}
