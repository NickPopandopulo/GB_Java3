package lesson3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class BufferedreadApp {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        Arrays.fill(bytes, (byte) 65);

        File file = new File("demo.txt");

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            for (byte aByte : bytes) {
                bufferedOutputStream.write(aByte);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ) {
            int x;
            while ((x = bufferedInputStream.read()) != -1) {
                System.out.println(x);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
