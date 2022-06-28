package com.kodilla.good.paterns.spring.calculator;

import org.springframework.stereotype.Service;

@Service
public class Display {

    public void displayValue(double val) {
        System.out.println(val);
    }
}
