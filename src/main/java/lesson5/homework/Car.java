package lesson5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static final CountDownLatch startLatch;
    private static final CountDownLatch finishLatch;
    private static final CyclicBarrier barrier;
    private static boolean isFirstAtFinish = true;

    static {
        CARS_COUNT = 0;
        startLatch = MainClass.startLatch;
        finishLatch = MainClass.finishLatch;
        barrier = new CyclicBarrier(MainClass.CARS_COUNT);
    }

    private final Race race;
    private final int speed;
    private final String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep((long) (500 + Math.random() * 800));
            barrier.await(); // ждем MainClass.CARS_COUNT машин

            System.out.println(this.name + " готов");
            startLatch.countDown(); // пропускаем CARS_COUNT машин
            startLatch.await();     // ждем CARS_COUNT машин
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        // в предложенном к заданию коде почему-то не было написано сделать вывод победителя,
        // а в примере выполнения кода этот вывод есть
        if (isFirstAtFinish) {
            isFirstAtFinish = false;
            System.out.println(this.name + " — WIN!");
        }

        finishLatch.countDown();
    }
}
