import java.io.IOException;
import java.util.Scanner;

public class ChildFile {
    public static void main() throws IOException {

        Scanner scanner = new Scanner(System.in);
        try {
            boolean cont = true;
            do {
                System.out.println("a: Nếu ân menu này sẽ show toàn bộ các file và thư mục  ở thư mục C:\\Baitap\\");
                System.out.println("b: Search");
                System.out.println("c: New");
                System.out.println("d: Copy");
                System.out.println("e: Delete");
                System.out.println("f:Move");

                String chon = scanner.nextLine().toLowerCase();
                switch (chon) {
                    case "a":
                        break;
                    case "b":
                        break;
                    case "c":
                        break;
                    case "d":
                        break;
                    case "f":
                        break;
                    case "e":
                        break;
                    default:
                        System.out.println("bạn nhập sai chức năng");
                        break;
                }
            }
            while (cont);
        } catch (Exception e) {
            System.err.println("chọn lại:");
            main();
        }
    }
}
