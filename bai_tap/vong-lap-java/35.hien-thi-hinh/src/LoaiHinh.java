import java.util.Scanner;

public class LoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap kieu menu ban muon");
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                for (int i = 1; i <= 3;i++){
                    System.out.println("");
                     for ( int j = 1; j <=7;j++){
                         System.out.print("*");
                     }
                }
            case 2:
                for(int i = 1; i <= 5;i++){
                    System.out.println("");
                    for (int j = 1; j <= i; j++){
                        System.out.print("*");
                    }
                }
            case 3:
                for (int i = 1; i<= 5; i++){
                    System.out.println("");
                    for (int j = 5; j >= i;j--){
                        System.out.print("*");
                    }
                }
        }
    }
}
