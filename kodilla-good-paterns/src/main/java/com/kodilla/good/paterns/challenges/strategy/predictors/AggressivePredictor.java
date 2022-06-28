package com.kodilla.good.paterns.challenges.strategy.predictors;

import com.kodilla.good.paterns.challenges.strategy.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
