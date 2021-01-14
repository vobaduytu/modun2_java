import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main() throws IOException {

        Scanner input = new Scanner(System.in);
        try {
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
                        ShowStudent.showStudent(StudentManagement.studentList);
                        break;
                    case 2:

                        boolean check = true;
                        while (check){
                            check = false;
                        System.out.println("1.nhập tên học viên để thêm");
                        System.out.println("2.về menu");
                        int chonSua = Validate.validateChonMenu("nhập lựa chọn");
                        if (chonSua == 1) {
                            String newName = Validate.validateName("nhập tên học viên");
                            while (newName.length() == 0) {
                                System.out.println("yêu cầu nhập tên");
                                newName = Validate.validateName("nhập tên học viên(bắt buộc)");
                            }

                            String newSex = Validate.removeWrite("nhập giới tính");

                            while (true) {
                                if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                                    break;
                                System.out.println("bạn nhập sai giới tính:");
                                System.out.println("nhập lại:");
                                newSex = Validate.removeWrite("nhập giới tính");
                            }

                            String newAge = Validate.age("nhập ngày sinh");

                            StudentManagement.addStudent(newName, newSex, newAge);
                            System.out.println("---->thêm học viên thành công");
                           check=true;
                        }
                        if (chonSua == 2) {
                            main();
                        }}
                    case 3:
                        StudentManagement.informationStudent();
                        break;
                    case 4:
                        StudentManagement.removeStudent();
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
                        System.exit(0);
                    default:
                        System.err.println("nhập sai - chọn lại");
                        break;
                }
            }
            while (true);
        } catch (Exception e) {
            System.err.println("chọn lại:");
            main();
        }
    }
}
