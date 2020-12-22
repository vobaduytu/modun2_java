public class Main {
    public static void main(String[] args) {
        int[] list = {1, 2,  4, 5, 6, 7, 8, 9, 10};
        int key = 3;
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                System.out.println(mid);
                break;
            } else
                low = mid + 1;
            if (high == low) {
                System.out.println(-1);

            }
        }
    }
}
