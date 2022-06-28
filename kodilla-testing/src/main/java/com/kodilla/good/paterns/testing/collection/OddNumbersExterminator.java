package com.kodilla.good.paterns.testing.collection;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator<I extends Number> {
    List<Integer> evenNumbers = new ArrayList<>();

    public List<Integer> exterminate(@NotNull List<Integer> numbers) {
        if (numbers.size() == 0) {
        }
        {
            for (int i = 0; i < numbers.size(); i++) {
                Integer temporaryNumber = numbers.get(i);
                if (temporaryNumber % 2 == 0) {
                    evenNumbers.add(temporaryNumber);
                }
            }
            System.out.println(evenNumbers);
            return (evenNumbers);
        }
    }


    public int getEvenNumbersQuantity() {
        return evenNumbers.size();
    }
}


