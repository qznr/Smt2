package Maret;
public class Manager extends Pegawai{
    public String departemen;

    public Manager(){
    }

    public Manager(String departemen){
        this.departemen = departemen;
    }

    public Manager(String departemen, String nama, double gaji){
        super(nama,gaji);
        this.departemen = departemen;
    }

    void isiGaji(double gaji){
        super.gaji = gaji;
    }

    public void print(){
        super.print();
        System.out.println("Departemen : " + departemen);
    }
}
