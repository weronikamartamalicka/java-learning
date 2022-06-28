package com.kodilla.good.paterns.exception.test;

import java.time.LocalDate;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(1.5, 0.5);
        } catch (Exception e) {
            System.out.println("The variable x has to be less than 2 or greater than or equal than 1 and variable y could not be equal to 1.5");
        } finally {
            System.out.println("The last attempt: " + LocalDate.now());
        }
    }
}
