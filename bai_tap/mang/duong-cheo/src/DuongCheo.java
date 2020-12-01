public class DuongCheo {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 55},
                {4, 5, 6, 44},
                {7, 8, 100, 555},
                {1, 2, 3, 4}
        };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i][i];
        }
        System.out.println("tong duong cheo chinh: " + sum);
    }
}
