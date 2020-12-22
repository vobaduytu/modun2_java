import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("1: thêm sản phẩm");
            System.out.println("2: hiển thị sản phẩm ");
            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("nhập id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nhập tên sản phẩm ");
                    String name = scanner.nextLine();
                    System.out.println("nhập hãng sản xuất");
                    String mana = scanner.nextLine();
                    System.out.println("nhập giá");
                    int price = Integer.parseInt(scanner.nextLine());
                    ProductTest.add(id, name, mana, price);

                    break;
                case 2:
                    ProductTest.show();
                    break;

                default:
                    System.out.println("nhap sai ");
                    cont = false;
                    break;
            }
        }
        while (cont);
    }

    private static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();

    static{
        try {
            productList = (List<Product>) SaveFile.readProductToFile("product.data");
            if (productList == null){
                productList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int size = 0;

    public static void add(int id, String nameProduct, String manufacturer, int price) throws IOException {

        Product product = findById(id);
        if (product == null){
            productList.add(new Product(id, nameProduct, manufacturer, price));
        }
        else System.out.println("id không thể trùng");
        size++;
        saveProductToFile();
    }
    public static void show(){
        System.out.println(productList);
    }

    public static void saveProductToFile() throws IOException {
        SaveFile.writeProductToFile(productList, "product.data");
    }
    public static Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId())
                return product;
        }
        return null;
    }

}