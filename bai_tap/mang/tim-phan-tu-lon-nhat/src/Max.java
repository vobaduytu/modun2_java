public class Max {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 56, 7}, {87, 9, 0, 54, 100}
        };
        int max = arr[0][0];
        for (int i = 0; i < arr.length;i++){
            for (int j = i; j < arr[i].length; j++){
                if (arr[i][j]> max){
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
