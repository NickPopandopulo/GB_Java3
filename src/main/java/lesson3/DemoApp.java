package lesson3;

import java.io.File;
import java.io.IOException;

public class DemoApp {

    public static void main(String[] args) throws IOException {

        File dir = new File("filedir");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir,"demo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile().getName());

        System.out.println(file.getParent());

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        System.out.println(file.length());


    }
}
