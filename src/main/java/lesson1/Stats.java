package lesson1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Stats<T extends Number> {
    private static final double EPSILON = 0.00001;
    //private static final T CONSTANT = 10; низзя
    private final T[] numbers;

    public Stats(T... numbers) {
        this.numbers = numbers;
    }

    public T[] getNumbers() {
        return numbers;
    }

    double avg() {
        double sum = 0.0;
        for (int i=0; i< numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        return sum/numbers.length;
    }

    public boolean sameAvg(Stats<? extends Number> another) {
        return Math.abs(this.avg() - another.avg()) < EPSILON;
    }

    public List<? extends T> getElements() {
        //T t = new T(); низзя
        return Arrays.asList(numbers);
    }

   /* public static T getSmth() {
        return new T();
    }*/ //низзя


    //PECS - Producer Extends Consumer Super
}
