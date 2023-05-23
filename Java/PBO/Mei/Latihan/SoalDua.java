package Java.PBO.Mei.Latihan;

public class SoalDua {
    public static void main(String[] args) {
        functionOne(3, 4);
        functionTwo(2, 5);
    }

    private static void functionOne(double x, double y) {
        double value = 0;
        for (int i = 1; i <= 10; i++) {
            value += Math.log10(i);
        }
        System.out.println(value + Math.sin(y) + Math.cos(x));
    }

    private static void functionTwo(double x, double y) {
        double value = 0;
        x = Math.pow(x, 5);
        y = Math.pow(y, 3);
        value = Math.sqrt(x*(1/y));
        System.out.println(value);
    }
}
