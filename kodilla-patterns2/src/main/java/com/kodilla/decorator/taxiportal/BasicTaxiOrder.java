package com.kodilla.decorator.taxiportal;

import java.math.BigDecimal;

public class BasicTaxiOrder implements TaxiOrder{
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5.0);
    }

    @Override
    public String getDescription() {
        return "Drive a course";
    }
}
