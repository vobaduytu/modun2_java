import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    public static void main(String[] args) {
        String[] digits = {"0", "1", "2", "3", "4", "5", "6","7","8","9","A","B","C","D","E","F"};
        Stack<Integer> stack = new Stack<>();
        System.out.println("Nhap so cua ban: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while (num != 0){
            stack.push(num % 16);
            num= num/16;
        }
        while (!stack.isEmpty()){
            System.out.print(digits[stack.pop()]);
        }

    }
}
