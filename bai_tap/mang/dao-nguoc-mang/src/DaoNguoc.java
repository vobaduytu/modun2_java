public class DaoNguoc {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        for(int i = 0; i < arr.length/2;i++){
            int temp = arr[i];
            int temp2 = arr[arr.length - i -1];
            arr[i] = temp2;
            arr[arr.length -i -1]=temp;
        }
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for (int a : arr){
            System.out.println(a);
        }
    }
}
