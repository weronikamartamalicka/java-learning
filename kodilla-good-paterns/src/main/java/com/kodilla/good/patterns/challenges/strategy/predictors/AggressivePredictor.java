package com.kodilla.good.patterns.challenges.strategy.predictors;

import com.kodilla.good.patterns.challenges.strategy.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
