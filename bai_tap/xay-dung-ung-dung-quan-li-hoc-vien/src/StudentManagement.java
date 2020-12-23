import java.io.IOException;
import java.util.*;

public class StudentManagement {


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

                    String newName = deleteWrite("nhập tên học viên");

                    System.out.println("nhập giới tính: ");
                    System.out.println("Nam/Nu");

                    String newSex = scanner.nextLine();
                    while (newSex != null) {
                        if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                            break;
                        System.out.println("bạn nhập sai giới tính:");
                        System.out.println("nhập lại:");
                        newSex = scanner.nextLine();
                    }

                    int newAge = age("nhập tuổi");

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
                    System.out.println("theo thứ tự tăng dần");
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
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int size = 0;
    private static int id = 0;

    static {
        try {
            Object studentFile = StudentFile.readProductToFile("student.data");
            if (studentFile == null) {
                studentList = new ArrayList<>();
            } else {
                studentList = (ArrayList<Student>) studentFile;
            }
            int maxId = 0;
            for (Student student : studentList) {
                int currentId = student.getId();
                if (currentId > maxId)
                    maxId = currentId;
            }
            id = maxId;
        } catch (IOException | ClassNotFoundException e) {
            studentList = new ArrayList<>();
            id = 0;
        }
    }

    public static void showStudent() {
        System.out.format("%-3s | ", "Id");
        System.out.format("%-25s | ", "tên");
        System.out.format("%-10s | ", "tuổi");
        System.out.format("%-10s | ", "giới tính");
        System.out.format("%-10s |", "điểm 1");
        System.out.format("%-10s |", "điểm 2");
        System.out.format("%-10s |", "điểm 3");
        System.out.format("%-10s |", "điểm 4");
        System.out.format("%-10s |", "điểm 5");
        System.out.println("\n");
        for (Student student : studentList) {
            System.out.format("%-3s | ", student.getId());
            System.out.format("%-25s | ", student.getName());
            System.out.format("%-10s | ", student.getAge());
            System.out.format("%-10s | ", student.getSex());
            System.out.format("%-10s |", student.getPoint1());
            System.out.format("%-10s |", student.getPoint2());
            System.out.format("%-10s |", student.getPoint3());
            System.out.format("%-10s |", student.getPoint4());
            System.out.format("%-10s |", student.getPointMedium());
            System.out.println("\n");

        }
    }


    public static void addStudent(String name, String sex, int age) throws IOException {
        studentList.add(new Student(++id, name, sex, age));

        size++;

        saveProductToFile();
    }

    public static void saveProductToFile() throws IOException {
        StudentFile.writeProductToFile(studentList, "student.data");
    }

    public static Student getProductById(int numId) {
        for (Student student : studentList) {
            if (numId == student.getId())
                return student;
        }
        return null;
    }

    public static void InformationStudent() {
        System.out.println("nhập id học viên: ");
        int idRepair = Integer.parseInt(scanner.nextLine());
        Student student = getProductById(idRepair);
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
        System.out.println("nhập id học viên: ");
        int idRepair= Integer.parseInt(scanner.nextLine());
        Student student = getProductById(idRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }
        studentList.remove(student);
        System.out.println("đối tượng bị loại bỏ");
        

        saveProductToFile();
    }

    public static void inputScore() throws IOException {
        System.out.println("nhập id học viên muốn nhập điểm: ");
        int idRepair = Integer.parseInt(scanner.nextLine());
        Student student = getProductById(idRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }

        int point = choie("nhập ô điểm");
        if (point == 1) {
            if (!student.statusPont1) {
                int p1 = point("nhập điểm");
                student.statusPont1 = true;
                student.setPoint1(p1);
            } else System.out.println("điểm đã được nhập");

        }
        if (point == 2) {
            if (!student.statusPont2) {

                int p2 = point("nhập điểm");
                student.statusPont2 = true;
                student.setPoint2(p2);
            } else System.out.println("điểm đã được nhập");
        }
        if (point == 3) {
            if (!student.statusPont3) {

                int p3 = point("nhập điểm");
                ;
                student.statusPont3 = true;
                student.setPoint3(p3);
            } else System.out.println("điểm đã được nhập");
        }
        if (point == 4) {
            if (!student.statusPont4) {

                int p4 = point("nhập điểm");
                ;
                student.statusPont4 = true;
                student.setPoint4(p4);
            } else System.out.println("điểm đã được nhập");
        }
        student.setPointMedium(student.getPointMedium());
        saveProductToFile();
    }

    public static void repairScore() throws IOException {
        System.out.println("nhập id học viên muốn sửa điểm: ");
        int idRepair = Integer.parseInt(scanner.nextLine());
        Student student = getProductById(idRepair);
        if (student == null) {
            System.out.println("không tìm thấy học viên");
            return;
        }

        int point = choie("nhập ô điểm");
        if (point == 1) {


            if (student.statusPont1) {

                int p1 = point("nhập điểm");
                ;
                student.setPoint1(p1);

            } else System.out.println("điểm chưa được nhập");
        }
        if (point == 2) {
            if (student.statusPont2) {

                int p2 = point("nhập điểm");
                ;
                student.setPoint2(p2);
            } else System.out.println("điểm chưa được nhập");
        }
        if (point == 3) {
            if (student.statusPont3) {

                int p3 = point("nhập điểm");
                ;
                student.setPoint3(p3);
            } else System.out.println("điểm chưa được nhập");
        }
        if (point == 4) {
            if (student.statusPont4) {

                int p4 = point("nhập điểm");
                ;
                student.setPoint4(p4);
            } else System.out.println("điểm chưa được nhập");
        }
        student.setPointMedium(student.getPointMedium());
        saveProductToFile();
    }

    public static void sort() {

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPointMedium() < o2.getPointMedium() ? 1 : -1;
            }
        });
        StudentManagement.showStudent();
    }

    public static int age(String meseage) {
        System.out.println(meseage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num <= 0) {
                System.out.println("tuổi phải lớn hơn 0");
                return age(meseage);
            }
            return num;
        } catch (Exception e) {
            System.out.println("phải là một số");
            return age(meseage);
        }
    }

    public static int point(String meesage) {
        System.out.println(meesage);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 10 || num < 0) {
                System.out.println("điểm phải trong khoảng 0 --> 10");
                return point(meesage);
            }
            return num;
        } catch (Exception e) {
            System.out.println("phải là một số");
            return point(meesage);
        }
    }

    public static int choie(String me) {
        System.out.println(me);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 4 || num < 1) {
                System.out.println("điểm phải trong khoảng 0 --> 4");
                return point(me);
            }
            return num;
        } catch (Exception e) {
            System.out.println("phải là một số");
            return choie(me);
        }
    }
    public static String deleteWrite(String name){
        System.out.println(name);
        String newName = scanner.nextLine();
        return  newName.replaceAll("\\s\\s+", " ").trim();
    }
}