import java.util.Scanner;

public class NumberFormatException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập y: ");
        int y = Integer.parseInt(scanner.nextLine());
NumberFormatException numberFormatException = new NumberFormatException();
numberFormatException.calc(x,y);
    }
 private void calc(int x, int y){
        try {
            int a = x + y;
             int b = x * y;
             int c= x -y;
             int d = x / y;

            System.out.println("tổng: " + a);
            System.out.println("tích: " + b);
            System.out.println("hiệu: " + c);
            System.out.println("thương: " + d);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("nhập sai");
        }
    }
}
