import java.util.Scanner;

public class TienTe {
    public static void main(String[] args) {
        double VND = 23000;
        double USD;
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap so tien");
        USD = sc.nextDouble();
        double QuyDoi = USD * 23000;
        System.out.println("gia tri:" + QuyDoi);
    }
}
