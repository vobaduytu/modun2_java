import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so nhi phan muon chuyen: ");
        int num = scanner.nextInt();

        String src = Integer.toString(num);


        for (int i = 0; i < src.length();i++){
         char ch = src.charAt(i);
         int number2 = Integer.parseInt(String.valueOf(ch));
         stack.push(number2);
        }

         int sum = 0;
         for (int i = 0; i < src.length(); i++){
               sum+=  stack.pop()*Math.pow(2,src.length()-i);

         }
        System.out.println(sum);

    }
}
