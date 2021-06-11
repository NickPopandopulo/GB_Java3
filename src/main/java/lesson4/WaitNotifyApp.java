package lesson4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaitNotifyApp {

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        int listSizeWrite = 20;
        int listSizeread = 10;
        List<String> list = new CopyOnWriteArrayList<>();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker) {
                    while (list.size() >= listSizeWrite) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    list.add("string");
                    //locker.notifyAll();
                }

            }
        });


        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker) {
                    String first = list.remove(0);
                    System.out.println(first);
                    if (list.size() == listSizeread) {
                        locker.notifyAll();
                    }
                }

            }
        });

        consumer.start();
        producer.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("List.size = " + list.size());
        }

    }
}
