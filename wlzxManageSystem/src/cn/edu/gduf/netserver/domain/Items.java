package cn.edu.gduf.netserver.domain;

/**
 * 物品信息
 * @author tmn
 *
 */
public class Items {
   private int itemID;
   private String itemName;
   private String reserved1;
   private String reserved2;
   

   public int getItemID() {
      return itemID;
   }
   

   public void setItemID(int newItemID) {
      itemID = newItemID;
   }
   

   public String getItemName() {
      return itemName;
   }
   

   public void setItemName(String newItemName) {
      itemName = newItemName;
   }
   

   public String getReserved1() {
      return reserved1;
   }
   

   public void setReserved1(String newReserved1) {
      reserved1 = newReserved1;
   }
   

   public String getReserved2() {
      return reserved2;
   }
   

   public void setReserved2(String newReserved2) {
      reserved2 = newReserved2;
   }

}