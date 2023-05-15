package Java.PBO.Praktikum.Meneer;
import java.text.DecimalFormat;

public interface Payable {
    public DecimalFormat df = new DecimalFormat("Rp#,##0.00");
    int getPayableAmount();
}