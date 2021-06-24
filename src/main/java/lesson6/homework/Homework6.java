package lesson6.homework;

import java.util.Arrays;

/**
 * 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен
 * вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней
 * четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * <p>
 * 3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */

public class Homework6 {

    /**
     * Получение подмассива после 4-ки в массиве
     */
    public static int[] getArrayAfterFour(int... array) {
        int index = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                index = i + 1;
                break;
            }
        }

        if (index == -1) throw new RuntimeException("The array doesn't contain value 4");

        return Arrays.copyOfRange(array, index, array.length);
    }

    /**
     * Проверка на наличие хотя бы одной 1 и одной 4
     */
    public static boolean containsOneAndFour(int... array) {
        for (int e : array) {
            if (e != 1 && e != 4) return false;
        }

        return Arrays.stream(array)
                .filter(e -> e == 1 || e == 4)
                .distinct()
                .sum() == 5;
    }


}
