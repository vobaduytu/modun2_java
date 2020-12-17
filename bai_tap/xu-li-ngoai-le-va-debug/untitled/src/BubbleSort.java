import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array){
         boolean a = true;
        for (int k = 1; k < array.length && a ; k++) {
            a = false;
            for (int i = 0; i < array.length-k; i++) {
                      if (array[i] > array[i+1]){
                          int temp = array[i];
                          array[i] = array[i +1];
                          array[i+1] = temp;
                          a= true;
                      }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
