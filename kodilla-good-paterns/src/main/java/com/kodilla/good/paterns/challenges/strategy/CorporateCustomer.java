package com.kodilla.good.paterns.challenges.strategy;

import com.kodilla.good.paterns.challenges.strategy.predictors.BalancedPredictor;

public class CorporateCustomer extends Customer {

    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
