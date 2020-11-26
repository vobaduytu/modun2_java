public class Cricle {
    public double radius = 5;
    public String color = "blue";
    public double dienTich = radius*radius*Math.PI;


    public Cricle(){}

    public Cricle(double radius, String color, double dienTich) {
        this.radius = radius;
        this.color = color;
        this.dienTich = dienTich;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", dienTich=" + dienTich ;

    }
}
