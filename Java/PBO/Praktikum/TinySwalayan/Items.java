package Praktikum.TinySwalayan;
import java.util.ArrayList;

public class Items {
    private String itemId;
    private String itemName;
    private double price;
    private String category;
    private int quantity;
    private static ArrayList<Smartphone> smartphones = new ArrayList<>();
  
    public Items(String itemId, String itemName, double price, String category, int quantity) {
      this.itemId = itemId;
      this.itemName = itemName;
      this.price = price;
      this.category = category;
      this.quantity = quantity;
    }
  
    public String getItemId() {
      return itemId;
    }
  
    public void setItemId(String itemId) {
      this.itemId = itemId;
    }
  
    public String getItemName() {
      return itemName;
    }
  
    public void setItemName(String itemName) {
      this.itemName = itemName;
    }
  
    public double getPrice() {
      return price;
    }
  
    public void setPrice(double price) {
      this.price = price;
    }
  
    public String getCategory() {
      return category;
    }
  
    public void setCategory(String category) {
      this.category = category;
    }
  
    public int getQuantity() {
      return quantity;
    }
  
    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  
    public static ArrayList<Smartphone> getSmartphones() {
      return smartphones;
    }
  
    public static void addSmartphone(Smartphone smartphone) {
      smartphones.add(smartphone);
    }
}