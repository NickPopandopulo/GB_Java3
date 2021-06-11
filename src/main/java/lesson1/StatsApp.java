package lesson1;

public class StatsApp {

    public static void main(String[] args) {
        Stats<Integer> statsInt = new Stats<>(1, 2, 3, 4, 5);
        Stats<Integer> statsInt2 = new Stats<>(1, 2, 3, 4, 5);
        Stats<Integer> statsInt3 = new Stats<>(1, 2, 3, 4, 5, 7, 8);

        System.out.println(statsInt.avg());

        Stats<Double> statsDouble = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);

        System.out.println(statsDouble.avg());



        System.out.println(statsInt.sameAvg(statsInt2));
        System.out.println(statsInt.sameAvg(statsInt3));
        System.out.println(statsInt.sameAvg(statsDouble));
    }
}
