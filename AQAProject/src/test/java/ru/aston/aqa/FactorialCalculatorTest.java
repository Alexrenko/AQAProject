package ru.aston.aqa;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FactorialCalculatorTest {

    @Test(dataProvider = "positiveNumbers")
    public void testFactorialPositive(int input, long expected) {
        assertEquals(FactorialCalculator.factorial(input), expected);
    }

    @DataProvider(name = "positiveNumbers")
    public Object[][] positiveNumbers() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {5, 120},
                {10, 3628800}
        };
    }

    @Test
    public void testFactorialZero() {
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-1);
    }

    @Test
    public void testFactorialLargeNumber() {
        long result = FactorialCalculator.factorial(20);
        assertTrue(result > 0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testFactorialOverflow() {
        FactorialCalculator.factorial(200);
    }

}
