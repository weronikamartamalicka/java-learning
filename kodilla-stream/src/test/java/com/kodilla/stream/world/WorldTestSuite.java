package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.math.BigDecimal;

public class WorldTestSuite {


    @Test
    public void testGetPeopleQuantity() {


        Continent listOfEuropeCountries = new Continent();

        listOfEuropeCountries.addCountry(new Country("Italy", new BigDecimal("996554222467890")));
        listOfEuropeCountries.addCountry(new Country("Spain", new BigDecimal("99655422245467890")));
        listOfEuropeCountries.addCountry(new Country("Portugal", new BigDecimal("263466353365567890")));

        Continent listOfAmericaNorthCountries = new Continent();

        listOfAmericaNorthCountries.addCountry(new Country("Canada", new BigDecimal("99999999901263466365567890")));
        listOfAmericaNorthCountries.addCountry(new Country("Brazil", new BigDecimal("9999999966901263466365567890")));
        listOfAmericaNorthCountries.addCountry(new Country("Chile", new BigDecimal("9901263466365567890")));

        Continent listOfAmericaSouthCountries = new Continent();

        listOfAmericaSouthCountries.addCountry(new Country("Cuba", new BigDecimal("999567890")));
        listOfAmericaSouthCountries.addCountry(new Country("Peru", new BigDecimal("01263466365567890")));
        listOfAmericaSouthCountries.addCountry(new Country("Jamaica", new BigDecimal("901263466365567890")));

        World listOfContinents = new World();
        listOfContinents.addContinent(listOfEuropeCountries);
        listOfContinents.addContinent(listOfAmericaNorthCountries);
        listOfContinents.addContinent(listOfAmericaSouthCountries);

        BigDecimal resultOfPeopleQuantity = listOfContinents.getPeopleQuantity();

        BigDecimal expectedResultOfPeopleQuantity = new BigDecimal("10099999977970435662660911010");

        Assert.assertEquals(resultOfPeopleQuantity,expectedResultOfPeopleQuantity);
    }
}
