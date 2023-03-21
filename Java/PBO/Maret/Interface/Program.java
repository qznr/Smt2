package Maret.Interface;

public class Program {
    
    public static void main(String[] args) {
        CetakSemua cetak = new CetakSemua();
        System.out.println(cetak.cetakStr1("Halo Bandung"));
        System.out.println(cetak.cetakStr2("Halo Jakarta"));
        System.out.println(cetak.cetakInt1(19));
        System.out.println(cetak.cetakInt2(1));
        cetak.cetak();
    }
}
