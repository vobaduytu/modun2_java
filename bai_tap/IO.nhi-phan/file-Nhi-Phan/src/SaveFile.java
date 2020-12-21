import java.io.*;

public class SaveFile {

    public static void writeProductToFile(Object object,String fileName) throws IOException {
        FileOutputStream fos=new FileOutputStream(new File(fileName));
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }
    public static Object readProductToFile(String newFile ) throws IOException, ClassNotFoundException {
             File file = new File(newFile);
             if (file.exists()== false){
                 return null;
             }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fis);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj ;
    }
}
