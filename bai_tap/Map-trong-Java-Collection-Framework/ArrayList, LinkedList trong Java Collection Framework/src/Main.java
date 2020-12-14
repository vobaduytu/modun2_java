import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("Chọn chức năng : [1- 8]");
            System.out.println("1: thêm sản phẩm ");
            System.out.println("2: Sửa thông tin sản phẩm theo id");
            System.out.println("3: xóa sản phẩm theo id");
            System.out.println("4: hiển thị danh sách sản phẩm");
            System.out.println("5: Sửa sản phẩm theo tên");
            System.out.println("6: tìm kiếm sản phẩm theo tên");
            System.out.println("7: sắp xếp sản phẩm  ");
            System.out.println("8: thoát");


            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("nhập id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nhập tên sản phẩm");
                    String name = scanner.nextLine();
                    System.out.println("nhập giá");
                    int price = Integer.parseInt(scanner.nextLine());
                    ProductController.add(id, name, price);
                    break;
                case 2:
                    ProductController.repair();
                    break;
                case 3:
                    ProductController.removeId();
                    break;
                case 4:
                    ProductController.show();

                    break;
                case 5:
                    ProductController.newName();

                    break;
                case 6:

                    ProductController.searchName();
                    break;
                case 7:
                    ProductController.sort();

                    break;
                case 8:
                    System.out.println("goodbye");
                    cont = false;
                    break;
                default:
                    System.out.println("nhap sai ");
                    cont = false;
                    break;
            }
        }
        while (cont);
    }
}