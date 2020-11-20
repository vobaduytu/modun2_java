import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("nhap menu ban muon");
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                System.out.println("* * * * * ");
                System.out.println("* * * *  ");
                System.out.println("* * *  ");
                System.out.println("* *  ");
                System.out.println("* ");
            case 2:
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
            case 3:
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
                System.out.println("* * * * * * * * ");
            case 0:
                System.exit(0);
            default:
                System.out.println("no choose");
                
        }
    }
}
