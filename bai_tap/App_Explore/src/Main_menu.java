import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main_menu {
    public static void main() throws IOException {
        Scanner input = new Scanner(System.in);
        try {
            boolean cont = true;
            do {
                System.out.println("a: File  Close");
                System.out.println("b: Xếp hàng ngang");
                System.out.println("c: Nếu người dùng bấm phím tương ứng F, C thì chạy hệ thống menu con tương ứng \n");

                String chon = input.nextLine().toLowerCase();
                switch (chon) {
                    case "b":
                        break;
                    case "f":
                        break;
                    case "c":
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
