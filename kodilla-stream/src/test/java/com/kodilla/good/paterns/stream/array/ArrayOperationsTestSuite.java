package com.kodilla.good.paterns.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        int[] numbers = new int[]{3,2,5,3,8,9,6,5,4,2,3,5,6,7,8,2,1,9,7,6};

        OptionalDouble resultOfAverage = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(OptionalDouble.of(5.05),resultOfAverage);
    }
}
