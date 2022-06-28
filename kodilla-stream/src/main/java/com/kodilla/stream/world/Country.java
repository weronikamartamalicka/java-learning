package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country implements PeopleCount {

    private final String name;
    private final BigDecimal peopleQuantity;

    public Country(String name, BigDecimal peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        //BigDecimal peopleQuantity = new BigDecimal("9999999966901263466365567890");
        return peopleQuantity;
    }

}
