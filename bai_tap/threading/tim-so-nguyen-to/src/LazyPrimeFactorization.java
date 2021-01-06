public class LazyPrimeFactorization implements Runnable {

    @Override
    public void run() {
        for (int i = 10000; i < 12000; i++) {
            if (isPrime(i)) System.out.println("Lazy: " + i);
        }
    }


    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}