public class Circle {
    double radius;

    public double area(){
        return Math.pow(radius,2 )* Math.PI;
    }
    public double circumference(){
        return Math.PI * 2 * radius;
    }
}
