import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMethod {
    Scanner scanner = new Scanner(System.in);


    public AtmMethod(String name, int many) {
        super(name, many);
    }

    public final static List<Account> arr = new ArrayList<>();
    public static int size = 0;


    public static void checkBank() {
        System.out.println(getBalance());

    }


    public static void add(String name, int many) {
        arr.add(new Account("Nguyen Van A", 1200000));
        size++;
    }


    public static void seach() {
        System.out.println(arr);
    }


    public static void napMany() {



        int amount = scanner.nextInt();

        System.out.println("giao dich thanh cong. Ban vua nap " + amount + " thanh cong");
        // amount = 100000
        // A : 1200000
        System.out.println("so du tai khoan ngan hang la: " + (amount + getBalance()) + "VND");
        //                                           in           1300000
        // A:

        System.out.println("bam nut b de thuc hien giao dich");
        AtmMethod.add(  "Nguyen Van A",setMany( (amount + getBalance())));

    }


    public static void rutMany() {
        Scanner scanner = new Scanner(System.in);
        int rutMany = scanner.nextInt();

        System.out.println("giao dich thanh cong. Ban vua rut " + rutMany + " thanh cong");
        System.out.println("so du tai khoan la: " + (getBalance() - rutMany) + "VND");

        System.out.println("bam nut de thuc hien giao dich: ");

        if (rutMany > getBalance()) {
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

    public static void exit() {
        System.out.println("Thoát khỏi chương trình");
        System.out.println("In màn hình: Cam on ban da su dung dich vu ATM");
    }

}
