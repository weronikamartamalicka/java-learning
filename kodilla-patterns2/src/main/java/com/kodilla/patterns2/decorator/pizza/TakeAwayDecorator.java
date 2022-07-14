package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TakeAwayDecorator extends AbstractBasicDecorator {

    public TakeAwayDecorator(PizzaOrder order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " plus take-away package";
    }
}
