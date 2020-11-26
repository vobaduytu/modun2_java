public class Cylinder extends Cricle{
    public double chieuCao;
    public double theTich;
    public double dienTich;


    public Cylinder(double chieuCao) {
        this.chieuCao = chieuCao;
        dienTich= 2 * Math.PI*radius*chieuCao;
        theTich = dienTich*chieuCao;
    }

    public double getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
    }

    @Override
    public String toString() {
        return  " dien tich =" + dienTich+
                " radius ="+ radius+
                " chieuCao=" + chieuCao +
                ", theTich=" + theTich ;

    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5);
         Cricle cricle = new Cricle();
        System.out.println(   " hinh tron: " + cricle);
        System.out.println("hinh tru: "+cylinder);
    }
}
