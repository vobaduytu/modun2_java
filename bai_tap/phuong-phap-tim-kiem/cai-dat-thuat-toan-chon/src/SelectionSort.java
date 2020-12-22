public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int numberMin = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (numberMin > array[j]) {
                    numberMin = array[j];
                    index = j;
                }
            }
            if (index != i) {
                array[index] = array[i];
                array[i] = numberMin;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {0, 5, 9, 8, 7, 6, 3, 1, 5, 4, 2, 3, 6, 9};
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
