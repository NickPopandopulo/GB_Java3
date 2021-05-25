package lesson1;

public class SimpleBoxApp {
    //int -> Integer (boxing)
    //Integer -> int (unboxing)

    public static void main(String[] args) {
       //попробуем сложить в коробку чиселки и потом эти чиселки сложить
        SimpleBox box1 = new SimpleBox(42);
        SimpleBox box2 = new SimpleBox(195);
        SimpleBox box3 = new SimpleBox("195");

        int sum = (Integer) box1.getObject() + (Integer) box2.getObject();
        System.out.println(sum);

        try {
            int sum2 = (Integer) box1.getObject() + (Integer) box3.getObject();
            System.out.println(sum2);
        } catch (ClassCastException cce) {
            System.out.println("Один из объектов не инт");
        }

        if (box1.getObject() instanceof Integer && box3.getObject() instanceof Integer) {
            int sum2 = (Integer) box1.getObject() + (Integer) box3.getObject();
            System.out.println(sum2);
        } else {
            System.out.println("Один из объектов не инт");
        }

    }
}
