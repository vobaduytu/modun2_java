import java.io.IOException;
import java.util.Scanner;

public class MenuPhonebook {
    public static void main() throws IOException {

        Scanner input = new Scanner(System.in);
        try {
            boolean cont = true;
            do {
                System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
                System.out.println("chọn chức năng theo số (để tiếp tục):");
                System.out.println("1: Xem danh sách");
                System.out.println("2: Thêm mới");
                System.out.println("3: cập nhật");
                System.out.println("4: xóa");
                System.out.println("5: tìm kiếm");
                System.out.println("6: đọc từ flie");
                System.out.println("7: ghi vào file");
                System.out.println("8: thoát");
                System.out.println("chọn chức năng: |");
                int chon = input.nextInt();

                switch (chon) {
                    case 1:
                        FunctionPhonebook.showPhonebook();
                        break;
                    case 2:
                        String newPhone = Validate.validateTel("nhập số điện thoại");

                        String newName = Validate.validateName("nhập tên");
                        String newSex = Validate.removeWriteSex("nhập giới tính");

                        while (true) {
                            if (newSex.equals("Nam") || newSex.equals("Nu") || newSex.equals("nam") || newSex.equals("nu"))
                                break;
                            System.out.println("bạn nhập sai giới tính:");
                            System.out.println("nhập lại:");
                            newSex = Validate.removeWriteSex("nhập giới tính");
                        }
                        String newAddress = Validate.validateName("nhập địa chỉ");
                        String newGroup = Validate.validateName("nhập nhóm danh bạ");
                        String newBirthday = Validate.age("nhập ngày sinh");
                        String newEmail = Validate.validateEmail("nhập email");

                        FunctionPhonebook.addPhone(newPhone, newName, newSex, newAddress, newGroup,newBirthday, newEmail);
                        break;
                    case 3:
                        FunctionPhonebook.editPhonebook();
                        break;
                    case 4:
                        FunctionPhonebook.removePhonebook();
                        break;
                    case 5:
                        FunctionPhonebook.seachPhonebook();
                        break;
                    case 6:
                        FunctionPhonebook.readFromCVS();
                        break;
                    case 7:
                        FunctionPhonebook.saveToCVS();
                        break;
                    case 8:
                        System.exit(0);
                }


            }
            while (cont);
        } catch (Exception e) {
            System.err.println("chọn lại:");
            main();
        }
    }
}
