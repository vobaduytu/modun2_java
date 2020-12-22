import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("xnxx.txt");
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("xnxx.txt"));
            bw.write("1\n");
            bw.write("2\n");
            bw.write("4\n");
            bw.close();

            FileReader fileReader = new FileReader("xnxx.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String value;

            int sum = 0;
            while ((value = br.readLine()) != null) {

                System.out.println(value);
                int valueOut = Integer.parseInt(value);
                sum += valueOut;
            }
            br.close();
            System.out.println("Tong: "+sum);

        } catch (NumberFormatException e) {
            System.out.println("loi so hoc");
        } catch (ArithmeticException e) {
            System.out.println("khong phai so");
            System.out.println("khong phai so-----");
        } catch (FileNotFoundException e) {
            System.out.println("phai khong ton tai");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
