import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FunctionPhonebook {

    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Phonebook> phonebookArrayList = new ArrayList<>();
    public static int size = 0;
    private static final String fileName = "data/contacts.csv";

    static {
        new File("data/").mkdirs();
    }

    public static void addPhone(String phone, String name, String sex, String address, String group, String birthday, String email) throws IOException {
        phonebookArrayList.add(new Phonebook(phone, name, sex, address, group, birthday, email));
        size++;
    }

    public static void showPhonebook() {
        for (Phonebook phonebook : phonebookArrayList) {
            System.out.println("số điện thoại: " + phonebook.getPhone());
            System.out.println("tên: " + phonebook.getName());
            System.out.println("giới tính: " + phonebook.getSex());
            System.out.println("địa chỉ: " + phonebook.getAddress());
            System.out.println("nhóm: " + phonebook.getGroup());
            System.out.println("ngày sinh: " + phonebook.getBirthday());
            System.out.println("email: " + phonebook.getEmail());
            System.out.println("----------------------------------------");
        }
    }

    public static void editPhonebook() throws IOException {
        String phone = Validate.validateTel("nhập số điện thoại muốn cập nhật");
        Phonebook phonebook = getNewPhone(phone);
        if (phonebook == null) {
            System.out.println("không tìm thấy số điện thoại");
            System.out.println("1.nhập lại");
            System.out.println("2. về menu");
            int chon = Integer.parseInt(scanner.nextLine());
            if (chon == 1) {
                editPhonebook();
            }
            if (chon == 2) {
                MenuPhonebook.main();
            }
        }
        if (phonebook != null) {
            System.out.println("1.sửa số điện thoại");
            System.out.println("2.tên");
            System.out.println("3.sửa giới tính");
            System.out.println("4.sửa địa chỉ");
            System.out.println("5. sửa email");
            System.out.println("6. sửa nhóm");
            System.out.println("7. sửa ngày sinh");
            System.out.println("8. về menu");
            int chon = Validate.validateChon("- nhập lựa chọn");
            try {
                if (chon == 1) {
                    String newPhones = Validate.validateTel("nhập số điện thoại");
                    phonebook.setPhone(newPhones);
                }
                if (chon == 2) {
                    String name = Validate.validateName("nhập tên");
                    phonebook.setName(name);
                }
                if (chon == 3) {
                    String name = Validate.validateName("nhập giới tính");
                    phonebook.setSex(name);
                }
                if (chon == 4) {
                    String name = Validate.validateName("nhập giới tính");
                    phonebook.setAddress(name);
                }
                if (chon == 5) {
                    String name = Validate.validateName("nhập giới tính");
                    phonebook.setEmail(name);
                }
                if (chon == 6) {
                    String name = Validate.validateName("nhập giới tính");
                    phonebook.setGroup(name);
                }
                if (chon == 8) {
                    MenuPhonebook.main();
                }
                if (chon == 7) {
                    String birthday = Validate.age("nhập ngày sinh");
                    phonebook.setBirthday(birthday);
                }

            } catch (Exception e) {
                System.out.println("nhập sai");
            }

        }

    }

    //    check phone
    public static Phonebook getNewPhone(String num) {
        for (Phonebook phonebook : phonebookArrayList) {
            if (phonebook.getPhone().equals(num))
                return phonebook;
        }
        return null;
    }

    public static void removePhonebook() throws IOException {
        String phone = Validate.validateTel("nhập số điện thoại muốn xóa");
        Phonebook phonebook = getNewPhone(phone);
        if (phonebook == null) {
            System.out.println("không tìm thấy số điện thoại");
            System.out.println("1.nhập lại");
            System.out.println("2. về menu");
            int chon = Integer.parseInt(scanner.nextLine());
            if (chon == 1) {
                removePhonebook();
            }
            if (chon == 2) {
                MenuPhonebook.main();
            }
        }
        if (phonebook != null) {
            System.out.println("1. xóa ");
            System.out.println("nhập bất kì để thoát");
            try {
                int chon = Integer.parseInt(scanner.nextLine());
                if (chon == 1) {
                    phonebookArrayList.remove(phonebook);
                }
            } catch (NumberFormatException e) {
                MenuPhonebook.main();
            }

        }
    }

    public static void seachPhonebook() throws IOException {
        String phone = Validate.validateTel("nhập số điện thoại muốn tìm");
        Phonebook phonebook = getNewPhone(phone);
        if (phonebook == null) {
            System.out.println("không tìm thấy số điện thoại");
            System.out.println("1.nhập lại");
            System.out.println("2. về menu");
            int chon = Integer.parseInt(scanner.nextLine());
            if (chon == 1) {
                seachPhonebook();
            }
            if (chon == 2) {
                MenuPhonebook.main();
            }
        }
        if (phonebook != null) {
            System.out.println(phonebook);
        }
    }

    public static void saveList() {
        try (PrintWriter fileWriter = new PrintWriter(fileName)) {
            for (Phonebook phonebook : phonebookArrayList) {
                fileWriter.println(phonebook.getCVS());
            }
            System.out.println("Lưu CVS thành công");
        } catch (IOException e) {
            System.out.println("Lưu CVS thất bại: " + e.getMessage());
        }
    }

    public static ArrayList<Phonebook> readList() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            ArrayList<Phonebook> users = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String phone = fields[0];
                String name = fields[1];
                String sex = fields[2];
                String address = fields[3];
                String group = fields[4];
                String birthday = fields[5];
                String email = fields[6];
                Phonebook phonebook = new Phonebook(phone, name, sex, address, group, birthday, email);
                users.add(phonebook);
            }
            System.out.println("Đọc SVC thành công.");
            return users;
        } catch (FileNotFoundException e) {
            System.out.println("Đọc CVS thất bại: " + e.getMessage());
            return null;
        }
    }



    public static void saveToCVS() {
        saveList();
    }

    public static void readFromCVS() {
        ArrayList<Phonebook> users = readList();
        if (users != null)
            phonebookArrayList = users;
    }


}
