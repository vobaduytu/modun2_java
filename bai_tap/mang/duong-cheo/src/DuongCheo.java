public class DuongCheo {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 100}
        };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i][i];
        }
        System.out.println("tong duong cheo chinh: " + sum);
    }
}
