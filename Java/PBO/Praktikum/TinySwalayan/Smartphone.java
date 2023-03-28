package Praktikum.TinySwalayan;

public class Smartphone extends Items {

    private String brand;
  
    public Smartphone(String itemId, String itemName, double price, String category, int quantity, String brand) {
      super(itemId, itemName, price, category, quantity);
      this.brand = brand;
    }
  
    public String getBrand() {
      return brand;
    }
  
    public void setBrand(String brand) {
      this.brand = brand;
    }
}