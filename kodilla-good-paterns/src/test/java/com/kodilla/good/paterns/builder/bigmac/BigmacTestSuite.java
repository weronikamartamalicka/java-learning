package com.kodilla.good.paterns.builder.bigmac;

import com.kodilla.good.paterns.challenges.builder.bigmac.Bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(true)
                .burgers(10)
                .sauce("sweet thai mayo")
                .ingredients("shrimps", "red onion", "pickles", "cheddar cheese")
                .build();

        System.out.println(bigmac);

        boolean containsPickles = bigmac.getIngredients().contains("pickles");

        assertTrue(containsPickles);
    }
}
