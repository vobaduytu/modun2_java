public class InserionSorts {
    public static void inser(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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
        int[] arr = {1, 2, 3, 5, 8, 4, 0};
        inser(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
