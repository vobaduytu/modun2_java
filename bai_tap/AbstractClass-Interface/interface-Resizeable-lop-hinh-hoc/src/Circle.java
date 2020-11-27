import java.util.Random;

public class Circle implements Resizeable{
      public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + this.radius*resize() +
                '}';
    }

    @Override
    public double resize() {
        Random random = new Random();
//        double[] arr={resize(Math.)}  ;
//        System.out.println(random.nextDouble());
        return random.nextDouble()*100;
    }



}
