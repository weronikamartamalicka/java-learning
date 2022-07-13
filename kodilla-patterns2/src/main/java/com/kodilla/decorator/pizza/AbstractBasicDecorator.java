package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractBasicDecorator implements PizzaOrder {
    private final PizzaOrder order;

    public AbstractBasicDecorator(final PizzaOrder order) {
        this.order = order;
    }

    @Override
    public BigDecimal getCost() {
        return order.getCost();
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }
}
