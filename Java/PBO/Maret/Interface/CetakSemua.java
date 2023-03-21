package Maret.Interface;

public class CetakSemua implements Interface{
    public String cetakStr1(String x){
        return "String 1 : " + x;
    }
    
    public String cetakStr2(String x){
        return "String 2 : " + x;
    }

    public String cetakInt1(int x){
        return "Integer 1 : " + x;
    }

    public String cetakInt2(int x){
        return "Integer 2 : " + x;
    }

    public void cetak(){
        System.out.println("Semua telah tercetak");
    }
}
