package Java.PBO.Praktikum.Meneer;

public class Invoice implements Payable {
    String productName;
    int quantity, pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    void printInvoice() {
        System.out.printf("%-20s%-20s%-20s\n", productName, pricePerItem, quantity);
    }

    @Override
    public int getPayableAmount() {
        return pricePerItem * quantity;
    }
}