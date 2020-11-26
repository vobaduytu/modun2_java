public class MoveablePoint extends Point{
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;


    public MoveablePoint(float xSpeed, float ySpeed,float x, float y) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.x = x;
        this.y = y;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(){}

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float ySpeed,float xSpeed) {
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
    }
    public float[] getSpeed() {
        float[] arr = { xSpeed,ySpeed};
        return arr;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x= " + x +
                ", y=" + y +
                " speed "+ xSpeed + " and " + ySpeed+
                '}';
    }
   public MoveablePoint move(){
        x += xSpeed;
        y += ySpeed;
        return this;
   }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
