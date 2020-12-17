import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 9, 2, 20, 21};

        System.out.println("firt array: " + Arrays.toString(arr));
        checkInsertSort(arr);
        System.out.println("Last array: " + Arrays.toString(arr));
    }

    public static void checkInsertSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {   // i = 1
            int key = arr[i];              // key = 3
            int j = i - 1;                  // j = 0
            while (j >= 0 && arr[j] > key) {
               arr[j+1] = arr[j];
               j = j -1;
            }
            arr[j+1] = key;
        }
    }
}
