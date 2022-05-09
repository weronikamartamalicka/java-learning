package com.kodilla.testing.collection;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator<I extends Number> {
    List<Integer> evenNumbers = new ArrayList<>();

    public List<Integer> exterminate(@NotNull List<Integer> numbers) {
        if(numbers.size() == 0) {
            return null;
        }
        if (numbers.size() > 0) {
            for (int i = 0; i < numbers.size(); i++) {
                Integer temporaryNumber = numbers.get(i);
                Integer result = temporaryNumber % 2;
                if (result == 0) {
                    evenNumbers.add(temporaryNumber);
                } else {
                }
            }
        }
        return(evenNumbers);
    }

    public int getEvenNumbersQuantity() {
        return evenNumbers.size();
    }

    public int[] getEvenNumbersAsArray() {
        int[] a = new int[evenNumbers.size()];
        for(int i = 0; i < evenNumbers.size(); i++) {
            a[i] = evenNumbers.get(i);
        }
        return(a);
    }
}


