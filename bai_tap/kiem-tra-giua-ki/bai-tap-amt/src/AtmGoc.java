public class AtmGoc {
    public int many = 1200000;
    public final String name = " Nguyen Van A";

    public AtmGoc(String name, int many) {
        this.many = many;
    }

    public int getMany() {
        return many;
    }

    public void setMany(int many) {
        this.many = many;
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
