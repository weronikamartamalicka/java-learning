package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SanGiovanniPizzaOrder extends AbstractBasicDecorator {

    public SanGiovanniPizzaOrder(PizzaOrder order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with additional ingredients: /n " +
                "Truffle paste, Mozzarella, Prosciutto Cotto ham, mushrooms, " +
                "fresh arugula, Italian sheep's Pecorino Romano cheese";
    }
}
