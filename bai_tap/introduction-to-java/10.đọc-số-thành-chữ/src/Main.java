import java.util.Scanner;

public class Main {
    private static final String[] NORMAL_DIGIT = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] SPECIAL_DIGIT = new String[]{"", "one", "twen", "thir", "four", "fif", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        String result;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter integer from 0 to 999:");
            int num = scanner.nextInt();
            if (num < 0 || num > 999) throw new Exception();

            result = readNumberLessThan1000(num);
        } catch (Exception ignored) {
            result = "Number invalid!";
        }
        System.out.println("Result: " + result);
    }

    public static String readNormalDigit(int onesDigit) {
        return NORMAL_DIGIT[onesDigit];
    }

    ;

    public static String readSpecialDigit(int digit) {
        return SPECIAL_DIGIT[digit];
    }

    ;

    public static String readNumberLessThan1000(int num) {
        return (num < 99) ? readNumberLessThan100(num) : readThreeDigitNumbers(num);
    }

    public static String readNumberLessThan100(int num) {
        return (num < 10) ? readNormalDigit(num) : readTwoDigitNumbers(num);
    }

    public static String readTwoDigitNumbers(int num) {
        return (num < 20) ? readTwoDigitNumberLessThan20(num) : readTwoDigitNumberGreaterOrEqual20(num);
    }

    public static String readTwoDigitNumberLessThan20(int num) {
        switch (num) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            default:
                int onesDigit = num % 10;
                return readSpecialDigit(onesDigit) + "teen";
        }
    }

    public static String readTwoDigitNumberGreaterOrEqual20(int num) {
        int tensDigit = num / 10;
        int onesDigit = num % 10;

        return readSpecialDigit(tensDigit) + "ty" + (onesDigit == 0 ? "" : " " + readNormalDigit(onesDigit));
    }


    public static String readThreeDigitNumbers(int num) {
        int hundredsDigit = num / 100;
        int twoDigitNumber = num % 100;

        return readNormalDigit(hundredsDigit) + " hundred" + (twoDigitNumber == 0 ? "" : " and " + readNumberLessThan100(twoDigitNumber));
    }

}