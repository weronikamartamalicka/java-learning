package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public class SantAndreaPizzaOrder extends AbstractBasicDecorator {

    public SantAndreaPizzaOrder(PizzaOrder order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with additional ingredients: /n " +
                "salami picante, fresh spinach leaves, shrimp in spicy oil, Ricotta, thyme, lemon.";
    }
}
