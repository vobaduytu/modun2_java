import java.util.ArrayList;

public class ShowStudent {
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
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
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

            if (!student.statusPont1 && !student.statusPont2 && !student.statusPont3 && !student.statusPont4) {
                String s = String.valueOf(student.getPointMedium());
                s = "";
                System.out.format("%-10.4s |", s);

            } else {
                System.out.format("%-10.4s |", student.getPointMedium());
            }

            System.out.format("\n");
        }
    }
}

