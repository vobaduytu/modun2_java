import java.util.Scanner;

public class ChuyenDoi {
    public static double celsiusToFahrenheit(double celsius) {
        double F = (9.0 / 5) * celsius + 32;
        return F;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double C = (5.0 / 9) * (fahrenheit - 32);
        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double F;
        double C;
        int choice;
        do {
            System.out.println("menu");
            System.out.println("1.F to C");
            System.out.println("2.C to F");
            System.out.println("0.exit");
            System.out.println("enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter F");
                    F = sc.nextDouble();
                    System.out.println("F to C:" + fahrenheitToCelsius(F));
                    break;
                case 2:
                    System.out.println("enter C");
                    C = sc.nextDouble();
                    System.out.println("C to F:" + celsiusToFahrenheit(C));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);


    }
}
