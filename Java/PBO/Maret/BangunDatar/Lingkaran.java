package Maret.BangunDatar;

public class Lingkaran extends BangunDatar {
    double radius;

    public Lingkaran(double radius){
        this.radius = radius; 
    }

    public double luas(){
        return Math.PI*radius*radius;
    }

    public double keliling(){
        return Math.PI*2*radius;
    }
}
