import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(10),new Square(10),new Rectangle(10,15)};
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
