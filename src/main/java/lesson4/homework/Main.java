package lesson4.homework;

public class Main {

    private static final Object lock = new Object();
    private static final char[] chars = {'A','B','C','D','E'};
    private static final int amountRepeat = 5;
    private static int currentIndex = 0;

    public static void main(String[] args) {
        for (int i = 0; i < chars.length; i++) {
            int indexOfChars = i;
            new Thread(() -> print(chars[indexOfChars])).start();
        }
    }

    private static void print(char letter) {
        synchronized (lock) {
            for (int i = 0; i < amountRepeat; i++) {
                while (!(chars[currentIndex] == letter)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(letter);
                if (++currentIndex == chars.length) {
                    System.out.print('|');
                    currentIndex = 0;
                }
                lock.notifyAll();
            }
        }
    }

}
