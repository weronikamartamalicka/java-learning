package com.kodilla.good.patterns.challenges.strategy;

import com.kodilla.good.patterns.challenges.strategy.predictors.BalancedPredictor;
import com.kodilla.good.patterns.challenges.strategy.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
