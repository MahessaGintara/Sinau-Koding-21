package src;
public class Lingkaran implements MainInterface {
    int jari;
    
    @Override
    public void keliling() {
        double keliling = 2 * 3.14 * jari;
        System.out.println("keliling : " + keliling);
    }
    
    @Override
    public void luas() {
        double luas = 3.14 * jari * jari;
        System.out.println("Luas : " + luas);
    }
}