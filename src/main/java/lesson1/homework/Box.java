package lesson1.homework;

import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
        
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    /**
     * Вес текущей коробки
     */
    public float getWeight() {
        return fruits.size() *
                (fruits.isEmpty() ?
                        0f :
                        fruits.stream().findFirst().get().getWeight());
    }

    /**
     * Сравнение коробок с фруктами по весу
     */
    public boolean compare(Box<? extends Fruit> that) {
        return this.getWeight() == that.getWeight();
    }

    /**
     * Пересыпаем фрукты одного типа из текущей коробки в anotherBox
     */
    public void pourInto(Box<T> anotherBox) {
        anotherBox.getFruits().addAll(fruits);
        fruits.clear();
    }

}
