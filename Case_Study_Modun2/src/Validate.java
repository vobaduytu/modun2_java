
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static {
        formatter.setLenient(false);

    }

    private static final Scanner scanner = new Scanner(System.in);
    static Pattern namePattern = Pattern.compile("^[\\pL\\pZ]{0,40}$");

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
        System.out.println("ngày/tháng/năm");
        while (true) {
            try {
                String date = scanner.nextLine();
                checkYear(date);
                formatter.parse(date);
                return date;
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le: " + e.getMessage());
            }
        }
    }

    private static void checkYear(String date) throws Exception {
        String[] a = date.split("/");
        int year = Integer.parseInt(a[2]);
        if (year <= 1930 || year >= 2021)
            throw new Exception("nam sinh khong hop le");
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
        System.out.println("5: quay lại");
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

    //    id
    public static int validateID(String meesage) {
        System.out.println(meesage);
        try {

            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(" phải là một số");
            return validateID(meesage);
        }

    }

    //    lựa chọn
    public static int validateChon(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 4 || num < 0) {
                System.out.println("lựa chọn phải trong khoảng giới hạn đưa ra");
                return validateChon(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println(" phải là một số");
            return validateChon(meesage);
        }

    }
 // lựa chọn menu
    public static int validateChonMenu(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 2 || num < 0) {
                System.out.println("lựa chọn phải trong khoảng giới hạn đưa ra");
                return validateChon(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println(" phải là một số");
            return validateChon(meesage);
        }


}
// lựa chọ id
    public static int validateChonID(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 3 || num < 0) {
                System.out.println("lựa chọn phải trong khoảng giới hạn đưa ra");
                return validateChon(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println(" phải là một số");
            return validateChon(meesage);
        }}
}
