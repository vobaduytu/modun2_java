
public class TryCatchDemo {
    public static void main(String[] args) {
        try {
            test();
            int x = 0;
            int data = 5 / x;
        } catch (Exception ex) {
            System.out.println("bat test");
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }
        System.out.println("Finished!");
    }

    public static void test() throws Exception {
        throw new Exception();
    }
}
 