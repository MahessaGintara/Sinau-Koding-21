import java.util.Scanner;
import java.util.HashMap;

public class dataSiswa{
    static Scanner input = new Scanner(System.in);
    static int menu = 100;
    public static void main(String[] args) {
        //? deklarasi datasiswa sebagay hashmap
        HashMap<String, Integer> dataSiswa = new HashMap<>();
        //? menu utama
        while(menu <= 100){
            System.out.println("================== [ Menu ] ==================");
            System.out.println("1. Input Data Siswa");
            System.out.println("2. Lihat Data Siswa");
            System.out.println("3. Keluar");
            System.out.println("==============================================");

            System.out.print("Pilih Menu : ");
            menu = input.nextInt();

            switch(menu){

                //? input data siswa
                case 1:
                    System.out.print("Masukkan Jumlah Siswa : ");
                    int jumlahSiswa = input.nextInt();
                    for(int i = 0; i < jumlahSiswa; i++){
                        System.out.println("==============================================");
                        System.out.print("Masukkan Nama Siswa : ");
                        String namaSiswa = input.next();
                        System.out.print("Masukkan Nilai Siswa : ");
                        int nilaiSiswa = input.nextInt();
                        dataSiswa.put(namaSiswa, nilaiSiswa);
                    }
                    tampilkanData(dataSiswa);
                    break;

                //? menampilkan data siswa
                case 2:
                    tampilkanData(dataSiswa);
                    break;
                
                //? keluar dari program
                case 3:
                    System.out.println("Terima Kasih");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Menu tidak ada");
                    break;
            }
        }
    }
    //? method untuk menampilkan data siswa
    static void tampilkanData(HashMap<String, Integer> dataSiswa){
        int index = 1;
        System.out.println(String.format("%4s %-20s %6s %s", "No", "Nama", "Nilai", "Status"));
        for(String key : dataSiswa.keySet()){
            String flag = "Tidak Lulus";
            if(dataSiswa.get(key) >= 65){
                flag = "Lulus";
            }
            System.out.println(String.format("%4d %-20s %6d %s", index++ , key , dataSiswa.get(key) , flag));
        }
    }
}