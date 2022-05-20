package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Spain implements PeopleCount {
    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("99655422245467890");
        return peopleQuantity;
    }
}
