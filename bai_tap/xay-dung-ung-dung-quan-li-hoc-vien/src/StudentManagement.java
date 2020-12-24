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

                    String newName =validateName("nhập tên học viên");
                    while (newName.length() == 0) {
                        System.out.println("yêu cầu nhập tên");
                        newName = deleteWrite("nhập tên học viên(bắt buộc)");
                    }

                    String newSex = removeWrite("nhập giới tính");
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
                    StudentManagement.informationStudent();
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

    private static final Scanner scanner = new Scanner(System.in);
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
        System.out.format("%-50s | ", "tên");
        System.out.format("%-10s | ", "tuổi");
        System.out.format("%-10s | ", "giới tính");
        System.out.format("%-10s |", "điểm 1");
        System.out.format("%-10s |", "điểm 2");
        System.out.format("%-10s |", "điểm 3");
        System.out.format("%-10s |", "điểm 4");
        System.out.format("%-10s |", "điểm 5");
        System.out.format("\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Student student : studentList) {
            System.out.format("%-3s | ", student.getId());
            System.out.format("%-50s | ", student.getName());
            System.out.format("%-10s | ", student.getAge());
            System.out.format("%-10s | ", student.getSex());
            System.out.format("%-10s |", student.getPoint1());
            System.out.format("%-10s |", student.getPoint2());
            System.out.format("%-10s |", student.getPoint3());
            System.out.format("%-10s |", student.getPoint4());
            System.out.format("%-10s |", student.getPointMedium());
            System.out.format("\n");

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

    public static void informationStudent() {
        System.out.println("nhập id học viên muốn sửa: ");
        try {
            int idRepair = Integer.parseInt(scanner.nextLine());
            Student student = getProductById(idRepair);
            if (student == null) {
                System.out.println("không tìm thấy tên");
                return;
            } else {


                String newName = validateName("nhập tên");
                while (newName.length() == 0) {
                    System.out.println("yêu cầu nhập tên");
                    newName = deleteWrite("nhập tên");
                }
                student.setName(newName);

                String newSex = removeWrite("nhập giới tính");
                while (newSex.length() == 0 || newSex != null) {
                    if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                        break;
                    System.out.println("bạn nhập sai giới tính:");
                    System.out.println("nhập lại:");
                    newSex = scanner.nextLine();
                }
                student.setSex(newSex);

                try {
                    int newAge = age("nhập tuổi");
                    student.setAge(newAge);
                } catch (Exception e) {
                    System.out.println("bạn đã không sửa tuổi");
                }
                saveProductToFile();
            }
        } catch (Exception e) {
            informationStudent();
        }


    }

    public static void RemoveStudent() throws IOException {
        System.out.println("nhập id học viên: ");
        try {
            int idRepair = Integer.parseInt(scanner.nextLine());
            Student student = getProductById(idRepair);
            if (student == null) {
                System.out.println("không tìm thấy học viên");
                return;
            }
            studentList.remove(student);
            System.out.println("đối tượng bị loại bỏ");


            saveProductToFile();
        } catch (Exception e) {
            RemoveStudent();
        }

    }

    public static void inputScore() throws IOException {
        System.out.println("nhập id học viên muốn nhập điểm: ");
        try {
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

                    student.statusPont3 = true;
                    student.setPoint3(p3);
                } else System.out.println("điểm đã được nhập");
            }
            if (point == 4) {
                if (!student.statusPont4) {

                    int p4 = point("nhập điểm");

                    student.statusPont4 = true;
                    student.setPoint4(p4);
                } else System.out.println("điểm đã được nhập");
            }
            student.setPointMedium(student.getPointMedium());
            saveProductToFile();
        } catch (Exception e) {
            inputScore();
        }

    }

    public static void repairScore() throws IOException {
        System.out.println("nhập id học viên muốn sửa điểm: ");
        try {
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

                    student.setPoint1(p1);

                } else System.out.println("điểm chưa được nhập");
            }
            if (point == 2) {
                if (student.statusPont2) {

                    int p2 = point("nhập điểm");

                    student.setPoint2(p2);
                } else System.out.println("điểm chưa được nhập");
            }
            if (point == 3) {
                if (student.statusPont3) {

                    int p3 = point("nhập điểm");

                    student.setPoint3(p3);
                } else System.out.println("điểm chưa được nhập");
            }
            if (point == 4) {
                if (student.statusPont4) {

                    int p4 = point("nhập điểm");

                    student.setPoint4(p4);
                } else System.out.println("điểm chưa được nhập");
            }
            student.setPointMedium(student.getPointMedium());
            saveProductToFile();
        } catch (Exception e) {
            repairScore();
        }

    }

    public static void sort() {

        studentList.sort(new Comparator<Student>() {
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

    public static String deleteWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        if (newName.length() < 45) {
            return newName.replaceAll("\\s\\s+", " ").trim();
        } else System.out.println("tên không thể quá dài");
        return deleteWrite(name);
    }

    public static String removeWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }

    private static String validateName(String mess) {
        System.out.println(mess);
        try {
            String name = scanner.nextLine();
            name = name.toLowerCase();
            name = name.trim();
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < name.length(); i++) {
                if (name.split("")[i].matches("[\\d]")) {
                    throw new Exception();
                } else {
                    arr.add(name.split("")[i]);
                }
            }
            // Del space
            String str = arr.get(0).toUpperCase();
            arr.remove(0);
            arr.add(0, str);
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i).equals(" ") && arr.get(i + 1).equals(" ")) {
                    arr.remove(i + 1);
                    i--;
                }
                if (arr.get(i).equals(" ") && !arr.get(i + 1).equals(" ")) {
                    String result = arr.get(i + 1).toUpperCase();
                    arr.remove(i + 1);
                    arr.add(i + 1, result);
                }
            }
            StringBuilder listString = new StringBuilder();
            for (String s : arr) {
                listString.append(s);
            }
            if (listString.toString().length() > 25)
                throw new Exception();
            return listString.toString();
        } catch (Exception e) {
            System.err.println("Trong tên không được có số hoặc quá dài và không để trống");
            return validateName(mess);
        }
    }


}