import java.util.Random;

public class Square implements Resizeable {
   public double radius;

    public Square(double radius) {
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
        return "Square{" +
                "radius=" + radius*resize() +
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
