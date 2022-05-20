package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Chile implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("9901263466365567890");
        return peopleQuantity;
    }
}
