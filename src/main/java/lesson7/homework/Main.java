package lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        start(TestClass.class);
    }

    public static void start(Class<?> clazz) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;

        Map<Integer, List<Method>> map = new TreeMap<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (map.containsKey(MIN_PRIORITY - 1)) {
                    throw new RuntimeException("More than one method with annotation @BeforeSuite");
                }
                map.put(MIN_PRIORITY - 1, List.of(method));
            }

            if (method.getAnnotation(Test.class) != null) {
                int priority = method.getAnnotation(Test.class).priority();
                List<Method> list = map.getOrDefault(priority, new ArrayList<>());
                list.add(method);
                map.put(priority, list);
            }

            if (method.getAnnotation(AfterSuite.class) != null) {
                if (map.containsKey(MAX_PRIORITY + 1)) {
                    throw new RuntimeException("More than one method with annotation @AfterSuite");
                }
                map.put(MAX_PRIORITY + 1, List.of(method));
            }
        }

        for (Integer priority : map.keySet()) {
            List<Method> list = map.get(priority);
            for (Method method : list) {
                try {
                    method.invoke(clazz.newInstance());
//                    method.invoke(new TestClass());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
