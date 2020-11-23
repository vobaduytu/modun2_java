import java.util.Arrays;
import java.util.Scanner;

public class Remote {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 6, 7, 6, 9};
        System.out.println("nhap so muon xoa: ");
        Scanner sc = new Scanner(System.in);
        int so = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {

            while (arr[i] == so) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
