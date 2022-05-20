package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Italy implements PeopleCount{

    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal("996554222467890");
        return peopleQuantity;
    }

}
