package Maret.Enum;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee c = new Coffee(Size.SMALL);
        System.out.println(c.getPrice());
    }
}