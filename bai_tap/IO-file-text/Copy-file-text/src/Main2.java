import java.io.*;

public class Main2 {


    public static void main(String[] args) {
        BufferedWriter bufferedWriter;
        {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("xnxx.txt"));
                bufferedWriter.write("dat \n");
                bufferedWriter.write("Tu \n");
                bufferedWriter.write("Thang \n");
                bufferedWriter.write("Thinh \n");
                bufferedWriter.close();

                FileReader fileReader = new FileReader("xnxx.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                BufferedWriter bh = new BufferedWriter(new FileWriter("copy2.txt"));

           String value;
           while ((value = bufferedReader.readLine()) != null){
               System.out.println(value);
               bh.write(value);
           }
                bh.close();
                bufferedReader.close();

            } catch (FileNotFoundException e){
                System.out.println("file khong ton tai");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
