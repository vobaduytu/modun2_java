public class BinarySearch {

    public static int binarySearch(int array[] , int x, int low , int high ){
        if (high>=low){
            int mid = (high + low )/2;
            if (array[mid] == x ){
                return mid;
            }
            else if (array[mid] > x){
                high = mid -1;
            }else if (array[mid] < x){
                low = mid+1;
            }
            return binarySearch(array,x,low,high);
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9};

        int low = 0;
        int high = array.length-1;
        System.out.println(BinarySearch.binarySearch(array,3,low,high));
    }
}
