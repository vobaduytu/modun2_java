public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
       shape = new Shape(5,6,7);
        System.out.println(shape);


        shape.getPerimeter();
    }
}