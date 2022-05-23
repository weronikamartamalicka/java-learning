package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {


    @Test
    public void testGetPeopleQuantity() {


        Continent listOfEuropeCountries = new Continent();

        listOfEuropeCountries.addCountry(new Italy());
        listOfEuropeCountries.addCountry(new Spain());
        listOfEuropeCountries.addCountry(new Portugal());

        Continent listOfAmericaNorthCountries = new Continent();

        listOfAmericaNorthCountries.addCountry(new Canada());
        listOfAmericaNorthCountries.addCountry(new Brazil());
        listOfAmericaNorthCountries.addCountry(new Chile());

        Continent listOfAmericaSouthCountries = new Continent();

        listOfAmericaSouthCountries.addCountry(new Cuba());
        listOfAmericaSouthCountries.addCountry(new Peru());
        listOfAmericaSouthCountries.addCountry(new Jamaica());

        World listOfContinents = new World();
        listOfContinents.addContinent(listOfEuropeCountries);
        listOfContinents.addContinent(listOfAmericaNorthCountries);
        listOfContinents.addContinent(listOfAmericaSouthCountries);

        BigDecimal resultOfPeopleQuantity = listOfContinents.getPeopleQuantity();

        BigDecimal expectedResultOfPeopleQuantity = new BigDecimal("10099999977970435662660911010");

        Assert.assertEquals(resultOfPeopleQuantity,expectedResultOfPeopleQuantity);
    }
}
