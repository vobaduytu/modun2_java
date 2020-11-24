import java.util.Arrays;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mang cua ban");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i =0;i < arr.length;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("nhap vi tri muon chen");
        int vt = sc.nextInt();
        System.out.println("nhap gia tri muon chen");
        int giaTri = sc.nextInt();
        for (int i = arr.length-1; i > vt;i--){
           arr[i]=arr[i-1];
        }
        arr[vt]=giaTri;
        System.out.println(Arrays.toString(arr));
    }
}
