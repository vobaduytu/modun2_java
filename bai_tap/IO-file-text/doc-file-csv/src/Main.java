import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("vlxx.txt"));
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.1.0" + " , " + "1.0.3.255" + " , " + "16777216" + " , " + "16778239" + "," + " CN" + " , " + "China" + "\n");
            bufferedWriter.write("1.0.4.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.8.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " CN" + " , " + "China" + "\n");
            bufferedWriter.write("1.0.16.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " JP" + " , " + "japan" + "\n");
            bufferedWriter.write("1.0.32.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia"+"\n");
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " TL" + " , " + "Thailan"+"\n");

            bufferedWriter.close();
            FileReader fileReader = new FileReader("vlxx.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String value;
            while ((value = bufferedReader.readLine())!= null){
                System.out.println(value);
            }
            bufferedReader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
