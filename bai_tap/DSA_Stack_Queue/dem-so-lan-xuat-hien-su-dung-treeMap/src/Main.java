import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        System.out.println("nhap vao: ");
        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();

        String format = test.toUpperCase();
        System.out.println(format);

        for (int i = 0; i < format.length(); i++) {

            char ten = format.charAt(i);
            if (ten == ' ') {
                continue;
            }

            boolean layRa = !map.containsKey(ten);
            if (layRa) {
                map.put(ten, 1);
            } else {
                int times = map.get(ten);
                map.put(ten, times + 1);
            }
        }
        Set<Character> characters = map.keySet();

        for (Character ten: characters) {
            System.out.println(ten + " : " + map.get(ten));
        }
    }
}
