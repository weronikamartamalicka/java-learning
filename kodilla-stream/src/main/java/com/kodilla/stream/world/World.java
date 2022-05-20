package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class World implements PeopleCount {

    private final List<List<PeopleCount>> worldList = new ArrayList<List<PeopleCount>>();

    public BigDecimal getPeopleQuantity() {

        return worldList.stream()
                .flatMap(list -> list.stream())
                .map(PeopleCount::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current));
    }
}
