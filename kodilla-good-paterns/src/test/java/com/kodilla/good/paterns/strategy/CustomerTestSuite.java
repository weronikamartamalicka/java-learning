package com.kodilla.good.paterns.strategy;

import com.kodilla.good.paterns.challenges.strategy.CorporateCustomer;
import com.kodilla.good.paterns.challenges.strategy.Customer;
import com.kodilla.good.paterns.challenges.strategy.IndividualCustomer;
import com.kodilla.good.paterns.challenges.strategy.IndividualYoungCustomer;
import com.kodilla.good.paterns.challenges.strategy.predictors.AggressivePredictor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {
    @Test
    void testDefaultInvestingStrategies() {

        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        Customer steven = new IndividualCustomer("Steven Links");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

        assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
