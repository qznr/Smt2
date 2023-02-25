package Februari;
public class Test23 {
    public static void main(String[] args) {
        Car bugatti = new Car("Gold",999,9000);
        bugatti.drive();
        System.out.println("Color : " + bugatti.getColor());
        System.out.println("Speed : " + bugatti.getSpeed());
        System.out.println("Power : " + bugatti.getPower());
        Car lamborgini = new Car("Yellow",5,20);
        lamborgini.drive();
        System.out.println("Color : " + lamborgini.getColor());
        System.out.println("Speed : " + lamborgini.getSpeed());
        System.out.println("Power : " + lamborgini.getPower());
    }
}
