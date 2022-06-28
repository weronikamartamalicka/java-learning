package com.kodilla.good.paterns.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    Calculator calculator;
    @Test
    public void testCalculations() {
        double add = calculator.add(10,5);
        double sub = calculator.sub(10,5);
        double mul = calculator.mul(10,5);
        double div = calculator.div(10,5);

        assertEquals(15, add);
        assertEquals(5, sub);
        assertEquals(50, mul);
        assertEquals(2, div);
    }
}
