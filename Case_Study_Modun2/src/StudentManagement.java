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
    public static Student getStudentById(int numId) {
        for (Student student : tempList) {
            if (numId == student.getId())
                return student;
        }
        return null;
    }

    //lưu file + id tự tăng
    static {
        try (Reader reader = new FileReader("students.json")) {
            Type classOfT = new TypeToken<ArrayList<Student>>() {
            }.getType();
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
    public static void informationStudent() throws IOException {
        System.out.println("1.nhập tên học viên muốn sửa");
        System.out.println("2.về Menu");
        int chon5 = Validate.validateID("lựa chọn của bạn");
        if (chon5 == 1) {
            String nameRepair = Validate.validateName("nhập tên học viên muốn sửa");
            searchName(nameRepair);
            if (tempList.size() == 0) {
                System.out.println("tên không tồn tại");
                tempList.clear();
            } else {
                ShowStudent.showStudent(tempList);

                try {
                    int idRepair = Validate.validateID("nhập id học viên muốn sửa");
                    Student student = getStudentById(idRepair);
                    if (student == null) {
                        System.out.println("không tìm thấy tên");
                        tempList.clear();
                    } else {
                        System.out.println("1.sửa tên");
                        System.out.println("2.sửa giới tính");
                        System.out.println("3.sửa ngày sinh");
                        System.out.println("4.quay lại");
                        int chon = Integer.parseInt(scanner.nextLine());

                        if (chon == 1) {
                            String newName = Validate.validateName("nhập tên");
                            while (newName.length() == 0) {
                                System.out.println("yêu cầu nhập tên");
                                newName = Validate.validateName("nhập tên");
                            }
                            student.setName(newName);
                            informationStudent();
                        }
                        tempList.clear();
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
                            tempList.clear();
                        }
                        if (chon == 3) {
                            try {
                                String newAge = Validate.age("nhập ngày sinh");
                                student.setAge(newAge);
                            } catch (Exception e) {
                                System.out.println("bạn đã không sửa ngày sinh");
                            }
                        }
                        tempList.clear();
                        if (chon == 4) {
                            informationStudent();
                        }
                        tempList.clear();
                        saveToFile();
                    }
                } catch (Exception e) {
                    informationStudent();
                }
            }
        }
        if (chon5 == 2) {
            Menu.main();
        }

    }

    //xóa học viên
    public static void RemoveStudent() throws IOException {

        String nameRepair = Validate.validateName("nhập tên học viên muốn xóa");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("tên không tồn tại");
            tempList.clear();
        } else {
            ShowStudent.showStudent(tempList);
            System.out.println("1.về menu");
            System.out.println("2.xóa hết");
            System.out.println("3.nhập id học viên muốn xóa");
            int chon4 = Validate.validateID("nhập lựa chọn");
            if (chon4 == 1) {
                tempList.clear();
                Menu.main();
            }
            if (chon4 == 2) {
                for (Student s : tempList) {
                    studentList.remove(s);
                }
                System.out.println("đã xóa");
                tempList.clear();
                saveToFile();
            }
            if (chon4 == 3) {
                try {
                    int idRepair = Validate.validateID("3.nhập id học viên muốn xóa");
                    Student student = getStudentById(idRepair);
                    if (student == null) {
                        System.out.println("không tìm thấy học viên");
                        tempList.clear();
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
    }

    //thêm điểm
    public static void inputScore() throws IOException {
        try {
            String nameRepair = Validate.validateName("nhập tên học viên muốn thêm điểm");
            searchName(nameRepair);
            if (tempList.size() == 0) {
                System.out.println("tên không tồn tại");
                System.out.println("1.nhập lại");
                System.out.println("2.về menu");
                int chon6 = Validate.validateChon("nhập lựa chọn");

                if (chon6 == 1) {
                    inputScore();
                } else {
                    Menu.main();
                }
            } else {
                ShowStudent.showStudent(tempList);
                System.out.println("1.nhập điểm 1 cột");
                System.out.println("2.nhập tất cả điểm của một học viên");
                System.out.println("3.nhập điểm theo cột của tất cả học viên");
                System.out.println("4.về menu");

                int chon2 = Validate.validateChon("nhập lựa chọn");
                if (chon2 == 1) {

                    try {
                        boolean check = true;
                        Student student = null;
                        while (check) {
                            check = false;
                            int idRepair = Validate.validateID("nhập id học viên muốn thêm điểm");
                            student = getStudentById(idRepair);
                            if (student == null) {
                                System.out.println("không tìm thấy học viên");
                                System.out.println("1.quay lại");
                                System.out.println("2.về menu");
                                System.out.println("3.nhập lại id");
                                int chon7 = Validate.validateChon("nhập lựa chọn");
                                if (chon7 == 2) {
                                    tempList = new ArrayList<>();
                                    Menu.main();
                                }
                                if (chon7 == 1) {
                                    tempList = new ArrayList<>();
                                    inputScore();
                                }
                                if (chon7 == 3) {
                                    check = true;
                                }

                            }
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

                if (chon2 == 2) {

                    try {
                        int idRepair = Validate.validateID("nhập id học viên muốn thêm điểm");
                        Student student = getStudentById(idRepair);
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
                }
                if (chon2 == 3) {
                    int point = Validate.choie("nhập ô điểm");
                    if (point == 1) {
                        for (Student student : tempList) {
                            if (!student.statusPont1) {
                                System.out.println("nhập điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.statusPont1 = true;
                                student.setPoint1(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm đã được nhập");
                            }
                        }
                        tempList.clear();
                    }

                    if (point == 2) {
                        for (Student student : tempList) {
                            if (!student.statusPont2) {
                                System.out.println("nhập điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.statusPont2 = true;
                                student.setPoint2(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm đã được nhập");
                            }
                        }
                        tempList.clear();
                    }

                    if (point == 3) {
                        for (Student student : tempList) {
                            if (!student.statusPont3) {
                                System.out.println("nhập điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.statusPont3 = true;
                                student.setPoint3(ss);
                                student.setPointMedium(student.getPointMedium());
                                saveToFile();
                            } else {
                                System.out.println("điểm đã được nhập");
                            }
                        }
                        tempList.clear();
                    }
                    if (point == 4) {
                        for (Student student : tempList) {
                            if (!student.statusPont4) {
                                System.out.println("nhập điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.statusPont4 = true;
                                student.setPoint4(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm đã được nhập");
                            }
                        }
                        tempList.clear();
                    }
                    tempList.clear();
                    if (point == 5) {
                        {
                            Menu.main();
                        }
                    }
                }
                if (chon2 == 4) {
                    tempList.clear();
                    Menu.main();
                }
            }
            tempList.clear();
        } catch (NumberFormatException | IOException e) {
            tempList.clear();
        }

    }

    //sửa điểm
    public static void repairScore() throws IOException {
        try {
            String nameRepair = Validate.validateName("nhập tên học viên muốn sửa điểm");
            searchName(nameRepair);
            if (tempList.size() == 0) {
                System.out.println("tên không tồn tại");
                System.out.println("1.nhập lại");
                System.out.println("2.về menu");
                int chon6 = Validate.validateChon("nhập lựa chọn");

                if (chon6 == 1) {
                    repairScore();
                } else {
                    Menu.main();
                }
            } else {
                ShowStudent.showStudent(tempList);
                System.out.println("1.sửa điểm 1 cột");
                System.out.println("2.sửa tất cả điểm của một học viên");
                System.out.println("3.sửa điểm theo cột của tất cả học viên");
                System.out.println("4.về menu");

                int chon2 = Validate.validateChon("nhập lựa chọn");
                if (chon2 == 1) {

                    try {
                        boolean check = true;
                        Student student = null;
                        while (check) {
                            check = false;
                            int idRepair = Validate.validateID("nhập id học viên muốn sửa điểm");
                            student = getStudentById(idRepair);
                            if (student == null) {
                                System.out.println("không tìm thấy học viên");
                                System.out.println("1.quay lại");
                                System.out.println("2.về menu");
                                System.out.println("3.nhập lại id");
                                int chon7 = Validate.validateChon("nhập lựa chọn");
                                if (chon7 == 2) {
                                    tempList = new ArrayList<>();
                                    Menu.main();
                                }
                                if (chon7 == 1) {
                                    tempList = new ArrayList<>();
                                    repairScore();
                                }
                                if (chon7 == 3) {
                                    check = true;
                                }

                            }
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
                }
                if (chon2 == 2) {

                    try {
                        int idRepair = Validate.validateID("nhập id học viên muốn sửa");
                        Student student = getStudentById(idRepair);
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
                }
                if (chon2 == 3) {
                    int point = Validate.choie("nhập ô điểm");
                    if (point == 1) {
                        for (Student student : tempList) {
                            if (student.statusPont1) {
                                System.out.println("sửa điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.setPoint1(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm chưa được nhập");
                            }
                        }
                        tempList.clear();

                    }

                    if (point == 2) {
                        for (Student student : tempList) {
                            if (student.statusPont2) {
                                System.out.println("sửa điểm của" + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.setPoint2(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm chưa được nhập");
                            }
                        }
                        tempList.clear();
                    }

                    if (point == 3) {
                        for (Student student : tempList) {
                            if (student.statusPont3) {
                                System.out.println("sửa điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");

                                student.setPoint3(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm chưa được nhập");
                            }
                        }
                        tempList.clear();
                    }

                    if (point == 4) {
                        for (Student student : tempList) {
                            if (student.statusPont4) {
                                System.out.println("sửa điểm của " + student.getName());
                                int ss = Validate.point("nhập điểm");
                                student.setPoint4(ss);
                                student.setPointMedium(student.getPointMedium());

                                saveToFile();
                            } else {
                                System.out.println("điểm chưa được nhập");
                            }
                        }
                        tempList.clear();
                    }

                    if (point == 5) {
                        {
                            repairScore();
                        }
                    }
                }
                if (chon2 == 4) {
                    tempList.clear();
                    Menu.main();
                }
            }
            tempList.clear();

        } catch (NumberFormatException | IOException e) {
            tempList.clear();
        }


    }

    // sắp xếp
    public static void sort() {
        for (Student s : studentList) {
            tempList.add(s);
        }
        tempList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPointMedium() < o2.getPointMedium() ? 1 : -1;
            }
        });

        ShowStudent.showStudent(tempList);
        tempList.clear();

    }

    //    lưu file
    public static void saveToFile() {
        try (FileWriter fileWriter = new FileWriter("students.json")) {
            gson.toJson(studentList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

