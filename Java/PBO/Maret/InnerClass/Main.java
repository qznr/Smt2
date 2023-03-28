package Maret.InnerClass;

public class Main {
    public static void main(String[] args) {
        ClassA.B b = new ClassA().new B();
        b.methodClassB();
        ClassA a = new ClassA();
        a.methodClassA();
    }
}
