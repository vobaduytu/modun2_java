import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("nhap so cua ban: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());

        }
        System.out.println(" ");
        System.out.println("nhap so nhi phan muon chuyen");
        int t = sc.nextInt();
        String s = Integer.toString(t);
        int sum = 0;
       for (int i = 0; i < s.length();i++){

           char srt = s.charAt(i);
           int number = Integer.parseInt(String.valueOf(srt));
           int aVinh = (int) (number*Math.pow(2,s.length()-1-i));
           sum += aVinh;

       }
        System.out.print(sum);

    }
}
