public class Test {
    public static void main(String[] args) {
        Car bugatti = new Car();
        bugatti.setColor("Gold");
        bugatti.setSpeed(999);
        bugatti.setPower( 9000); 
        bugatti.drive();
        System.out.println("Color : " + bugatti.getColor());
        System.out.println("Speed : " + bugatti.getSpeed());
        System.out.println("Power : " + bugatti.getPower());
        Car ferrari = new Car();
        ferrari.setColor("Brown");
        ferrari.setSpeed(0);
        ferrari.setPower(-9000); 
        ferrari.stop();
        System.out.println("Color : " + ferrari.getColor());
        System.out.println("Speed : " + ferrari.getSpeed());
        System.out.println("Power : " + ferrari.getPower());
    }
}
