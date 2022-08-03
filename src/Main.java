package src;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int menu = 100;

    //? Awal Program
    public static void main(String[] args) {

        while (menu <= 100){
            System.out.println("================== [ Menu ] ==================");
            System.out.println("1. Persegi");
            System.out.println("2. Persegi Panjang");
            System.out.println("3. Linkaran");
            System.out.println("4. Keluar");
            System.out.println("==============================================");
            System.out.print("Masukkan pilihan anda : ");
            menu = input.nextInt();

            if(menu == 1){
                persegi();
            } else if (menu == 2){
                persegiPanjang();
            } else if (menu == 3){
                lingkaran();
            } else if (menu == 4){
                System.exit(0);
            }else {
                System.out.println("Pilihan tidak ada");
                pertanyaankembali();
            }
        }


        input.close();
        System.exit(0);
    }

    static void pertanyaankembali(){
        System.out.print("Apakah anda ingin menghitung lagi? (y/n) : ");
        String jawab = input.next();
        if(jawab.equals("y")){
            menu = 100;
        } else if(jawab.equals("n")){
            menu = 999;
        } else {
            System.out.println("Pilihan tidak ada");
            pertanyaankembali();
        }
    }

    /*
    Todo ========================================
    Todo    Perhitungan bangun datar
    Todo ========================================
    */
    
    static void persegi() {
        Persegi p = new Persegi();
        System.out.print("Masukan panjang Sisi : ");
        p.sisi = (double) input.nextInt();

        p.keliling();
        p.luas();

        pertanyaankembali();    //? Pertanyaan kembali
    }
    static void persegiPanjang(){
        PersegiPanjang pp = new PersegiPanjang();

        System.out.print("Masukan panjang : ");
        pp.panjang = (double) input.nextInt();
        System.out.print("Masukan lebar : ");
        pp.lebar = (double) input.nextInt();

        
        pp.keliling();
        pp.luas();

        pertanyaankembali();    
    }
    static void lingkaran(){
        Lingkaran l = new Lingkaran();

        System.out.print("Masukan jari-jari lingkaran : ");
        l.jari = input.nextInt();

        System.out.println("==============================================");

        l.keliling();
        l.luas();

        pertanyaankembali();    
    }

}