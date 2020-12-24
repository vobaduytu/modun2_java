import java.io.IOException;
import java.util.ArrayList;

public class File {
    public static void saveProductToFile() throws IOException {
        SaveFile.writeProductToFile((tên mảng), "student.data");
    }
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
}
