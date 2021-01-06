public class OptimizedPrimeFactorization implements Runnable {

    @Override
    public void run() {
        for (int i = 10000; i < 12000; i++) {
            if (isPrime(i)) System.out.println("Optimized: " + i);
        }
    }

    private boolean isPrime(int num) {
        double limit = Math.sqrt(num);
        for (int i = 2; i < limit; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}