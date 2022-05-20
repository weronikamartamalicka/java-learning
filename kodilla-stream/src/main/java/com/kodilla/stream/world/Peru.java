package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Peru implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("01263466365567890");
        return peopleQuantity;
    }
}
