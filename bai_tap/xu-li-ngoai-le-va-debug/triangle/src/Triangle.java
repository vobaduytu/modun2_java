import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        System.out.println("nhap 3 canh tam giac");
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap canh a");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap canh b");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap canh c");
        int c = Integer.parseInt(scanner.nextLine());
        try {
            check(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void check(int a, int b, int c) throws IllegalTriangleException {
        if ((a + b <= c) ||( a + c <= b) ||( b + c <= a) || (a < 0) ||( b < 0) || (c < 0)) {
            throw new IllegalTriangleException("tam giac khong hop le");
        }
        System.out.println("tam giac hop le");
    }

}
