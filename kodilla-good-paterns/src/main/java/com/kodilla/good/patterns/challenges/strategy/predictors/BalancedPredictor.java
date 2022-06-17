package com.kodilla.good.patterns.challenges.strategy.predictors;

import com.kodilla.good.patterns.challenges.strategy.BuyPredictor;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}
