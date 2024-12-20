package com.Calculator.controller;
import com.Calculator.exception.NegativeNumberException;
import com.Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public int add(@RequestParam(defaultValue = "") String numbers) throws NegativeNumberException {
        return calculatorService.add(numbers);
    }
}
