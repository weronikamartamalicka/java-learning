package com.kodilla.good.paterns.testing.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoopAndConditionalBreakpoints {

    @Test
    void testLoop() {

        long sum = 0;
        for(int i = 0; i < 1000; i++) {
            sum += i;
            System.out.println("[" + i + "]" + "Sum equals: " + sum);
        }
        assertEquals(499500, sum);
    }
}
