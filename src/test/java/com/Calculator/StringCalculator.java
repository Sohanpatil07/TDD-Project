package com.Calculator;

import com.Calculator.exception.NegativeNumberException;
import com.Calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StringCalculator {

    private final CalculatorService calculatorService = new CalculatorService();



    @Test
    void testAddWithEmptyString() throws NegativeNumberException {
        assertEquals(0, calculatorService.add(""));
    }

    @Test
    void testAddWithOneNumber() throws NegativeNumberException {
        assertEquals(5, calculatorService.add("5"));
    }

    @Test
    void testAddWithTwoNumbers() throws NegativeNumberException {
        assertEquals(15, calculatorService.add("5,10"));
    }

    @Test
    void testAddWithNewLineDelimiter() throws NegativeNumberException {
        assertEquals(6, calculatorService.add("1\n2,3"));
    }

    @Test
    void testAddWithCustomDelimiter() throws NegativeNumberException {
        assertEquals(3, calculatorService.add("//;\n1;2"));
    }

    @Test
    void testAddWithNegativeNumbers() {
        NegativeNumberException exception = assertThrows(
                NegativeNumberException.class,
                () -> calculatorService.add("1,-2,-3")
        );
        assertEquals("Negative numbers not allowed: [-2, -3]", exception.getMessage());
    }


}
