public class FizzBuzz {
    public static final String AAAA = "so nguyen lon hon 0";
    public static final String Fizz = " chia het cho 3";
    public static final String Buzz = " chia het cho 5";
    public static final String FizzBuzz = " chia het cho 3 va 5";

    public static String[] arr = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};

    public static String checkOut(int number) {


        if (number % 3 == 0 && number % 5 != 0) {
            return Fizz;
        }
        if (number % 5 == 0 && number % 3 != 0) {
            return Buzz;
        }


        if (number % 3 == 0 && number % 5 == 0) {
            return FizzBuzz;
        }

        return AAAA;
    }

    public static String Write(int number) {
        int firstDigit = number / 10;
        int secondDigit = number % 10;
        if (firstDigit == 1 && secondDigit == 0) {
            return "mười";
        }


        return arr[firstDigit] + " " + (secondDigit == 0 ? "mươi" : arr[secondDigit]);
    }

}
