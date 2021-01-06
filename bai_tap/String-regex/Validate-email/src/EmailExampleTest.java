public class EmailExampleTest {
    private static final EmailExample emailExample = new EmailExample();
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        for (String email : validEmail) {
            testEmail(email);
        }
        for (String email : invalidEmail) {
            testEmail(email);
        }
    }

    private static void testEmail(String email) {
        System.out.println("Email is " + email + " is valid: " + emailExample.validate(email));
    }
}