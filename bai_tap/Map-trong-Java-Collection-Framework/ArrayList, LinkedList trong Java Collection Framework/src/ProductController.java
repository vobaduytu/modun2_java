import java.util.*;

public class ProductController {

    private static Scanner scanner = new Scanner(System.in);
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

    public static void removeId() {
        System.out.println("nhập id");
        int idRemove = Integer.parseInt(scanner.nextLine());
        Product products = findById(idRemove);
        if (products == null) {
            System.out.println("khong tim thay san pham");
            return;
        }
        array.remove(products);
    }

    public static void sort() {
        System.out.println("ban muon săp xep theo ten hay theo gia: ");

        System.out.println("1: theo gia");
        System.out.println("2: theo ten");

        int gia = Integer.parseInt(scanner.nextLine());

        if (gia == 1) {
            Collections.sort(array);
            System.out.println(array);
            return;
        } else if
        (gia == 2) {
            Collections.sort(array, Comparator.comparingInt(Product::getPrice));
            System.out.println(array);
            return;
        } else
            System.out.println("ban chon sai phuong thuc sap xep");

    }


    public static Product name(String name) {
        for (Product product : array) {
            if (name == product.getName()) ;
//            System.out.println(product);
            return product;
        }
        return null;
    }

    public static void seachName() {
        System.out.println("nhập tên sản phẩm: ");
        String nameRepair = scanner.nextLine();
        Product productss = name(nameRepair);
        if (productss == null) {
            System.out.println("không tìm thấy tên");
            return;
        }
        System.out.println(productss);
    }

    public static void newName() {
        System.out.println("nhập tên sản phẩm: ");
        String nameRepair = scanner.nextLine();
        Product productss = name(nameRepair);
        if (productss == null) {
            System.out.println("không tìm thấy tên");
            return;
        }
        System.out.println("nhập tên mới");
        String newName = scanner.nextLine();
        System.out.println("nhập giá mới");
        int newPrice = Integer.parseInt(scanner.nextLine());
        productss.setName(newName);
        productss.setPrice(newPrice);
    }


    public static void repair() {
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