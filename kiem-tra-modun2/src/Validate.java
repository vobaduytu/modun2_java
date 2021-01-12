import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static {
        formatter.setLenient(false);

    }
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{10}$");
    public static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> phoneNumberList=new ArrayList<>();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+@\\w+\\.\\w+$");


    public static String validateTel(String mess) {
        System.out.println(mess);
        System.out.println("sdt: xxxxxxxxxx (10 chữ số)");
        try {
            String tel = scanner.nextLine();
            if (PHONE_NUMBER_PATTERN.matcher(tel).matches()) {
                return tel;

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Số điện thoại sai định dạng");
            return validateTel(mess);
        }
    }


    static Pattern namePattern = Pattern.compile("^[\\pL\\pZ]{0,40}$");


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
            System.err.println("Sai tên");
            return validateName(mess);
        }
    }

    public static String removeWriteSex(String name) {
        System.out.println(name);

        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }

   public static String validateEmail(String mess) {
        System.out.println(mess);
        try {
            String email = scanner.nextLine();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Email sai định dạng");
            return validateEmail(mess);

    }
    }

    //    lựa chọn
    public static int validateChon(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 8 || num < 0) {
                System.out.println("lựa chọn phải trong khoảng giới hạn đưa ra");
                return validateChon(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println(" phải là một số");
            return validateChon(meesage);
        }

    }
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

}
