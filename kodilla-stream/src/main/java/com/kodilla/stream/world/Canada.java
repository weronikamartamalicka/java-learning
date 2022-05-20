package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Canada implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("99999999901263466365567890");
        return peopleQuantity;
    }
}
