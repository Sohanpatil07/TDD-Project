package com.Calculator.service;

import com.Calculator.exception.NegativeNumberException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

    public int add(String numbers) throws NegativeNumberException {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                negativeNumbers.add(num);
            }
            sum += num;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
