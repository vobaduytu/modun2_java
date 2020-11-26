public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape("blue",true);
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}
