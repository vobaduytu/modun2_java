public class ChuNhat {
    double height;
    double width;

    public ChuNhat() {

    }

    public ChuNhat(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double dienTich() {
        return this.height * this.width;
    }

    public double chuVi() {
        return (this.width + this.height) * 2;
    }


}
