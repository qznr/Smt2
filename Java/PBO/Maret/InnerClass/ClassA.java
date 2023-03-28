package Maret.InnerClass;

public class ClassA {
    private int y = 20;
    int x = 45;
    class B {
        // static int x = 10;
        int x = 10;
        void methodClassB(){
            System.out.println("Method dari Kelas B");
            System.out.println("Kelas B berada di dalam Kelas A");
            System.out.println("y = " + y);
            System.out.println("x di B = " + this.x);
            System.out.println("x di A = " + ClassA.this.x);
        }
    }

    void methodClassA(){
        B b = new B();
        System.out.println("Method dari Kelas A");
        System.out.println("Membuat object dari inner class B");
        b.methodClassB();
    }
}

