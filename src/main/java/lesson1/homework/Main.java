package lesson1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * <p>
 * 2. Написать метод, который преобразует массив в ArrayList;
 * <p>
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
 * нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес
 * яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в
 * compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
 * сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
 * фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в
 * другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main {

    public static void main(String[] args) {

        // --- Задание 1 ---
        String[] arrayStr = {"1", "2", "3"};
        swapTwoElements(arrayStr, 0, 2);
        System.out.println(Arrays.toString(arrayStr) + "\n");

        // --- Задание 2 ---
        List<String> arrayList = convertToArrayList(arrayStr);
        System.out.println(arrayList + "\n");

        // --- Задание 3 ---
        // Коробка с яблоками № 1
        Box<Apple> appleBox = new Box<>(new ArrayList<>() {{
            for (int i = 0; i < 15; i++) add(new Apple());
        }});
        System.out.println("Коробка № 1 с яблоками весит " + appleBox.getWeight());

        // Коробка с апельсинами № 1
        Box<Orange> orangeBox = new Box<>(new ArrayList<>() {{
            for (int i = 0; i < 10; i++) add(new Orange());
        }});
        System.out.println("Коробка № 1 с апельсинами весит " + orangeBox.getWeight() + "\n");

        // Проверка на вес
        System.out.println("Их веса равны? — " + appleBox.compare(orangeBox) + "\n");

        // Коробка с яблоками № 2
        Box<Apple> appleBox2 = new Box<>(new ArrayList<>() {{
            for (int i = 0; i < 5; i++) add(new Apple());
        }});
        System.out.println("Коробка № 2 с яблоками весит " + appleBox2.getWeight());


        System.out.println("Пересыпаем из коробки № 1 в коробку № 2...");
        appleBox.pourInto(appleBox2);
        System.out.println("Коробка № 1 с яблоками весит " + appleBox.getWeight());
        System.out.println("Коробка № 2 с яблоками весит " + appleBox2.getWeight());

    }

    /**
     * Задание 1. Меняет местами два элемента массива произвольного ссылочного типа
     */
    private static <T> void swapTwoElements(T[] array, int i, int j) {
        try {
            if (array[i].equals(array[j])) return;

            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: Недопустимый индекс в методе changeTwoElements");
        }
    }

    /**
     * Задание 2. Преобразование массива в ArrayList
     */
    private static <T> List<T> convertToArrayList(T[] array) {
        return Arrays.stream(array).collect(Collectors.toCollection(ArrayList::new));
    }

}
