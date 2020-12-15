public class BinarySearch {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int hight = arr.length - 1;
        while (hight >= low) {
            int mid = (low + hight) / 2;
            if (key < arr[mid]) {
                hight = mid - 1;
            } else if (key == arr[mid]) {
                return mid;
            } else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arr, 10));
    }

}
