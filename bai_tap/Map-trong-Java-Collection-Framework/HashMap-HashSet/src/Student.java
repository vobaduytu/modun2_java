public class Student {
   private String name;
   private int age;
   private String điaChi;

   public Student(){};

    public Student(String name, int age, String điaChi) {
        this.name = name;
        this.age = age;
        this.điaChi = điaChi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getĐiaChi() {
        return điaChi;
    }

    public void setĐiaChi(String điaChi) {
        this.điaChi = điaChi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", điaChi='" + điaChi + '\'' +
                '}';
    }
}