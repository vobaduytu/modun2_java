import java.util.Scanner;

public class Triangle extends Shape {
    public String color;

    public Triangle(){}

    public Triangle(String color) {
        this.color = color;
    }

    public Triangle(double side1, double side2, double side3, String color) {
        super(side1, side2, side3);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return
                " color='" + color + '\'' +
                " arae="+ getArea()+
                " 1="+ side1+
                " 2="+ side2+
                " 3="+ side3+
                " Perimeter= "+ getPerimeter()
                ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mau ban muon");
          String color = sc.nextLine();
        System.out.println("nhap canh 1");
          int side1 = sc.nextInt();
        System.out.println("nhap canh 2");
        int side2 = sc.nextInt();
        System.out.println("nhap canh 3");

        int side3 = sc.nextInt();

        Triangle triangle = new Triangle(side1, side2, side3, color);
        System.out.println(triangle);

    }
}
