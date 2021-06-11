package lesson3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerializeApp {

    public static void main(String[] args) {
        Bike bike = new Bike("Canyon");
        bike.setSerialNo("1111111111111");

        System.out.println("Наш велосипед " + bike);
        byte[] bytes = null;

        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
        ) {
            objectOutputStream.writeObject(bike);
            bytes = byteArrayOutputStream.toByteArray();
            System.out.println("Наш сериализованный велосипед " + Arrays.toString(bytes));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        ) {
            Bike deserializedBike = (Bike) objectInputStream.readObject();
            System.out.println("Велосипед, считанный из файла " + deserializedBike);

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
