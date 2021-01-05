import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static {
        formatter.setLenient(false);
    }

    private static final Scanner scanner = new Scanner(System.in);
    static Pattern namePattern = Pattern.compile("^[a-zA-Z ]{1,40}$");
//hiển thị tên
static String validateName(String mess) {
    System.out.println(mess);
    try {
        String name = scanner.nextLine().trim().replaceAll("\\s+", " ");
        if (!namePattern.matcher(name).matches())
            throw new Exception("invalid name");
        String[] word = name.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : word) {
            result.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
        }

        return result.toString().trim();

    } catch (Exception e) {
        System.err.println("Trong tên phải là kí tự chữ và không quá dài");
        return validateName(mess);
    }
}
    // xóa khoảng trống giới tính
    public static String removeWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }
    // ngày sinh
    public static String age(String meseage) {
        System.out.println(meseage);
        try {
            String date = scanner.nextLine();

            formatter.parse(date);
            return date;
        } catch (Exception e) {
            System.out.println("sai ngày sinh");
            return age(meseage);
        }
    }
    // xóa khoảng trống giới tính
    public static String deleteWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }
//    chọn ô điểm

    public static int choie(String me) {
        System.out.println(me);
        System.out.println("1: nhập điểm hệ số 1.1");
        System.out.println("2: nhập điểm hệ số 1.2");
        System.out.println("3: nhập điểm hệ số 2");
        System.out.println("4: nhập điểm hệ số 3");
        System.out.println("5: về menu");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 5 || num < 1) {
                System.out.println("điểm phải trong khoảng 0 --> 5");
                return point(me);
            }
            return num;
        } catch (Exception e) {
            System.out.println("ô điểm là một số");
            return choie(me);
        }
    }
//     điểm
    public static int point(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 10 || num < 0) {
                System.out.println("điểm phải trong khoảng 0 --> 10");
                return point(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println("phải là một số");
            return point(meesage);
        }
    }
}
