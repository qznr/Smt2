package Maret.InnerClass;

public class A2 {

    void methodDiA() {
        class B {
            int i = 10;
            void methodDiB() {
                System.out.println("i = " + i);
            }
        }
        B b = new B();
        b.methodDiB();
    }
}