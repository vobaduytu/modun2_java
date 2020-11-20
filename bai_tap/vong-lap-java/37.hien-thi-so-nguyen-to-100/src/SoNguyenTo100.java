public class SoNguyenTo100 {
    public static void main(String[] args) {
        System.out.println("cac so nguyen to nho hon 100");
        int n = 2;
        while (n < 100){
            if(isPrime(n)){
                System.out.println(n);

            }   n++;
        }
    }


    public static boolean isPrime(int num){
        if (num < 2 ) return false;
        int i = 2;
        while (i <= Math.sqrt(num)){
            if (num % i ==0) return false;
            i++;
        }return true;
    }
}
