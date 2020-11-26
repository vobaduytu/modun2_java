import java.util.Arrays;

public class Point2 {
    public float x = 0.0f;
    public float y = 0.0f;

    public Point2(){}

    public Point2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y ){
        this.x=x;
        this.y=y;
    }

    public float[] getXY() {
        float[] result = {x, y};
        return result;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
