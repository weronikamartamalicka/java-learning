package com.kodilla.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasicPizzaOrderTest {

    @Test
    void testSanGiovanniPizza() {
        PizzaOrder order = new BasicPizzaOrder();
        order = new SanGiovanniPizzaOrder(order);

        BigDecimal cost = order.getCost();
        String description = order.getDescription();

        assertEquals(new BigDecimal(45.0), cost);
        assertEquals("Ordering pizza with additional ingredients: /n " +
                "Truffle paste, Mozzarella, Prosciutto Cotto ham, mushrooms, " +
                "fresh arugula, Italian sheep's Pecorino Romano cheese", description);
    }

    @Test
    void testSantAndreaPizzaTakeAway() {
        PizzaOrder order = new BasicPizzaOrder();
        order = new SantAndreaPizzaOrder(order);
        order = new TakeAwayDecorator(order);

        BigDecimal cost = order.getCost();
        String description = order.getDescription();

        assertEquals(new BigDecimal(45.0), cost);
        assertEquals("Ordering pizza with additional ingredients: " +
                "/n salami picante, fresh spinach leaves, shrimp in spicy oil, " +
                "Ricotta, thyme, lemon. plus take-away package", description);
    }

}