package com.kodilla.good.paterns.strategy.social;

import com.kodilla.good.paterns.challenges.strategy.social.*;
import com.kodilla.good.patterns.challenges.strategy.social.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        User userOne = new Millenials("John");
        User userTwo = new YGeneration("Patrick Bet David");
        User userThree = new ZGeneration("Masza");

        String johnPost = userOne.sharePost();
        String patrickPost = userTwo.sharePost();
        String maszaPost = userThree.sharePost();

        System.out.println(johnPost);
        System.out.println(patrickPost);
        System.out.println(maszaPost);

        assertEquals("Sharing post using: Facebook", johnPost);
        assertEquals("Sharing post using: Twitter", patrickPost);
        assertEquals("Sharing post using: Snapchat", maszaPost);
    }

    @Test
    public void testIndividualSharingStrategy() {

        User userOne = new Millenials("John");
        String johnPost = userOne.sharePost();

        System.out.println(johnPost);

        userOne.setSocialPublisher(new SnapchatPublisher());
        String johnPostTwo = userOne.sharePost();

        System.out.println(johnPostTwo);

        assertEquals("Sharing post using: Facebook", johnPost);
        assertEquals("Sharing post using: Snapchat", johnPostTwo);
    }
}
