package com.kodilla.good.paterns.challenges.strategy;

public class Customer {
    private final String name;
    protected BuyPredictor buyPredictor;

    public Customer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BuyPredictor getBuyPredictor() {
        return buyPredictor;
    }

    public void setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }
}
