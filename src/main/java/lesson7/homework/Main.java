package lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        start(TestClass.class);
    }

    public static void start(Class<?> clazz) {

        List<Method> list = new LinkedList<>();
        Method beforeMethod = null;
        Method afterMethod = null;

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (list.contains(method)) {
                    throw new RuntimeException("More than one method with annotation @BeforeSuite");
                }
                beforeMethod = method;
            }

            if (method.getAnnotation(Test.class) != null) {
                list.add(method);
            }

            if (method.getAnnotation(AfterSuite.class) != null) {
                if (list.contains(method)) {
                    throw new RuntimeException("More than one method with annotation @AfterSuite");
                }
                afterMethod = method;
            }
        }

        list.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
        list.add(0, beforeMethod);
        list.add(list.size(), afterMethod);

        for (Method method : list) {
            try {
                method.invoke(clazz.getConstructor().newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }
}
