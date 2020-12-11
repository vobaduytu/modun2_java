import java.util.*;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge()>o2.getAge()) return 1;
        if (o1.getAge()==o2.getAge()) return 2;
        return -1;
    }

    public static void main(String[] args) {
        Student student = new Student("nam",25,"hue");
        Student student1 = new Student("hung",24,"hue");
        Student student2 = new Student("dat",23,"hue");
        Student student3 = new Student("linh",29,"hue");

        List <Student> lol = new ArrayList<>();
        lol.add(student1);
        lol.add(student);
        lol.add(student2);
        lol.add(student3);
        Collections.sort(lol);

        for (Student so : lol){
            System.out.println(so.toString());
        }
    AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lol,ageComparator);
        System.out.println("so sanh theo tuoi: ");
        for (Student so : lol){
            System.out.println(so.toString());
        }
    }
}