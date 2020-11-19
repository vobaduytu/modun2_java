import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter width:");
        width = scanner.nextFloat();
        System.out.println("enter height:");
        height = scanner.nextFloat();
        float are = width * height;
        System.out.println("are is:" + are);
    }
}
