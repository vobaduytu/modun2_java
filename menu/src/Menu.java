import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("1: thêm sản phẩm");
            System.out.println("2: hiển thị sản phẩm ");
            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    break;
                case 2:
                default:
                    System.out.println("nhap sai ");
                    cont = false;
                    break;
            }
        }
        while (cont);
    }
}
