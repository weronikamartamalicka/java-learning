package com.kodilla.good.paterns.challenges.strategy;

import com.kodilla.good.paterns.challenges.strategy.predictors.AggressivePredictor;

public class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
