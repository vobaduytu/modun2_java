public class Main {
    public static void main(String[] args) {
        ChuNhat chunhat = new ChuNhat(5,4);
        System.out.println("dien tich hinh chu nhat: " + chunhat.dienTich());
        System.out.println(" chu vi hinh chu nhat: " + chunhat.chuVi());
        chunhat.setHeight(8);
        chunhat.setWidth(100);
        System.out.println("dien tich hinh chu nhat: " + chunhat.dienTich());
        System.out.println(" chu vi hinh chu nhat: " + chunhat.chuVi());
    }
}
