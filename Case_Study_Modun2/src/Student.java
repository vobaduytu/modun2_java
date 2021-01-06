import java.io.Serial;
import java.io.Serializable;


public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public String sex;
    public String birthday;
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

    public Student(int id,String name, String sex, String birthday) {
        this.id=id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
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

    public String getAge() {
        return birthday;
    }

    public void setAge(String age) {
        this.birthday = age;
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
        int count = 0;
        double total = 0;
        if(statusPont1){
            total += this.getPoint1();
            count += 1;
        }
        if(statusPont2){
            total += this.getPoint2();
            count += 1;
        }
        if(statusPont3){
            total += this.getPoint3() *2;
            count += 2;
        }
        if(statusPont4){
            total += this.getPoint4() * 3;
            count += 3;
        }
        return  total / count;

    }

    public void setPointMedium(double pointMedium) {
        this.pointMedium = pointMedium;
    }

    @Override
    public String toString() {
        return

                " name =" + name +
                        " sex =" + sex +
                        " birthday =" + birthday +
                        " point1 =" + point1 +
                        " point2 =" + point2 +
                        " point3 =" + point3 +
                        " point4 =" + point4 +
                        " pointMedium =" + pointMedium + "\n"
                ;
    }}


