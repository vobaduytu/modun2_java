import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interest = 1.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("xin moi ban nhap so tien");
        money = sc.nextDouble();
        System.out.println("xin moi ban nhap so thang muon gui");
        month = sc.nextInt();
        System.out.println("nhap lai suat");
        interest = sc.nextDouble();
        double calculation = 0;
        for (int i = 0; i < month;i++){
            calculation += money*(interest/100)/12*month;

        }
        System.out.println("so tien nhan:" + calculation);255
    }
}
