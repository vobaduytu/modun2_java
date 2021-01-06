public class TestThread {
    public static void main(String[] args) {
        OddThread odd = new OddThread();
        EvenThread even = new EvenThread();
        Thread oddThread = new Thread(odd);
        Thread evenThread = new Thread(even);

        try {
            oddThread.start();
            oddThread.join();
            evenThread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}