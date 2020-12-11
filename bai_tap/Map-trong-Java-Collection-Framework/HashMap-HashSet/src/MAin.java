import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MAin {
    public static void main(String[] args) {
        Student student3 = new Student("hung", 100, "vlxx");
        Student student1 = new Student("nam", 200, "xnxx");
        Student student2 = new Student("linh", 10, "jav");


        Map<Integer ,Student> map = new HashMap<>();
        map.put(1,student3);
        map.put(1001,student1);
        map.put(20146356,student2);

     for (Map.Entry<Integer,Student> lol : map.entrySet() ){
         System.out.println(lol.toString());
     }
        System.out.println("------------------------");
        Set<Student> map1 = new HashSet<>();
        map1.add(student1);
        map1.add(student2);
        map1.add(student3);
        map1.add(student1);

        for (Student student : map1){
            System.out.println(student.toString());
        }
    }
}
