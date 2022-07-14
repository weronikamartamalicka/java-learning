package com.kodilla.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {

    public double add(double x, double y) {
        return x + y;
    }
    public double sub(double x, double y) {
        return x - y;
    }
    public double mul(double x, double y) {
        return x * y;
    }
    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return x / y;
    }

    public BigDecimal factorial(BigDecimal x) {
        if(x.compareTo(BigDecimal.ONE) > 0) {
            return x.multiply(factorial(x.subtract(BigDecimal.ONE)));
        } else if(x.equals(BigDecimal.ZERO) || x.equals(BigDecimal.ONE)) {
            return new BigDecimal(1);
        } else {
            throw new ArithmeticException("Factorial argument is negative");
        }
    }
}