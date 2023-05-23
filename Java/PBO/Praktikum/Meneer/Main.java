package Praktikum.Meneer;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee(112233, 2000000, "Adi");
        emp.buyItem("pocari", 2, 5000);
        emp.buyItem("poca", 3, 2000);
        emp.buyItem("poi", 1, 4000);
        emp.employeeProfile();

    }
}
