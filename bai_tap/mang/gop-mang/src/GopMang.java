import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mang 1: ");
        int size = sc.nextInt();
        int[] arr1 = new int[size];
        for (int x =0;x < arr1.length;x++){
            arr1[x]= sc.nextInt();
        }
        System.out.println("nhap mang 2: ");
        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int y =0;y < arr2.length;y++){
            arr2[y]= sc.nextInt();
        }
        int[] arr3 = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }

        int count = 0;
        for (int j = arr1.length; j < arr3.length; j++) {
            arr3[j] = arr2[count];
            count++;
        }
        System.out.println(Arrays.toString(arr3));
    }
}
