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


}
