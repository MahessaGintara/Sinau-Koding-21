import java.util.Scanner;

public class menghitungBangunDatar {
    public static Scanner input = new Scanner(System.in);
    
    //? Awal Program
    public static void main(String[] args) {

        //? pemanggilan function menu
        menu();

        input.close();
        System.exit(0);
    }

    //? menampilkan menu
    static void menu(){
        System.out.println("================== [ Menu ] ==================");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Linkaran");
        System.out.println("4. Keluar");
        System.out.println("==============================================");
        System.out.print("Masukkan pilihan anda : ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            persegi();
        } else if (pilihan == 2){
            persegiPanjang();
        } else if (pilihan == 3){
            lingkaran();
        } else if (pilihan == 4){
            System.exit(0);
        }else {
            System.out.println("Pilihan tidak ada");
            menu();
        } 
        
    }

    static void pertanyaankembali(){
        System.out.print("Apakah anda ingin menghitung lagi? (y/n) : ");
        String jawab = input.next();
        if(jawab.equals("y")){
            menu();
        } else if(jawab.equals("n")){
            System.exit(0);
        } else {
            System.out.println("Pilihan tidak ada");
        }
    }

    /*
    Todo ========================================
    Todo    Perhitungan bangun datar
    Todo ========================================
    */
    
    static void persegi() {
        System.out.print("Masukan sisi persegi : ");
        int sisi = input.nextInt();

        System.out.println("==============================================");

        //? Luas Persegi
        int luas = sisi * sisi ;
        System.out.println("Luas Persegi : " + luas);

        //? Keliling Persegi
        int keliling = sisi * 4 ;
        System.out.println("Keliling Persegi : " + keliling);

        pertanyaankembali();    //? Pertanyaan kembali
    }
    static void persegiPanjang(){
        System.out.print("Masukan panjang persegi : ");
        int panjang = input.nextInt();
        System.out.print("Masukan lebar persegi : ");
        int lebar = input.nextInt();

        System.out.println("==============================================");

        //? Luas Persegi panjang
        int luas = panjang * lebar ;
        System.out.println("Luas Persegi Panjang : " + luas);

        //? keliling Persegi panjang
        int keliling = (panjang + lebar) * 2 ;
        System.out.println("Keliling Persegi Panjang : " + keliling);

        pertanyaankembali();    
    }
    static void lingkaran(){
        System.out.print("Masukan jari-jari lingkaran : ");
        int jari = input.nextInt();

        System.out.println("==============================================");

        //? Luas Lingkaran
        double luas =  (3.14 * jari * jari) ;
        System.out.println("Luas Lingkaran : " + luas);

        //? Keliling Lingkaran
        double keliling = 2 * 3.14 * jari ;
        System.out.println("Keliling Lingkaran : " + keliling);

        pertanyaankembali();    
    }

}