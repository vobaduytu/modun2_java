import java.util.Arrays;
import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap do dai mang cua ban:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("nhap gia tri mang");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        int min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
            }
        }
        System.out.println("gia tri nho nhat: "+ min);
    }
}
