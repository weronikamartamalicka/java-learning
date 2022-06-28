package com.kodilla.good.paterns.testing.calculator;

public class TestingMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(15, 5);

        int resultOne = calculator.add();
        int resultTwo = calculator.subtract();

        if (resultOne == 20) {
            System.out.println("Ok");
        } else {
            System.out.println("Error");
        }

        if (resultTwo == 10) {
            System.out.println("Ok");
        } else {
            System.out.println("Error");
        }
    }
}




