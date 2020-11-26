public class Point3 extends Point2 {
    public float z = 0.0f;
    public Point3(){}

    public Point3(float z) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
       this.z=z;
       this.x=x;
       this.y=y;
    }
    public float[] getXYZ(){
        float[] arr = {x,y,z};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3{" +
                " z= " + z +
                " x= "+x+
                " y= "+y+
                '}';
    }

    public static void main(String[] args) {
        Point3 point3 = new Point3();
        System.out.println(point3);
    }
}
