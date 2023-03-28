package Maret.Interface;

import java.util.function.DoubleToIntFunction;

public interface InterfaceString {
    public String cetakStr1(String x);
    public String cetakStr2(String x);

    default void msg(){
        System.out.println("Default msg");
    } 

    static void start(){
        System.out.println("Mulai pencetakan");
    }
}
