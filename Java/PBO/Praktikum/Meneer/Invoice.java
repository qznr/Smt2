package Praktikum.Meneer;
import java.text.DecimalFormat;

public class Invoice implements Payable {
    private String productName;
    private int quantity, pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public DecimalFormat getDecimalFormat() {
        return new DecimalFormat("Rp#,##0.00");
    }

    public void printInvoice() {
        System.out.printf("%-20s%-20s%-20s\n", productName, getDecimalFormat().format(pricePerItem), quantity);
    }

    @Override
    public int getPayableAmount() {
        return pricePerItem * quantity;
    }
}