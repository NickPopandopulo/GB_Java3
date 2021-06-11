package lesson6;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerApp {

    private static final Logger LOGGER = LogManager.getLogger(LoggerApp.class);
    public static void main(String[] args) {
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
        LOGGER.warn("Warn");
        LOGGER.info("Info");
        LOGGER.debug("Debug");
        LOGGER.trace("Trace");

        maxK();

    }
    //Последние 100 строк
    //Найти K максимальных элементов в коллекции
    // 1,2,3,4,5,5 ->
    // k = 2 = 5,5
    //k = 3 = 5,4,5
    public static List<String> maxK() {
        List<String> list = new LinkedList<>();
        int maxSize = 7;//Хотим 100 последних (у нас 7)

        //В файле 1000 строк (у нас 20)
        for (int i = 1; i < 21; i++) {
            String s = String.valueOf(i);
            list.add(s);
            if (list.size() > maxSize) {
                list.remove(0);
            }
           LOGGER.debug("List is {} for i = {}", list, i);
        }
        return list;
    }




}
