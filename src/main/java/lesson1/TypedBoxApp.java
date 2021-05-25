package lesson1;

import java.util.Map;

public class TypedBoxApp {

    //T - type
    //E - element
    //K - key
    //V - value
    //S, U, V ....

    //Type Erasure

    public static void main(String[] args) {
        TypedBox<Integer> box1 = new TypedBox<>(42);
        TypedBox<Integer> box2 = new TypedBox<>(195);

        int sum = box1.getObject() + box2.getObject();
        System.out.println(sum);

        TypedBox<String> stringTypedBox = new TypedBox<>("195");

        box1.showType();
        stringTypedBox.showType();

        TypedBox<SimpleBox> simpleBoxTypedBox = new TypedBox<>(new SimpleBox("0"));

        TwoTypedBox<Integer, String> twoTypedBox1 = new TwoTypedBox<>(42, "195");
        TwoTypedBox<Integer, Integer> twoTypedBox2 = new TwoTypedBox<>(42, 195);
        twoTypedBox1.showTypes();
        twoTypedBox2.showTypes();


    }
}
