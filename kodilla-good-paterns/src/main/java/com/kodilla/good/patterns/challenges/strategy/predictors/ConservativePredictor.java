package com.kodilla.good.patterns.challenges.strategy.predictors;

import com.kodilla.good.patterns.challenges.strategy.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
