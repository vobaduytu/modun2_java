import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static final String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public static final Pattern phoneNumberPattern = Pattern.compile(PHONE_NUMBER_REGEX);
    public static final String[] valid = {"(84)-(0978489648)", "(23)-(0123456789)"};
    public static final String[] invalid = {"(84)-(1978489648)", "(a2)-(0123456789)", "(12)-(01234567)"};

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumberPattern.matcher(phoneNumber).matches();
    }

    public static void main(String[] args) {
        for (String number : valid) {
            System.out.printf("%-20s: %s%n", number, isPhoneNumberValid(number) ? "valid" : "invalid");
        }

        for (String number : invalid) {
            System.out.printf("%-20s: %s%n", number, isPhoneNumberValid(number) ? "valid" : "invalid");
        }
    }
}