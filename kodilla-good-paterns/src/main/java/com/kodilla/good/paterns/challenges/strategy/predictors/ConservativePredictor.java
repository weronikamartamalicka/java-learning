package com.kodilla.good.paterns.challenges.strategy.predictors;

import com.kodilla.good.paterns.challenges.strategy.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
