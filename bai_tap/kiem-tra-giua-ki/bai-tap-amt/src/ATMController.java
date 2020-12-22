import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMController {
    private static Scanner scanner = new Scanner(System.in);
    private static Account account;
    private static ArrayList<String> history = new ArrayList<>();

    public static void setAccount(String name, int money) {
        account = new Account(name, money);
        System.out.println("Ngan hang ABC kinh chao Quy khach " + name);
    }

    public static void run() {
        while (true) {
            String chon = getOption();
            switch (chon) {
                case "A":
                    checkAccountBalance();
                    break;
                case "D":
                    depositMoney();
                    break;
                case "W":
                    withdrawalMoney();
                    break;
                case "H":
                    showHistory();
                    break;
                case "X":
                    exit();
                    return;
                default:
                    System.out.println("ban nhap sai chuc nang");
                    break;
            }
            System.out.println("\nBam nut theo menu de tiep tuc giao dich\n" +
                    "===========================================");
        }
    }

    private static String getOption() {
        System.out.println(" Menu:");
        System.out.println("1.  nhấn phím A để kiểm tra tài khoản");
        System.out.println("2.  nhấn phím D để nạp tiền");
        System.out.println("3.  nhấn phím W để rút tiền");
        System.out.println("4.  nhấn phím H để xem lịch sử 3 lần");
        System.out.println("5.  nhấn phím X để thoát");
        System.out.println("------------------------------");
        System.out.println("------------------------------");

        System.out.println(" nhập lựa chọn của bạn:");
        return scanner.nextLine().toUpperCase();
    }


    private static void checkAccountBalance() {
        System.out.println("so du hien co trong tai khoan: " + account.getBalance());
    }

    private static void depositMoney() {
        System.out.println("so tien ban muon nap");
        int amount = Integer.parseInt(scanner.nextLine());

        boolean result = account.deposit(amount);
        if (result) {
            System.out.println("giao dich thanh cong. Ban vua nap " + amount + " thanh cong");
            history.add("Nap: " + amount);
        } else {
            System.out.println("giao dich that bai, khong the nap so tien am.");
        }

        checkAccountBalance();
    }


    private static void withdrawalMoney() {
        System.out.println("so tien ban muon rut");
        int amount = Integer.parseInt(scanner.nextLine());
        boolean result = account.withdrawal(amount);
        if (result) {
            System.out.println("giao dich thanh cong. Ban vua rut " + amount + " thanh cong");
            history.add("Rut: " + amount);
        } else {
            System.out.println("giao dich that bai, so tien khong hop le hoac lon hon so du hien tai");
        }
        checkAccountBalance();
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Lich su giao dich trong");
            return;
        }
        System.out.println("Lich su 3 lan giao dich gan nhat:");
        int limit = Math.max(history.size() - 3, 0);
        for (int i = history.size() - 1; i >= limit ; i--) {
            System.out.println(history.get(i));
        }
    }

    private static void exit() {
        System.out.println("Thoát khỏi chương trình");
        System.out.println("In màn hình: Cam on ban da su dung dich vu ATM");
    }
}
