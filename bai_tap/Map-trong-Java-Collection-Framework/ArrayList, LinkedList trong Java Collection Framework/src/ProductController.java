import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {

    public final static List<Product> array = new ArrayList();
    public static int size = 0;


    public static void add(int id, String name, int price) {
        array.add(new Product(id, name, price));
        size++;
    }

    public static void show() {
        System.out.println(array);
    }

    public static Product findById(int id) {
        for (Product product : array) {
            if (id == product.getId())
                return product;
        }
        return null;
    }
    public static Product name(String name){
        for (Product product : array){
            if (name == product.getName());
//            System.out.println(product);
            return product;
        }
        return null;
    }

    public static void repair() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        int idRepair = Integer.parseInt(scanner.nextLine());
        Product products = findById(idRepair);
        if (products == null) {
            System.out.println("khong tim thay san pham");
            return;
        }

        System.out.println("nhập tên mới");
        String newName = scanner.nextLine();
        System.out.println("nhập giá mới");
        int newPrice = Integer.parseInt(scanner.nextLine());

        products.setName(newName);

        products.setPrice(newPrice);
    }

}