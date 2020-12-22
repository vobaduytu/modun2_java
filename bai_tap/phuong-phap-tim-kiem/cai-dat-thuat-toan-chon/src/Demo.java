public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,0};
        demo(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void demo(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            for (int i = 0; i < arr.length - k; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
