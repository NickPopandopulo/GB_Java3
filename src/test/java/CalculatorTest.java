import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import lesson6.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    private static Stream<Arguments> substractionSource() {
        List<Arguments> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int result = a - b;
            list.add(Arguments.arguments(a, b ,result));
        }
        return list.stream();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Перед всеми");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("После всех");
    }

    @BeforeEach
    void init() {
        System.out.println("Создаем новый каалькулятор");
        calculator = new Calculator();
    }

    @AfterEach
    void destruct() {
        System.out.println("Подчистили ресурсы");
    }

    @CsvSource({
            "1, 2, 3",
            "10,15, 25"
    })
    @DisplayName("Проверяет корректность сложения")
    @ParameterizedTest
    void testAddition(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.sum(a, b), "Sum should be " + result);
    }

    @MethodSource("substractionSource")
    @ParameterizedTest
    void testSubstraction(int a, int b, int result) {
        assertEquals(result, calculator.minus(a, b));
    }

    @Test
    @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() {
        assertEquals(9, calculator.lazySum(3, 6));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.div(4,0));
        assertThrows(ArithmeticException.class, () -> calculator.div(8,0));
    }


}
