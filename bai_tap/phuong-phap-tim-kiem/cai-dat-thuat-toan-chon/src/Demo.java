public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 3,8,15,98};
        demo(arr);
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
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
