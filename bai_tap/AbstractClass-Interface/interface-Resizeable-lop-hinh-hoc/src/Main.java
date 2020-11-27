public class Main{
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.toString());
        Rectangle rectangle = new Rectangle(10,15);
        System.out.println(rectangle.toString());
        Square square = new Square(10000);
        System.out.println(square.toString());
    }
}