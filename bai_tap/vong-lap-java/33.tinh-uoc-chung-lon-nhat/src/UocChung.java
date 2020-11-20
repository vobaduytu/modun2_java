import java.util.Scanner;

public class UocChung {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a:");
        a = sc.nextInt();
        System.out.println("nhap b:");
        b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0||b==0){
            System.out.println("nonono");
        }
        while (a != b){
            if (a > b){
                a = a -b;
            } else {
                b = b - a;
            }

        }
        System.out.println("uoc chung lon nhat:" + a);
    }
}
