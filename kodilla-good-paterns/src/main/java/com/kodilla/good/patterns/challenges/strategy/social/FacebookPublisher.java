package com.kodilla.good.patterns.challenges.strategy.social;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Facebook";
    }
}
