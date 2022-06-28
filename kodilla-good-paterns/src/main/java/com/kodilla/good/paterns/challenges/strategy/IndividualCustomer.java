package com.kodilla.good.paterns.challenges.strategy;

import com.kodilla.good.paterns.challenges.strategy.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
