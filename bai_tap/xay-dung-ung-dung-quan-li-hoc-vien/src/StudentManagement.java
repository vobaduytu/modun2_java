import java.io.IOException;
import java.util.*;

public class StudentManagement  {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("1: Xem danh sách học viên");
            System.out.println("2: Thêm học viên");
            System.out.println("3: Sửa thông tin học viên");
            System.out.println("4: Xóa học viên");
            System.out.println("5: Nhập điểm học viên ");
            System.out.println("6: Sửa điểm học viên");
            System.out.println("7: Xếp loại học viên");
            System.out.println("8: exit");
            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    StudentManagement.showStudent();
                    break;
                case 2:
                    System.out.println("nhập tên học viên: ");
                    String newName = scanner.nextLine();
                    System.out.println("nhập giới tính: ");
                    String newSex = scanner.nextLine();
                    System.out.println("nhập tuổi");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    StudentManagement.addStudent(newName, newSex, newAge);
                    break;
                case 3:
                    StudentManagement.InformationStudent();
                    break;
                case 4:
                    StudentManagement.RemoveStudent();
                    break;
                case 5:
                    StudentManagement.inputScore();
                    break;
                case 6:
                   StudentManagement.repairScore();
                 break;

                case 7:
                    StudentManagement.sort();
                    break;
                case 8:
                    System.out.println("tạm biệt......");
                    return;
                default:
                    System.err.println("nhap sai ");
                    cont = false;
                    break;
            }
        }
        while (cont);
    }

    private static Scanner scanner = new Scanner(System.in);
    public static List<Student> students = new ArrayList<>();
    public static int size = 0;

    static {
        try {
            students = (List<Student>) StudentFile.readProductToFile("product.data");
            if (students == null) {
                students = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showStudent() {
        for (Student student : students) {
            System.out.format("%20s | ", student.getName());
            System.out.format("%10s | ", student.getAge());
            System.out.format("%10s | ", student.getSex());
            System.out.format("%10s |", student.getPoint1());
            System.out.format("%10s |", student.getPoint2());
            System.out.format("%10s |", student.getPoint3());
            System.out.format("%10s |", student.getPoint4());
            System.out.format("%10s", student.getPointMedium());
            System.out.println("\n");
        }
    }


    public static void addStudent(String name, String sex, int age) throws IOException {
        students.add(new Student(name, sex, age));
        size++;
        saveProductToFile();
    }

    public static void saveProductToFile() throws IOException {
        StudentFile.writeProductToFile(students, "product.data");
    }

    public static Student getProductByName(String name) {
        for (Student student : students) {
            if (name.equals(student.getName()))
                return student;
        }
        return null;
    }

    public static void InformationStudent() {
        System.out.println("nhập tên học viên: ");
        String nameRepair = scanner.nextLine();
        Student student = getProductByName(nameRepair);
        if (student == null) {
            System.out.println("không tìm thấy tên");
            return;
        }
        System.out.println("nhập tên");
        String newName = scanner.nextLine();
        System.out.println("nhập giới tính");
        String newSex = scanner.nextLine();
        System.out.println("nhập tuổi");
        int newAge = Integer.parseInt(scanner.nextLine());
        student.setName(newName);
        student.setSex(newSex);
        student.setAge(newAge);
    }

    public static void RemoveStudent() throws IOException {
        System.out.println("nhập tên học viên: ");
        String nameRepair = scanner.nextLine();
        Student student = getProductByName(nameRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }
        students.remove(student);
        System.out.println("đối tượng bị loại bỏ");
        saveProductToFile();
    }

    public static void inputScore() throws IOException {
        System.out.println("nhập tên học viên muốn nhập điểm: ");
        String nameRepair = scanner.nextLine();
        Student student = getProductByName(nameRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }
        System.out.println("nhập ô điểm:");
        int point = Integer.parseInt(scanner.nextLine());
        if (point == 1) {
            if (student.getPoint1()==0){
                System.out.println("1: nhập điểm lần 1");
                int p1 = Integer.parseInt(scanner.nextLine());
                student.setPoint1(p1);
            }
          else System.out.println("điểm đã được nhập");
        }
        if (point == 2) {
            if (student.getPoint2()==0){
                System.out.println("2: nhập điểm lần 2");
                int p2 = Integer.parseInt(scanner.nextLine());
                student.setPoint2(p2);
            }
            else System.out.println("điểm đã được nhập");
        }
        if (point == 3) {
            if (student.getPoint3()==0){
                System.out.println("3: nhập điểm lần 3");
                int p3 = Integer.parseInt(scanner.nextLine());
                student.setPoint3(p3);
            }
            else System.out.println("điểm đã được nhập");
        }
        if (point == 4) {
            if (student.getPoint4() == 0){
                System.out.println("4: nhập điểm lần 4");
                int p4 = Integer.parseInt(scanner.nextLine());
                student.setPoint4(p4);
            }

            else System.out.println("điểm đã được nhập");
        }
        student.setPointMedium(student.getPointMedium());
        saveProductToFile();
    }
    public static void repairScore() throws IOException {
        System.out.println("nhập tên học viên muốn sửa điểm: ");
        String nameRepair = scanner.nextLine();
        Student student = getProductByName(nameRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }
        System.out.println("nhập ô điểm muốn sửa:");
        int point = Integer.parseInt(scanner.nextLine());
        if (point == 1) {
            if (student.getPoint1()>0){
                System.out.println("1: sửa ô điểm 1");
                int p1 = Integer.parseInt(scanner.nextLine());
                student.setPoint1(p1);
            }
            else System.out.println("điểm chưa được nhập");
        }
        if (point == 2) {
            if (student.getPoint2()>0){
                System.out.println("2: sửa ô điểm  2");
                int p2 = Integer.parseInt(scanner.nextLine());
                student.setPoint2(p2);
            }
            else System.out.println("điểm chưa được nhập");
        }
        if (point == 3) {
            if (student.getPoint3()>0){
                System.out.println("3: sửa ô điểm 3");
                int p3 = Integer.parseInt(scanner.nextLine());
                student.setPoint3(p3);
            }
            else System.out.println("điểm chưa được nhập");
        }
        if (point == 4) {
            if (student.getPoint4() >0){
                System.out.println("4:sửa ô điểm 4");
                int p4 = Integer.parseInt(scanner.nextLine());
                student.setPoint4(p4);
            }

            else System.out.println("điểm chưa được nhập");
        }
        student.setPointMedium(student.getPointMedium());
        saveProductToFile();
    }
public static void sort(){

    Collections.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getPointMedium() < o2.getPointMedium() ? 1 : -1;
        }

    });
}
}
