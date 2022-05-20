package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Cuba implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("999567890");
        return peopleQuantity;
    }
}
