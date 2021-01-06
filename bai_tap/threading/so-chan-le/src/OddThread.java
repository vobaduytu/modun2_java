public class OddThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 10; i+=2) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
