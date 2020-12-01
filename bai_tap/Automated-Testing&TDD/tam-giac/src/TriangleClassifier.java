public class TriangleClassifier {
    public static final String NOT_A_TRIANGLE = "khong phai tam giac";
    public static final String A_TRIANGLE = "tam giac binh thuong";
    public static final String EQUILATERAL_TRIANGLE = "la tam giac đều";
    public static final String IS_AN_ISOSOCELES_TRIANGLE = "la tam giac can";

    public static String triangleTest(int a, int b, int c) {
        if (a == b && a == c) {
            return EQUILATERAL_TRIANGLE;
        }
        if (notTriangle(a, b, c)) {
            return NOT_A_TRIANGLE;
        }
        if (a == b || a==c||b==c ) {
            return IS_AN_ISOSOCELES_TRIANGLE;
        }
        return A_TRIANGLE;
    }

    private static boolean notTriangle(int a, int b, int c) {
        if (a > b + c || b > a + c || c > a + b) return true;

        return (a <= 0 || b <= 0 || c <= 0);
    }


}
