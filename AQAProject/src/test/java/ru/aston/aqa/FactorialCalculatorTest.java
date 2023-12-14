package ru.aston.aqa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "5, 120",
            "10, 3628800"
    })
    void testFactorialPositive(int input, long expected) {
        assertEquals(expected, FactorialCalculator.factorial(input));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, FactorialCalculator.factorial(0),
                "Факториал нуля должен быть равен 1");
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1),
                "Факториал отрицательного числа должен вызывать исключение");
    }

    @Test
    void testFactorialLargeNumber() {
        assertDoesNotThrow(() -> FactorialCalculator.factorial(20),
                "Факториал большого числа должен быть вычислен без вызова исключения");
    }

    @Test
    void testFactorialOverflow() {
        assertThrows(ArithmeticException.class, () -> FactorialCalculator.factorial(200),
                "Факториал очень большого числа должен вызвать исключение из-за переполнения");
    }

}
