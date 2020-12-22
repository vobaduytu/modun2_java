import java.io.*;

public class CoppyBinary {
    public static void main(String[] args) throws IOException {
        FileOutputStream fis = new FileOutputStream(new File("binary.data"));
        fis.write(101);
        fis.write(10001);
        fis.write(1010101010);
        fis.close();
        FileReader fileReader = new FileReader("binary.data");

       FileOutputStream fileOutputStream = new FileOutputStream(new File("CoppyBinary"));

        int value;
        while ((value = fileReader.read())!= -1){
            System.out.println(value);
            fileOutputStream.write(value);
        }
        fileReader.close();
        fileOutputStream.close();

    }

}
