


public class TryCatchDemo {
    public static void main(String[] args) {


        try {
            test();
            int data = 5 / 0;
//        } catch (ArithmeticException ex) {
//            System.out.println("ArithmeticException");
//            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("bat test");
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }
        System.out.println("Finished!");
    }

    public static void test2() {
        test();
    }


    public static void test() {
        throw new RuntimeException();
    }
}
 