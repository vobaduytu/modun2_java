import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("vlxx.csv"));
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.1.0" + " , " + "1.0.3.255" + " , " + "16777216" + " , " + "16778239" + "," + " CN" + " , " + "China" + "\n");
            bufferedWriter.write("1.0.4.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.8.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " CN" + " , " + "China" + "\n");
            bufferedWriter.write("1.0.16.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " JP" + " , " + "japan" + "\n");
            bufferedWriter.write("1.0.32.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia" + "\n");
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " AU" + " , " + "Australia"+"\n");
            bufferedWriter.write("1.0.0.0" + " , " + "1.0.0.255" + " , " + "16777216" + " , " + "16777471" + "," + " TL" + " , " + "Thailan"+"\n");

            bufferedWriter.close();
            FileReader fileReader = new FileReader("vlxx.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String value;
            while ((value = bufferedReader.readLine())!= null){
                String [] fileCSV=value.split(",");
                System.out.println(fileCSV[4]+ ":" + fileCSV[5]);
            }
            bufferedReader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
