import java.util.Scanner;

public class Main5 {
    public static String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so 16 cua ban: ");
        String src = scanner.nextLine().toUpperCase();

        int sum = 0;
        for (int i = 0; i < src.length(); i++) {
            char digit = src.charAt(i);

            int number = parseDigit(digit);

            if (number == -1) {
                System.out.println("nhap sai so");
                return;
            }

            int tinh = (int) (number * Math.pow(16, src.length() - 1 - i));
            sum += tinh;
        }
        System.out.println(sum);
    }

    public static int parseDigit(char digit) {
        String digitStr = String.valueOf(digit);
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].equals(digitStr))
                return i;
        }
        return -1;
    }
}
