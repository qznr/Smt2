package Praktikum.Meneer;
import java.text.DecimalFormat;

public class Employee implements Payable {
    private int registrationNumber, salaryPerMonth, itemsBought;
    private String name;
    private Invoice[] invoices = new Invoice[100];

    public Employee(int registrationNumber, int salaryPerMonth, String name) {
        this.registrationNumber = registrationNumber;
        this.salaryPerMonth = salaryPerMonth;
        this.name = name;
    }

    public DecimalFormat getDecimalFormat() {
        return new DecimalFormat("Rp#,##0.00");
    }

    public void buyItem(String productName, int quantity, int pricePerItem) {
        invoices[itemsBought] = new Invoice(productName, quantity, pricePerItem);
        itemsBought++;
    }

    public int getTotalInvoice() {
        int totalInvoice = 0;
        for (int i = 0; i < itemsBought; i++) {
            totalInvoice += invoices[i].getPayableAmount();
        }
        return totalInvoice;
    }

    public void employeeProfile() {
        System.out.println("========================================================");
        System.out.printf("%35s\n","DATA KARYAWAN");
        System.out.println("========================================================");
        System.out.printf("%-25s: %s\n","Nama", name);
        System.out.printf("%-25s: %s\n","No Registrasi", registrationNumber);
        System.out.printf("%-25s: %s\n","Gaji", getDecimalFormat().format(salaryPerMonth));
        System.out.println("========================================================");
        System.out.printf("%-20s%-20s%-20s\n","Nama Barang", "Harga Per Barang", "Banyak Pembelian");
        for (int i = 0; i < itemsBought; i++) {
            invoices[i].printInvoice();
        }
        System.out.println("========================================================");
        System.out.printf("%-25s: %s\n","Banyaknya Invoice", getDecimalFormat().format(getTotalInvoice()));
        System.out.printf("%-25s: %s\n","Total Gaji Bersih", getDecimalFormat().format(getPayableAmount()));

    }

    @Override
    public int getPayableAmount() {
        return salaryPerMonth - getTotalInvoice();
    }
}