public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.floor((Math.random() * 100000) + 1));
        }


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sortAscending(arr);
        stopWatch.stop();

        System.out.println(stopWatch.getElapsedTime());
    }

    public static void sortAscending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentMin = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < currentMin) {
                    currentMin = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                array[minIndex] = array[i];
                array[i] = currentMin;
            }
        }
    }
}
