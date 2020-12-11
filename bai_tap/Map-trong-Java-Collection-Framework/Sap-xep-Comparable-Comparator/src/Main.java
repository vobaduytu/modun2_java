import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("Chọn chức năng : [1- 6]");
            System.out.println("1: thêm sản phẩm ");
            System.out.println("2: Sửa thông tin sản phẩm theo id");
            System.out.println("3: xóa sản phẩm theo id");
            System.out.println("4: hiển thị danh sách sản phẩm");
            System.out.println("5: tìm kiếm sản phẩm theo tên");
            System.out.println("6: sắp xếp sản phẩm  ");

            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("1: thêm sản phẩm ");
                    break;
                case 2:

                    System.out.println("2: Sửa thông tin sản phẩm theo id");
                    break;
                case 3:
                    System.out.println("3: xóa sản phẩm theo id");
                    break;
                case 4:
                    System.out.println("4: hiển thị danh sách sản phẩm");
                    break;
                case 5:
                    System.out.println("5: tìm kiếm sản phẩm theo tên");
                    break;
                case 6:

                    System.out.println("6: sắp xếp sản phẩm  ");
                    break;
                default:
                    System.out.println("Tạm biệt");
                    cont = false;
                    break;
            }
        } while (cont);
    }
}