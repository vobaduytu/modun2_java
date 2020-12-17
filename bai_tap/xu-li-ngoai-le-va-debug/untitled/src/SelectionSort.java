import java.util.Arrays;

public class SelectionSort {
    public static void seclectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexMin] > arr[j]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5, 7,6, 1, 8,7, 4,9, 9, 10};
        seclectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
