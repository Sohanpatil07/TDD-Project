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


}
