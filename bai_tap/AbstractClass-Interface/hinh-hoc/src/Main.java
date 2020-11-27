import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles = {new ComparableCircle(6,"red"),new ComparableCircle(3,"blue"),new ComparableCircle(5,"white")};

        System.out.println(Arrays.toString(circles));
        Arrays.sort(circles);
        System.out.println(Arrays.toString(circles));
    }
}
