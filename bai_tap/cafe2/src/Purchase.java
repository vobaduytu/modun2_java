import java.util.Scanner;

public class Purchase extends Promotion {
    public int muaHang = 1;
    public int khongMua = 2;

    public Purchase(double promotionRate, String startDay, String endDate) {
        super(promotionRate, startDay, endDate);
    }

    public static void main(String[] args) {
        Purchase purchase = new Purchase(10, "25/10/2020", "26/10/2020");
        Scanner scanner = new Scanner(System.in);
        System.out.println("quy khach mua hay khong mua");
        int mua = scanner.nextInt();
        if (mua == purchase.muaHang) {
            System.out.println("nhap ngay mua");
            String ngayMua = scanner.nextLine();
            if (ngayMua == purchase.startDay) {
                System.out.println("quý khách được khuyến mãi " + purchase.promotionRate);
            }
        }
    }
}
