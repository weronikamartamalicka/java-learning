package com.kodilla.exception.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void probablyIWillThrowException() {

        SecondChallenge secondChallenge = new SecondChallenge();

        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 3.0));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 3.0));
        Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5,3.0));
    }

}
