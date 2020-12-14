import java.util.*;

public class ProductController {

    private static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();
    public static int size = 0;


    public static void add(int id, String name, int price) {
        Product products = findById(id);
       if (products != null){
           System.out.println("id da xuat hien");
       }else
            productList.add(new Product(id, name, price));
        size++;
    }

    public static void show() {
        System.out.println(productList);
    }

    public static Product findById(int id) {
        for (Product product : productList) {
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
        productList.remove(products);
    }

    public static void sort() {
        System.out.println("ban muon săp xep theo ten hay theo gia: ");

        System.out.println("1: theo gia");
        System.out.println("2: theo ten");

        int gia = Integer.parseInt(scanner.nextLine());

        if (gia == 1) {
            productList.sort(Comparator.comparingInt(Product::getPrice));
            System.out.println(productList);
        } else if
        (gia == 2) {
            Collections.sort(productList);

            System.out.println(productList);
        } else
            System.out.println("ban chon sai phuong thuc sap xep");

    }


    public static Product getProductByName(String name) {
        for (Product product : productList) {
            if (name.equals(product.getName()))
            return product;
        }
        return null;
    }

    public static void searchName() {
        System.out.println("nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        Product currentProduct = getProductByName(name);
        if (currentProduct == null)  {
            System.out.println("không tìm thấy tên");
            return;
        }
        System.out.println(currentProduct);
    }

    public static void newName() {
        System.out.println("nhập tên sản phẩm: ");
        String nameRepair = scanner.nextLine();
        Product productss = getProductByName(nameRepair);
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