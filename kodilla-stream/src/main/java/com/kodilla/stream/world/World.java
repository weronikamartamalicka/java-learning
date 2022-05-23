package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class World implements PeopleCount {

    private final List<Continent> continentList = new ArrayList<>();

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }

    public List<Continent> getContinentList() {
        return new ArrayList<>(continentList);
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(PeopleCount::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum,current) -> sum = sum.add(current));

    }
}
