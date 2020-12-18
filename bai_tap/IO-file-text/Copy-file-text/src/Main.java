import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("demo.txt"));
            bw.write("1\n");
            bw.write("2\n");
            bw.write("3\n");
            bw.close();
            FileReader newFile = new FileReader("demo.txt");

            BufferedReader br = new BufferedReader(newFile);
            BufferedWriter bh = new BufferedWriter(new FileWriter("copy.txt"));

            String value;
            while ((value = br.readLine()) != null) {
                System.out.println(value);
                bh.write(value + "\n");
            }
            bh.close();

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File ko ton tai");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
