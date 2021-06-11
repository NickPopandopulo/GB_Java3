package lesson3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemoApp {

    public static void main(String[] args) {
        String str = "My String";
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("demo.txt"))) {
            fileOutputStream.write(str.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("demo.txt")) {
            byte[] bytes = new byte[100];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));

        } catch (IOException ex) {
            ex.printStackTrace();
        }




       /* byte[] bytes = {65, 66, 67};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int x;
        byteArrayInputStream.
        while ((x = byteArrayInputStream.read()) != -1) {
            System.out.println(x);
        }*/

    }

}
