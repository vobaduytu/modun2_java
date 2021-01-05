import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    static Gson gson = new Gson();
    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> tempList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int size = 0;
    private static int id = 0;
    public static ArrayList<Student> searchName(String name) {
        for (Student s : studentList) {
            if (s.getName().contains(name)) {
                tempList.add(s);
            }
        }
        return tempList;
    }
    // kiểm tra id có tồn tại
    public static Student getProductById(int numId) {
        for (Student student : studentList) {
            if (numId == student.getId())
                return student;
        }
        return null;
    }
//    lưu file cũ
    //    static {
//        try {
//            Object studentFile = StudentFile.readProductToFile("student.data");
//            if (studentFile == null) {
//                studentList = new ArrayList<>();
//            } else {
//                studentList = (ArrayList<Student>) studentFile;
//            }
//            int maxId = 0;
//            for (Student student : studentList) {
//                int currentId = student.getId();
//                if (currentId > maxId)
//                    maxId = currentId;
//            }
//            id = maxId;
//        } catch (IOException | ClassNotFoundException e) {
//            studentList = new ArrayList<>();
//            id = 0;
//        }
//    } s s
    static {
    try (Reader reader = new FileReader("students.json")){
        Type classOfT = new TypeToken<ArrayList<Student>>(){}.getType();
        studentList = gson.fromJson(reader, classOfT);
        int maxId = 0;
            for (Student student : studentList) {
                int currentId = student.getId();
                if (currentId > maxId)
                    maxId = currentId;
            }
            id = maxId;
    } catch (IOException e) {
            studentList = new ArrayList<>();
            id = 0;
    }
}


    //    thêm học viên
    public static void addStudent(String name, String sex, String age) throws IOException {
        studentList.add(new Student(++id, name, sex, age));
        size++;
//
        saveToFile();
    }
    //sửa thông tin học viên
    public static void informationStudent() {

        String nameRepair = Validate.validateName("nhập tên học viên muốn sửa");

        searchName(nameRepair);


        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
            tempList.clear();
        } else {
            ShowStudent.showStudent(tempList);
            System.out.println("nhập id học viên muốn sửa: ");
            try {
                int idRepair = Integer.parseInt(scanner.nextLine());
                Student student = getProductById(idRepair);
                if (student == null) {
                    System.out.println("không tìm thấy tên");
                    tempList.clear();
                    return;
                } else {
                    System.out.println("1.sửa tên");
                    System.out.println("2.sửa giới tính");
                    System.out.println("3.sửa tuổi");
                    int chon = Integer.parseInt(scanner.nextLine());

                    if (chon == 1) {
                        String newName = Validate.validateName("nhập tên");
                        while (newName.length() == 0) {
                            System.out.println("yêu cầu nhập tên");
                            newName = Validate.validateName("nhập tên");
                        }
                        student.setName(newName);
                    }
                    if (chon == 2) {
                        String newSex = Validate.deleteWrite("nhập giới tính");
                        while (newSex.length() == 0 || newSex != null) {
                            if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                                break;
                            System.out.println("bạn nhập sai giới tính:");
                            System.out.println("nhập lại:");
                            newSex = Validate.deleteWrite("nhập giới tính");
                        }
                        student.setSex(newSex);
                    } else if (chon == 3) {
                        try {
                            String newAge = Validate.age("nhập ngày sinh");
                            student.setAge(newAge);
                        } catch (Exception e) {
                            System.out.println("bạn đã không sửa ngày sinh");
                        }
                    }
                    tempList.clear();
                   saveToFile();
                }
            } catch (Exception e) {
                informationStudent();
            }
        }
    }
    //xóa học viên
    public static void RemoveStudent() throws IOException {

        String nameRepair = Validate.validateName("nhập tên học viên muốn xóa");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
            tempList.clear();
        } else {
            ShowStudent.showStudent(tempList);
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
                tempList.clear();
                saveToFile();
            } catch (Exception e) {
                RemoveStudent();
            }
        }

    }
    //thêm điểm
    public static void inputScore() throws IOException {

        String nameRepair = Validate.validateName("nhập tên học viên muốn thêm điểm");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
            tempList.clear();
        } else {
            ShowStudent.showStudent(tempList);
            System.out.println("1.nhập điểm 1 cột");
            System.out.println("2.nhập tất cả điểm của một học viên");
            System.out.println("3.nhập điểm theo cột của tất cả học viên");

            int chon2 = Integer.parseInt(scanner.nextLine());
            if (chon2 == 1) {
                System.out.println("nhập id học viên muốn nhập điểm: ");
                try {
                    int idRepair = Integer.parseInt(scanner.nextLine());
                    Student student = getProductById(idRepair);
                    if (student == null) {
                        System.out.println("không tìm thấy học viên");
                        tempList.clear();
                        return;
                    }
                    int point = Validate.choie("nhập ô điểm");
                    if (point == 1) {
                        if (!student.statusPont1) {
                            int p1 = Validate.point("nhập điểm");
                            student.statusPont1 = true;
                            student.setPoint1(p1);
                        } else System.out.println("điểm đã được nhập");
                    }
                    if (point == 2) {
                        if (!student.statusPont2) {
                            int p2 = Validate.point("nhập điểm");
                            student.statusPont2 = true;
                            student.setPoint2(p2);
                        } else System.out.println("điểm đã được nhập");
                    }
                    if (point == 3) {
                        if (!student.statusPont3) {
                            int p3 = Validate.point("nhập điểm");
                            student.statusPont3 = true;
                            student.setPoint3(p3);
                        } else System.out.println("điểm đã được nhập");
                    }
                    if (point == 4) {
                        if (!student.statusPont4) {
                            int p4 = Validate.point("nhập điểm");
                            student.statusPont4 = true;
                            student.setPoint4(p4);
                        } else System.out.println("điểm đã được nhập");
                    }
                    if (point == 5) {
                        Menu.main();
                    }
                    student.setPointMedium(student.getPointMedium());
                    tempList.clear();
                 saveToFile();
                } catch (Exception e) {
                    inputScore();
                }
            }
            tempList.clear();
            if (chon2 == 2) {
                System.out.println("nhập id học viên muốn nhập điểm: ");
                try {
                    int idRepair = Integer.parseInt(scanner.nextLine());
                    Student student = getProductById(idRepair);
                    if (student == null) {
                        System.out.println("không tìm thấy học viên");
                        tempList.clear();
                        return;
                    }
                    if (!student.statusPont1) {
                        int p1 = Validate.point("nhập điểm");
                        student.statusPont1 = true;
                        student.setPoint1(p1);
                    } else System.out.println("điểm đã được nhập");

                    if (!student.statusPont2) {
                        int p2 = Validate.point("nhập điểm");
                        student.statusPont2 = true;
                        student.setPoint2(p2);
                    } else System.out.println("điểm đã được nhập");
                    if (!student.statusPont3) {
                        int p3 = Validate.point("nhập điểm");
                        student.statusPont3 = true;
                        student.setPoint3(p3);
                    } else System.out.println("điểm đã được nhập");

                    if (!student.statusPont4) {
                        int p4 = Validate.point("nhập điểm");
                        student.statusPont4 = true;
                        student.setPoint4(p4);
                    } else System.out.println("điểm đã được nhập");

                    student.setPointMedium(student.getPointMedium());
                    tempList.clear();
                   saveToFile();
                } catch (Exception e) {
                    inputScore();
                }
            } tempList.clear();
            if (chon2 == 3) {
                int point = Validate.choie("nhập ô điểm");
                if (point == 1) {
                    for (Student student : studentList) {
                        if (!student.statusPont1) {
                            System.out.println("nhap diem cua " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.statusPont1 = true;
                            student.setPoint1(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                            saveToFile();
                        } else {
                            System.out.println("diem da duoc nhap");
                        }
                    }
                }
                tempList.clear();
                if (point == 2) {
                    for (Student student : studentList) {
                        if (!student.statusPont2) {
                            System.out.println("nhap diem cua " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.statusPont2 = true;
                            student.setPoint2(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                          saveToFile();
                        } else {
                            System.out.println("diem da duoc nhap");
                        }
                    }
                }
                tempList.clear();
                if (point == 3) {
                    for (Student student : studentList) {
                        if (!student.statusPont3) {
                            System.out.println("nhap diem cua " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.statusPont3 = true;
                            student.setPoint3(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                            saveToFile();
                        } else {
                            System.out.println("diem da duoc nhap");
                        }
                    }
                }
                tempList.clear();
                if (point == 4) {
                    for (Student student : studentList) {
                        if (!student.statusPont4) {
                            System.out.println("nhap diem cua " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.statusPont4 = true;
                            student.setPoint4(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                           saveToFile();
                        } else {
                            System.out.println("diem da duoc nhap");
                        }
                    }
                }
                tempList.clear();
                if (point == 5) {
                    {
                        Menu.main();
                    }
                }
            }

        }

    }
    //sửa điểm
    public static void repairScore() throws IOException {

        String nameRepair = Validate.validateName("nhập tên học viên muốn sửa điểm");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("tên không tồn tại");
        } else {
            ShowStudent.showStudent(tempList);
            System.out.println("1.sửa điểm 1 cột");
            System.out.println("2.sửa tất cả điểm của một học viên");
            System.out.println("3.sửa điểm theo cột của tất cả học viên");

            int chon2 = Integer.parseInt(scanner.nextLine());
            if (chon2 == 1) {
                System.out.println("nhập id học viên muốn sửa điểm: ");
                try {
                    int idRepair = Integer.parseInt(scanner.nextLine());
                    Student student = getProductById(idRepair);
                    if (student == null) {
                        tempList.clear();
                        System.out.println("không tìm thấy học viên");

                        return;
                    }
                    int point = Validate.choie("nhập ô điểm");
                    if (point == 1) {
                        if (student.statusPont1) {
                            int p1 = Validate.point("nhập điểm");

                            student.setPoint1(p1);
                        } else System.out.println("điểm chưa được nhập");
                    }
                    if (point == 2) {
                        if (student.statusPont2) {

                            int p2 = Validate.point("nhập điểm");

                            student.setPoint2(p2);
                        } else System.out.println("điểm chưa được nhập");
                    }
                    if (point == 3) {
                        if (student.statusPont3) {

                            int p3 = Validate.point("nhập điểm");

                            student.setPoint3(p3);
                        } else System.out.println("điểm chưa được nhập");
                    }
                    if (point == 4) {
                        if (student.statusPont4) {

                            int p4 = Validate.point("nhập điểm");

                            student.setPoint4(p4);
                        } else System.out.println("điểm chưa được nhập");
                    }
                    if (point == 5) {
                        Menu.main();
                    }
                    student.setPointMedium(student.getPointMedium());
                    tempList.clear();
                   saveToFile();
                } catch (Exception e) {
                    repairScore();
                }
            } tempList.clear();
            if (chon2 == 2) {
                System.out.println("nhập id học viên muốn sửa điểm: ");
                try {
                    int idRepair = Integer.parseInt(scanner.nextLine());
                    Student student = getProductById(idRepair);
                    if (student == null) {
                        System.out.println("không tìm thấy học viên");
                        tempList.clear();
                        return;
                    }
                    if (student.statusPont1) {
                        int p1 = Validate.point("nhập điểm");
                        student.setPoint1(p1);
                    } else System.out.println("điểm chưa được nhập");

                    if (student.statusPont2) {
                        int p2 = Validate.point("nhập điểm");

                        student.setPoint2(p2);
                    } else System.out.println("điểm chưa được nhập");
                    if (student.statusPont3) {
                        int p3 = Validate.point("nhập điểm");

                        student.setPoint3(p3);
                    } else System.out.println("điểm chưa được nhập");

                    if (student.statusPont4) {
                        int p4 = Validate.point("nhập điểm");

                        student.setPoint4(p4);
                    } else System.out.println("điểm chưa được nhập");

                    student.setPointMedium(student.getPointMedium());
                    tempList.clear();
                 saveToFile();
                } catch (Exception e) {
                    inputScore();
                }
            } tempList.clear();
            if (chon2 == 3){
                int point = Validate.choie("nhập ô điểm");
                if (point == 1) {
                    for (Student student : studentList) {
                        if (student.statusPont1) {
                            System.out.println("sửa điểm của " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.setPoint1(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                            saveToFile();
                        } else {
                            System.out.println("điểm đã được nhập");
                        }
                    }
                }
                tempList.clear();
                if (point == 2) {
                    for (Student student : studentList) {
                        if (student.statusPont2) {
                            System.out.println("sửa điểm của" + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.setPoint2(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                         saveToFile();
                        } else {
                            System.out.println("điểm đã được nhập");
                        }
                    }
                }
                tempList.clear();
                if (point == 3) {
                    for (Student student : studentList) {
                        if (student.statusPont3) {
                            System.out.println("sửa điểm của " + student.getName());
                            int ss = Validate.point("nhập điểm");

                            student.setPoint3(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                           saveToFile();
                        } else {
                            System.out.println("điểm đã được nhập");
                        }
                    }
                }
                tempList.clear();
                if (point == 4) {
                    for (Student student : studentList) {
                        if (student.statusPont4) {
                            System.out.println("sửa điểm của " + student.getName());
                            int ss = Validate.point("nhập điểm");
                            student.setPoint4(ss);
                            student.setPointMedium(student.getPointMedium());
                            tempList.clear();
                           saveToFile();
                        } else {
                            System.out.println("điểm đã được nhập");
                        }
                    }
                }
                tempList.clear();
                if (point == 5) {
                    {
                        Menu.main();
                    }
                }
            }
        }
        tempList.clear();

    }
    // sắp xếp
    public static void sort() {

        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPointMedium() < o2.getPointMedium() ? 1 : -1;
            }
        });

        ShowStudent.showStudent(studentList);

    }
    //    lưu file
    public static void saveToFile(){
        try(FileWriter fileWriter = new FileWriter("students.json")){
            gson.toJson(studentList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
