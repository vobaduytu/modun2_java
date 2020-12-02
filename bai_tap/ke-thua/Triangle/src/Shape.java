public class Shape {
    public double side1 = 1.0;
    public double side2 = 2.0;
    public double side3 = 3.0;

    public Shape() {
    }

    public Shape(double side1, double side2, double side3) {
        System.out.println("run");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    public double getArea() {
        double p = (side1 + side2 + side3) / 2;

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Tam giac " +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                " Area =" + getArea()
                + " getPerimeter" + getPerimeter()
                ;
    }

}
