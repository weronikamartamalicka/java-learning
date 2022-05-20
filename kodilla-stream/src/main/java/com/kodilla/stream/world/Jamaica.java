package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Jamaica implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("901263466365567890");
        return peopleQuantity;
    }
}
