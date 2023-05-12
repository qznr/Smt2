package Praktikum.Labkomdas;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private String title;
    private ArrayList<Menu> children;
    private Scanner in;
    public DecimalFormat df = new DecimalFormat("Rp#,##0.00");

    public Menu(String title) {
        this.title = title;
        this.children = new ArrayList<Menu>();
        this.in = new Scanner(System.in);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addChild(Menu child) {
        this.children.add(child);
    }

    public Menu getChild(int index) {
        return this.children.get(index);
    }

    public int getNumChildren() {
        return this.children.size();
    }

    public abstract void display();

    public abstract void execute();

    public void run() {
        this.display();
        this.execute();
    }

    protected int getUserInput() {
        System.out.print("Pilihan Anda: ");
        int choice = in.nextInt();
        in.nextLine();
        return choice;
    }

    protected double getDoubleInput(String prompt) {
        System.out.print(prompt + " ");
        return in.nextDouble();
    }
}
