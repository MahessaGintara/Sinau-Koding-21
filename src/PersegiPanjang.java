package src;
public class PersegiPanjang implements MainInterface{

    double panjang, lebar;

    @Override
    public void keliling() {
        double keliling = panjang * 2 + lebar * 2;
        System.out.println("keliling : " + keliling);
    }
    
    @Override
    public void luas() {
        double luas = panjang * lebar;
        System.out.println("Luas : " + luas);
    }
} 