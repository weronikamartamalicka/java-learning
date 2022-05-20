package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Brazil implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("9999999966901263466365567890");
        return peopleQuantity;
    }

}
