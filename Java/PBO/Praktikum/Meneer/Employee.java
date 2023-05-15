package Java.PBO.Praktikum.Meneer;

public class Employee implements Payable {
    int registrationNumber, salaryPerMonth, itemsBought;
    String name;
    Invoice[] invoices = new Invoice[100];

    public Employee(int registrationNumber, int salaryPerMonth, String name) {
        this.registrationNumber = registrationNumber;
        this.salaryPerMonth = salaryPerMonth;
        this.name = name;
    }

    void buyItem(String productName, int quantity, int pricePerItem) {
        invoices[itemsBought] = new Invoice(productName, quantity, pricePerItem);
        itemsBought++;
    }

    int getTotalInvoice() {
        int totalInvoice = 0;
        for (int i = 0; i < itemsBought; i++) {
            totalInvoice += invoices[i].getPayableAmount();
        }
        return totalInvoice;
    }

    void employeeProfile() {
        System.out.println("========================================================");
        System.out.printf("%35s\n","DATA KARYAWAN");
        System.out.println("========================================================");
        System.out.printf("%-25s: %s\n","Nama", name);
        System.out.printf("%-25s: %s\n","No Registrasi", registrationNumber);
        System.out.printf("%-25s: %s\n","Gaji", df.format(salaryPerMonth));
        System.out.println("========================================================");
        System.out.printf("%-20s%-20s%-20s\n","Nama Barang", "Harga Per Barang", "Banyak Pembelian");
        for (int i = 0; i < itemsBought; i++) {
            invoices[i].printInvoice();
        }
        System.out.println("========================================================");
        System.out.printf("%-25s: %s\n","Banyaknya Invoice", df.format(getTotalInvoice()));
        System.out.printf("%-25s: %s\n","Total Gaji Bersih", df.format(getPayableAmount()));

    }

    @Override
    public int getPayableAmount() {
        return salaryPerMonth - getTotalInvoice();
    }

}
