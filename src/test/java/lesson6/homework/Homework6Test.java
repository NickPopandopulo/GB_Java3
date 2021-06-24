package lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class Homework6Test {

    private static Stream<Arguments> source1ArraysWithFour() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 1}, new int[]{4, 3, 2, 1}),
                Arguments.arguments(new int[]{2, 1}, new int[]{3, 4, 2, 1}),
                Arguments.arguments(new int[]{}, new int[]{4, 3, 4}),
                Arguments.arguments(new int[]{}, new int[]{4})
        );
    }

    private static Stream<Arguments> source2ArraysWithFourAndOne() {
        return Stream.of(
                Arguments.arguments(false, new int[]{1, 2, 3, 4}),
                Arguments.arguments(false, new int[]{1}),
                Arguments.arguments(false, new int[]{4}),
                Arguments.arguments(true, new int[]{1, 1, 4, 4}),
                Arguments.arguments(false, new int[]{})
        );
    }

    @DisplayName("Тест № 1 для метода № 1. Проверить массивы хотя бы с одной 4-кой")
    @ParameterizedTest
    @MethodSource("source1ArraysWithFour")
    void test1ArraysWithFour(int[] expectedArray, int[] actualArray) {
        int[] result = Homework6.getArrayAfterFour(actualArray);
        Assertions.assertArrayEquals(expectedArray, result, "It should be " + Arrays.toString(result));
    }

    @DisplayName("Тест № 2 для метода № 1. Проверить массивы без 4-ки")
    @Test
    void test1ArraysWithoutFour() {
        Assertions.assertThrows(RuntimeException.class, () -> Homework6.getArrayAfterFour(1, 2, 3));
        Assertions.assertThrows(RuntimeException.class, () -> Homework6.getArrayAfterFour());
    }

    @DisplayName("Тест № 1 для метод № 2. Проверить массивы на наличие хотя бы одной 1 и одной 4")
    @ParameterizedTest
    @MethodSource("source2ArraysWithFourAndOne")
    void test2ArraysWithFourAndOne(boolean expected, int[] actualArray) {
        boolean result = Homework6.containsOneAndFour(actualArray);
        Assertions.assertEquals(expected, result);
    }


}
