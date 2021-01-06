import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class StudentManagement {
    static ArrayList<Student> tempList = new ArrayList<>();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static {
        formatter.setLenient(false);
    }

    public static void main() throws IOException {

        Scanner input = new Scanner(System.in);
        try {
            boolean cont = true;
            do {
                System.out.println("-----------Menu-----------");
                System.out.println("1: Xem danh sách học viên");
                System.out.println("2: Thêm học viên");
                System.out.println("3: Sửa thông tin học viên");
                System.out.println("4: Xóa học viên");
                System.out.println("5: Nhập điểm học viên ");
                System.out.println("6: Sửa điểm học viên");
                System.out.println("7: Xếp loại học viên");
                System.out.println("8: exit");
                System.out.println("--------------------------");
                int chon = input.nextInt();

                switch (chon) {
                    case 1:
                        StudentManagement.showStudent(studentList);
                        break;
                    case 2:
                        String newName = validateName("nhập tên học viên");
                        while (newName.length() == 0) {
                            System.out.println("yêu cầu nhập tên");
                            newName = validateName("nhập tên học viên(bắt buộc)");
                        }

                        String newSex = removeWrite("nhập giới tính");
                        while (newSex != null) {
                            if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                                break;
                            System.out.println("bạn nhập sai giới tính:");
                            System.out.println("nhập lại:");
                            newSex = removeWrite("nhập giới tính");
                        }

                        String newAge = age("nhập ngày sinh");

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
                        System.out.println("theo thứ tự giảm dần");
                        StudentManagement.sort();
                        break;
                    case 8:
                        System.out.println("tạm biệt......");
                        return;
                    default:
                        System.err.println("nhập sai - chọn lại");

                        break;
                }
            }
            while (cont);
        } catch (Exception e) {
            System.err.println("chọn lại:");
            main();
        }
    }

    static Pattern namePattern = Pattern.compile("^[a-zA-Z ]{1,40}$");
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

    //hiển thị
    public static void showStudent(ArrayList<Student> studentList) {
        System.out.format("%-3.5s | ", "Id");
        System.out.format("%-40s | ", "tên");
        System.out.format("%-15s | ", "ngày sinh");
        System.out.format("%-10s | ", "giới tính");
        System.out.format("%-15s |", "điểm hệ số 1-1");
        System.out.format("%-15s |", "điểm hệ số 1-2");
        System.out.format("%-15s |", "điểm hệ số 2");
        System.out.format("%-15s |", "điểm hệ số 3");
        System.out.format("%-10s |", "điểm TB");
        System.out.format("\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Student student : studentList) {
            System.out.format("%-3s | ", student.getId());
            System.out.format("%-40s | ", student.getName());
            System.out.format("%-15s | ", student.getAge());
            System.out.format("%-10s | ", student.getSex());
            if (!student.statusPont1) {
                String s = String.valueOf(student.point1);
                s = "";
                System.out.format("%-15.4s |", s);
            } else
                System.out.format("%-15.4s |", student.getPoint1());
            if (!student.statusPont2) {
                String s = String.valueOf(student.point1);
                s = "";
                System.out.format("%-15.4s |", s);
            } else
                System.out.format("%-15.4s |", student.getPoint2());
            if (!student.statusPont3) {
                String s = String.valueOf(student.point1);
                s = "";
                System.out.format("%-15.4s |", s);
            } else
                System.out.format("%-15.4s |", student.getPoint3());
            if (!student.statusPont4) {
                String s = String.valueOf(student.point1);
                s = "";
                System.out.format("%-15.4s |", s);
            } else
                System.out.format("%-15.4s |", student.getPoint4());

            if (student.statusPont1 && student.statusPont2 && student.statusPont3 && student.statusPont4) {
                System.out.format("%-10.4s |", student.getPointMedium());
            } else {
                String s = String.valueOf(student.getPointMedium());
                s = "";
                System.out.format("%-10.4s |", s);
            }

            System.out.format("\n");
        }
    }

    public static void addStudent(String name, String sex, String age) throws IOException {
        studentList.add(new Student(++id, name, sex, age));

        size++;
        saveProductToFile();
    }

    //lưu file
    public static void saveProductToFile() throws IOException {
        StudentFile.writeProductToFile(studentList, "student.data");
    }

    // kiểm tra id có tồn tại
    public static Student getProductById(int numId) {
        for (Student student : studentList) {
            if (numId == student.getId())
                return student;
        }
        return null;
    }


    public static ArrayList<Student> searchName(String name) {
        for (Student s : studentList) {
            if (s.getName().contains(name)) {
                tempList.add(s);
            }
        }
        return tempList;
    }

    //sửa thông tin học viên
    public static void informationStudent() {

        String nameRepair = validateName("nhập tên học viên muốn sửa");

        searchName(nameRepair);


        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
            tempList.clear();
        } else {
            showStudent(tempList);
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
                        String newName = validateName("nhập tên");
                        while (newName.length() == 0) {
                            System.out.println("yêu cầu nhập tên");
                            newName = validateName("nhập tên");
                        }
                        student.setName(newName);
                    }
                    if (chon == 2) {
                        String newSex = deleteWrite("nhập giới tính");
                        while (newSex.length() == 0 || newSex != null) {
                            if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                                break;
                            System.out.println("bạn nhập sai giới tính:");
                            System.out.println("nhập lại:");
                            newSex = deleteWrite("nhập giới tính");
                        }
                        student.setSex(newSex);
                    } else if (chon == 3) {
                        try {
                            String newAge = age("nhập ngày sinh");
                            student.setAge(newAge);
                        } catch (Exception e) {
                            System.out.println("bạn đã không sửa ngày sinh");
                        }
                    }
                    tempList.clear();
                    saveProductToFile();
                }
            } catch (Exception e) {
                informationStudent();
            }
        }
    }

    //xóa học viên
    public static void RemoveStudent() throws IOException {

        String nameRepair = validateName("nhập tên học viên muốn xóa");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
            tempList.clear();
        } else {
            showStudent(tempList);
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
                saveProductToFile();
            } catch (Exception e) {
                RemoveStudent();
            }
        }

    }

        //thêm điểm
        public static void inputScore() throws IOException {

            String nameRepair = validateName("nhập tên học viên muốn thêm điểm");
            searchName(nameRepair);
            if (tempList.size() == 0) {
                System.out.println("ten khong ton tai");
                tempList.clear();
            } else {
                showStudent(tempList);
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
                        if (point == 5) {
                            main();
                        }
                        student.setPointMedium(student.getPointMedium());
                        tempList.clear();
                        saveProductToFile();
                    } catch (Exception e) {
                        inputScore();
                    }
                } tempList.clear();
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
                            int p1 = point("nhập điểm");
                            student.statusPont1 = true;
                            student.setPoint1(p1);
                        } else System.out.println("điểm đã được nhập");

                        if (!student.statusPont2) {
                            int p2 = point("nhập điểm");
                            student.statusPont2 = true;
                            student.setPoint2(p2);
                        } else System.out.println("điểm đã được nhập");
                        if (!student.statusPont3) {
                            int p3 = point("nhập điểm");
                            student.statusPont3 = true;
                            student.setPoint3(p3);
                        } else System.out.println("điểm đã được nhập");

                        if (!student.statusPont4) {
                            int p4 = point("nhập điểm");
                            student.statusPont4 = true;
                            student.setPoint4(p4);
                        } else System.out.println("điểm đã được nhập");

                        student.setPointMedium(student.getPointMedium());
                        tempList.clear();
                        saveProductToFile();
                    } catch (Exception e) {
                        inputScore();
                    }
                } tempList.clear();
                if (chon2 == 3) {
                    int point = choie("nhập ô điểm");
                    if (point == 1) {
                        for (Student student : studentList) {
                            if (!student.statusPont1) {
                                System.out.println("nhap diem cua " + student.getName());
                                int ss = point("nhập điểm");
                                student.statusPont1 = true;
                                student.setPoint1(ss);
                                student.setPointMedium(student.getPointMedium());
                                tempList.clear();
                                saveProductToFile();
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
                                int ss = point("nhập điểm");
                                student.statusPont2 = true;
                                student.setPoint2(ss);
                                student.setPointMedium(student.getPointMedium());
                                tempList.clear();
                                saveProductToFile();
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
                                int ss = point("nhập điểm");
                                student.statusPont3 = true;
                                student.setPoint3(ss);
                                student.setPointMedium(student.getPointMedium());
                                tempList.clear();
                                saveProductToFile();
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
                                int ss = point("nhập điểm");
                                student.statusPont4 = true;
                                student.setPoint4(ss);
                                student.setPointMedium(student.getPointMedium());
                                tempList.clear();
                                saveProductToFile();
                            } else {
                                System.out.println("diem da duoc nhap");
                            }
                        }
                    }
                    tempList.clear();
                    if (point == 5) {
                        {
                            main();
                        }
                    }
                }

            }

        }

    //sửa điểm
    public static void repairScore() throws IOException {

        String nameRepair = validateName("nhập tên học viên muốn thêm điểm");
        searchName(nameRepair);
        if (tempList.size() == 0) {
            System.out.println("ten khong ton tai");
        } else {
            showStudent(tempList);
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
                    if (point == 5) {
                        main();
                    }
                    student.setPointMedium(student.getPointMedium());
                    saveProductToFile();
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
                        int p1 = point("nhập điểm");
                        student.setPoint1(p1);
                    } else System.out.println("điểm chưa được nhập");

                    if (student.statusPont2) {
                        int p2 = point("nhập điểm");

                        student.setPoint2(p2);
                    } else System.out.println("điểm chưa được nhập");
                    if (student.statusPont3) {
                        int p3 = point("nhập điểm");

                        student.setPoint3(p3);
                    } else System.out.println("điểm chưa được nhập");

                    if (student.statusPont4) {
                        int p4 = point("nhập điểm");

                        student.setPoint4(p4);
                    } else System.out.println("điểm chưa được nhập");

                    student.setPointMedium(student.getPointMedium());
                    tempList.clear();
                    saveProductToFile();
                } catch (Exception e) {
                    inputScore();
                }
            } tempList.clear();
          if (chon2 == 3){
              int point = choie("nhập ô điểm");
              if (point == 1) {
                  for (Student student : studentList) {
                      if (student.statusPont1) {
                          System.out.println("sửa điểm của " + student.getName());
                          int ss = point("nhập điểm");
                          student.setPoint1(ss);
                          student.setPointMedium(student.getPointMedium());
                          tempList.clear();
                          saveProductToFile();
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
                          int ss = point("nhập điểm");
                          student.setPoint2(ss);
                          student.setPointMedium(student.getPointMedium());
                          tempList.clear();
                          saveProductToFile();
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
                          int ss = point("nhập điểm");

                          student.setPoint3(ss);
                          student.setPointMedium(student.getPointMedium());
                          tempList.clear();
                          saveProductToFile();
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
                          int ss = point("nhập điểm");
                          student.setPoint4(ss);
                          student.setPointMedium(student.getPointMedium());
                          tempList.clear();
                          saveProductToFile();
                      } else {
                          System.out.println("điểm đã được nhập");
                      }
                  }
              }
              tempList.clear();
              if (point == 5) {
                  {
                      main();
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

        StudentManagement.showStudent(studentList);

    }
    // ngày sinh
        public static String age(String meseage) {
            System.out.println(meseage);
            try {
                String date = scanner.nextLine();

                formatter.parse(date);
                return date;
            } catch (Exception e) {
                System.out.println("sai ngày sinh");
                return age(meseage);
            }
        }
// điểm
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
        System.out.println("1: nhập điểm hệ số 1.1");
        System.out.println("2: nhập điểm hệ số 1.2");
        System.out.println("3: nhập điểm hệ số 2");
        System.out.println("4: nhập điểm hệ số 3");
        System.out.println("5: về menu");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > 5 || num < 1) {
                System.out.println("điểm phải trong khoảng 0 --> 5");
                return point(me);
            }
            return num;
        } catch (Exception e) {
            System.out.println("ô điểm là một số");
            return choie(me);
        }
    }

    // xóa khoảng trống giới tính
    public static String removeWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }

    //hiển thị tên
    private static String validateName(String mess) {
        System.out.println(mess);
        try {
            String name = scanner.nextLine().trim().replaceAll("\\s+", " ");
            if (!namePattern.matcher(name).matches())
                throw new Exception("invalid name");
            String[] word = name.split(" ");
            StringBuilder result = new StringBuilder();
            for (String s : word) {
                result.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
            }

            return result.toString().trim();

        } catch (Exception e) {
            System.err.println("Trong tên phải là kí tự chữ và không quá dài");
            return validateName(mess);
        }
    }

    // xóa khoảng trống giới tính
    public static String deleteWrite(String name) {
        System.out.println(name);
        String newName = scanner.nextLine();
        return newName.replaceAll("\\s+", "").trim();

    }

}