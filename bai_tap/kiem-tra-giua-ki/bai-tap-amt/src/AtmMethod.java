import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMethod {
    public int sumMany = 1200000;


    public final static List<AtmGoc> arr = new ArrayList<>();
    public static int size = 0;


    public static void add(String name, int many) {
        arr.add(new AtmGoc("Nguyen Van A", 1200000));
        size++;
    }


    public static void seach() {
        System.out.println(arr);
    }


    public static void napMany() {

        Scanner scanner = new Scanner(System.in);

        int napMany = scanner.nextInt();
        System.out.println("giao dich thanh cong. Ban vua nap " + napMany +  " thanh cong");

        System.out.println("so du tai khoan ngan hang la: " + napMany + "VND");

        System.out.println("bam nut b de thuc hien giao dich");
    }


    public static void rutMany() {
        Scanner scanner = new Scanner(System.in);
        int rutMany = scanner.nextInt();

        System.out.println("giao dich thanh cong. Ban vua rut " + rutMany +  " thanh cong");
//        System.out.println("so du tai khoan la: " + rutMany + "VND");

        System.out.println("bam nut de thuc hien giao dich: ");

        if (rutMany > 1200000) {
            System.out.println("khong rut duoc tien do thieu tien");
            System.out.println("giao dich khong thanh cong");
//            System.out.println("so du tai khoan la: " + 1200000);
            System.out.println("ban khong the rut");
        }

    }

    public static void history() {
        System.out.println("lịch sử giao dịch: ");
        System.out.println("1. Nap tien: 100000VND");
        System.out.println("2. Nap tien: 200000VND");
        System.out.println("3. Nap tien: 300000VND");


    }
    public static void exit(){
        System.out.println("Thoát khỏi chương trình");
        System.out.println("In màn hình: Cam on ban da su dung dich vu ATM");
    }

}
