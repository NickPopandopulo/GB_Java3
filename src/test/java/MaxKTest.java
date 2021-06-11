import java.util.List;

import lesson6.LoggerApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MaxKTest {

    @Test
    void maxKTestMoreThanK () {
        List<String> actual = LoggerApp.maxK();
        assertNotNull(actual);
        assertEquals(7, actual.size());
        assertEquals(actual, List.of("14","15","16","17","18","19","20"));
    }
}
