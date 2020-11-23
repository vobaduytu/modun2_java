public class Min {
    public static void main(String[] args) {
        int[] number={1,5,8,3,6,7,0,4};
        System.out.println("gia tri nho nhat: ");
        int min = number[0];
        for (int i = 0; i< number.length;i++){
            if (number[i] < min){
                min = number[i];
            }
        }
        System.out.println(min);
    }
}
