import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        Scanner sc =new Scanner(System.in);
        System.out.println("nhap vao:");
        String test = sc.nextLine();
//        String test = "Tao la Dat dep trai va ngoc Ngech";
        // chuyen toan bo thanh chu hoa
        String format = test.toUpperCase();
        System.out.println(format);

        // duyet qua tung chu cai
        for (int i = 0; i < format.length(); i++) {
            // lay chu cai hien tai ra
            char thisChar = format.charAt(i);
            // gap khoang trong thi bo qua
            if (thisChar == ' ') continue;

            // lay ve: chu cai hien co trong map khong
            boolean isExist = !map.containsKey(thisChar);

            if (isExist) {
                // truong hop 1: chua co -> them chu cai vao map, voi so lan la 1
                map.put(thisChar, 1);
            } else {
                // truong hop 2: da xuat hien trong map
                // lay ve so lan xuat hien
                int times = map.get(thisChar);
                // chen chu cai do vo lai map voi so lan xuat hien tang len 1
                map.put(thisChar, times + 1);
            }
        }
        // lay ve 1 danh sach cac key trong map
        Set<Character> characters = map.keySet();

        // duyet qua tung phan tu trong danh sach
        for(Character thisChar : characters) {
            // get: lay so lan xuat hien -> in ra man hinh
            System.out.println(thisChar + ": " + map.get(thisChar));
        }
    }
}
