public class BinarySearch {

  public static int binarySeach(int array[], int x, int low, int higt){
      if (higt >= low){
          int mid = (higt + low)/2;
          if (   x < array[mid]){
              higt = mid-1;
          }
          else if (x == array[mid]){
              return mid;
          }else if (x > array[mid]){
              low = mid -1;
          }
      }
      return binarySeach(array,x,low,higt);
  }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int low = 0;
        int high = array.length-1;

        System.out.println(BinarySearch.binarySeach(array,5,low,high));
    }
}
