package com.kodilla.good.paterns.builder.pizza;

import com.kodilla.good.paterns.challenges.builder.pizza.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {

        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();

        System.out.println(pizza);

        int howManyIngredients = pizza.getIngredients().size();

        assertEquals(3, howManyIngredients);
    }
}
