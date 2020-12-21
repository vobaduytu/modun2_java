import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
        public int id;
        public String nameProduct;
        public String manufacturer;
        public int price;

    public Product(int id, String nameProduct, String manufacturer, int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +" - "+
                  id +" - "+
                nameProduct + " - "+
                 manufacturer  +" - "+
                 price +" "+
                '}';
    }
}
