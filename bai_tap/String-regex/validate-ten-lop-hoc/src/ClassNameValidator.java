import java.util.regex.Pattern;

public class ClassNameValidator {
    public static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";
    public static Pattern classNamePattern = Pattern.compile(CLASS_NAME_REGEX);

    public static final String[] validClassNames = {"C0318G", "P2356I"};
    public static final String[] invalidClassNames = {"M0318G", "P0323A"};

    public static void main(String[] args) {
        for (String className : validClassNames) {
            System.out.printf("%-8s: %b%n", className, isValidClassName(className));
        }

        for (String className : invalidClassNames) {
            System.out.printf("%-8s: %b%n", className, isValidClassName(className));
        }
    }

    public static boolean isValidClassName(String className) {
        return classNamePattern.matcher(className).matches();
    }
}