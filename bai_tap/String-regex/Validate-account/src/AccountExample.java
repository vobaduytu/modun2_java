import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUNT_REGEX = "^\\w{6,}$";
    Pattern pattern = Pattern.compile(ACCOUNT_REGEX);

    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public AccountExample() {

    }

    public boolean validate(String account) {
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }

    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        for (String account : validAccount) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isValid);
        }
        for (String account : invalidAccount) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isValid);
        }
    }
}