import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public String sex;
    public int age;
    public double point1;
    public double point2;
    public double point3;
    public double point4;
    public boolean statusPont1 = false;
    public boolean statusPont2 = false;
    public boolean statusPont3 = false;
    public boolean statusPont4 = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double pointMedium;

    public Student(int id,String name, String sex, int age) {
        this.id=id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(double point1, double point2, double point3, double point4, double pointMedium) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.pointMedium = pointMedium;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint1() {
        return point1;
    }

    public void setPoint1(double point1) {
        this.point1 = point1;
    }

    public double getPoint2() {
        return point2;
    }

    public void setPoint2(double point2) {
        this.point2 = point2;
    }

    public double getPoint3() {
        return point3;
    }

    public void setPoint3(double point3) {
        this.point3 = point3;
    }

    public double getPoint4() {
        return point4;
    }

    public void setPoint4(double point4) {
        this.point4 = point4;
    }

    public double getPointMedium() {
        return (point1 + point2 + point3 + point4) / 4;
    }

    public void setPointMedium(double pointMedium) {
        this.pointMedium = pointMedium;
    }

    @Override
    public String toString() {
        return

                " name =" + name +
                        " sex =" + sex +
                        " age =" + age +
                        " point1 =" + point1 +
                        " point2 =" + point2 +
                        " point3 =" + point3 +
                        " point4 =" + point4 +
                        " pointMedium =" + pointMedium + "\n"
                ;
    }


}