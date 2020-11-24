import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4}
                {4, 5, 6, 5}
        };

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[i][j];
            }
            System.out.println(sum);
        }
        int index = 0;
        int sum = 0;
        for (int i = 0; i < arr.length;i++){
            for (int j = 0;j<arr.length;j++){
                sum += arr[i][j] 
            }
        }

    }
}
