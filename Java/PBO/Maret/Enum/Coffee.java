package Maret.Enum;

public class Coffee {
    private Size size;

    public Coffee(Size size) {
        this.size = size;
    }

    public double getPrice() {
        switch(size){
            case SMALL: return 20;
            case MEDIUM: return 30;
            case LARGE: return 40;
            default: return 0;
        }
    }

    public void setSize(Size size) {
        this.size = size;
    }
}