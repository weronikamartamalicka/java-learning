package com.kodilla.good.paterns.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final List<PeopleCount> listOfCountries = new ArrayList<>();

    public void addCountry(PeopleCount country) {
        listOfCountries.add(country);
    }

    public List<PeopleCount> getListOfCountries() {
        return new ArrayList<>(listOfCountries);
    }
}

