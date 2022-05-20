package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import com.kodilla.stream.world.*;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {


    @Test
    public void testGetPeopleQuantity() {

        World world = new World();
        PeopleCount continent = new Spain();
        List<PeopleCount> listOfEuropeCountries = new ArrayList<>();

        listOfEuropeCountries.add(new Italy());
        listOfEuropeCountries.add(new Spain());
        listOfEuropeCountries.add(new Portugal());

        List<PeopleCount>listOfAmericaNorthCountries = new ArrayList<>();

        listOfAmericaNorthCountries.add(new Canada());
        listOfAmericaNorthCountries.add(new Brazil());
        listOfAmericaNorthCountries.add(new Chile());

        List<PeopleCount>listOfAmericaSouthCountries = new ArrayList<>();

        listOfAmericaSouthCountries.add(new Cuba());
        listOfAmericaSouthCountries.add(new Peru());
        listOfAmericaSouthCountries.add(new Jamaica());

        List<List<PeopleCount>>worldList = new ArrayList<>();
        worldList.add(new ArrayList<>(listOfEuropeCountries));
        worldList.add(new ArrayList<>(listOfAmericaSouthCountries));
        worldList.add(new ArrayList<>(listOfAmericaNorthCountries));

        BigDecimal resultOfPeopleQuantity = world.getPeopleQuantity();

        BigDecimal expectedResultOfPeopleQuantity = new BigDecimal("123456789");

        Assert.assertEquals(resultOfPeopleQuantity,expectedResultOfPeopleQuantity);
    }
}
