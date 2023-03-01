

public class Rectangle {
    double width;
    double length;

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public double area(){
        return this.width*this.length;
    }
    public double circumference(){
        return 2*(this.width+this.length);
    }
}
