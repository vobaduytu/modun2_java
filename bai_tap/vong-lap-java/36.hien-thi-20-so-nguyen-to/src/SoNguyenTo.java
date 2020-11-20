public class SoNguyenTo {
    public static void main(String[] args) {
        System.out.println("20 so nguyen to dau tien");
        int n = 2;
        int count = 0;
        while (count < 20){
            if (isPrime(n)){
                System.out.println(n);
                count++;
            }n++;
        }

    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        int i = 2;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) return false;
            i++;
        }
        return true;
    }
}

