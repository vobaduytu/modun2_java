public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 7, 4, 6, 10, 58, 94, 56, 32};
        insertSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
