public class AtmGoc {
    private static int many = 1200000;

    public final String name = " Nguyen Van A";

    public AtmGoc(String name, int many) {
        this.many = many;
    }

    public static int getMany() {
        return many;
    }

    public static int setMany(int many) {
        AtmGoc.many = many;
        return many;
    }

    public void napMoney(int amount) {
        if (amount > 0) {
            this.many += amount;
        } else {
            System.out.println("So tien khong duoc nho hon 0");
        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "số dư=" + many +
                ", tên ='" + name + '\''
                ;
    }

}
