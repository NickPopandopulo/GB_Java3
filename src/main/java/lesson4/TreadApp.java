package lesson4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TreadApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        Thread thread1 = new Thread(new MyRunnable());
        thread.start();
        thread1.start();
        System.out.println("From " + Thread.currentThread().getName());
        Thread thread2 = new MyThread();
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From anoniumous " + Thread.currentThread().getName());
            }
        });
        thread3.start();


        accept(new List<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        });

        // анонимный класс умер. RIP

        Thread thread4 = new Thread(() -> System.out.println("From labda"));
        thread4.start();
        printDoubledString(string -> string + string, "testString");

        testDouble((s1, s2) -> s1 + " " + s2);


        //IntHolder intHolder = new IntHolder();
        AtomicInteger intHolder = new AtomicInteger(); //CAS - Compare and Swap
        intHolder.addAndGet(1);
        //intHolder = new AtomicInteger(10);
        int count = 1;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                intHolder.addAndGet(count); // ++i;\

                //intHolder.getAndIncrement(); //i++
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                intHolder.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(intHolder.get());







    }

    public static void printDoubledString(SimpleInterface simpleInterface, String string) {
        System.out.println(simpleInterface.doubleString(string));
    }

    private static void testDouble(DoubleParamInterface doubleParamInterface) {
        System.out.println(doubleParamInterface.concat("s1", "s2"));
    }

    public static void accept(List<String> list) {

    }


    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("From runnable" + Thread.currentThread().getName());
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("From thread " + Thread.currentThread().getName());
        }
    }

    private static class IntHolder {
        int integer;

        public IntHolder() {
            this.integer = 0;
        }

        public int getInteger() {
            return integer;
        }

        public void increment() {
            integer = integer + 1;
            //read variable
            //magic(math)
            //write
        }
    }


}
