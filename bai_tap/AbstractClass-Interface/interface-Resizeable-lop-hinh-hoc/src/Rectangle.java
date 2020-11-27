import java.util.Random;

public class Rectangle implements Resizeable{
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width*resize() +
                ", height=" + height*resize() +
                " dienTich="+ width*resize()*height*resize()+
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
