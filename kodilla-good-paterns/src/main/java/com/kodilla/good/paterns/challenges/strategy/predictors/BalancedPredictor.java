package com.kodilla.good.paterns.challenges.strategy.predictors;

import com.kodilla.good.paterns.challenges.strategy.BuyPredictor;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}
