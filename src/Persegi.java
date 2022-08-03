package src;
public class Persegi implements MainInterface {
    Double sisi;

    @Override
    public void keliling() {
        double keliling = sisi * 4;
        System.out.println("keliling adalah : " + keliling);
    }

    @Override
    public void luas() {
        double luas = sisi * sisi;
        System.out.println("Luas : " + luas);
    }
}
    