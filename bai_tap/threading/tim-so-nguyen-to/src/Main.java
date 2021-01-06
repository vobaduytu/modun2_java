
public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimized = new OptimizedPrimeFactorization();
        Thread lazyThread = new Thread(lazy);
        Thread optimizedThread = new Thread(optimized);

        lazyThread.start();
        optimizedThread.start();
    }
}