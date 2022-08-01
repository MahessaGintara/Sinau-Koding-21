import java.util.Scanner;

public class bilanganPrima {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan bilangan : ");
        int number = input.nextInt();
        
        input.close();

        for (int i = 0; i <= number; i++) {
            mencariBilanganPrima(i);
        }
    }
    public static void mencariBilanganPrima(int n) {
        int i, flag = 0;
        for (i = 2; i <= n / 2 ; ++i) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(n+" Bilangan prima");
        } else {
            System.out.println(n+" Bukan bilangan prima");
        }
    }

}