package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Portugal implements PeopleCount{
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("263466353365567890");
        return peopleQuantity;
    }
}
