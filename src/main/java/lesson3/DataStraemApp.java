package lesson3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStraemApp {

    public static void main(String[] args) {
        File file = new File("demo.txt");

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF("writeUTF");
            dataOutputStream.writeInt(42);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
