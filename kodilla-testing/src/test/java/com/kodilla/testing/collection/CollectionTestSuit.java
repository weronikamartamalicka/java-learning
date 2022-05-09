package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Nested
@DisplayName("Collection test suit")
public class CollectionTestSuit {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter ++;
        System.out.println("Preparing to execute the test number # " + testCounter);
    }

    @Nested
    @DisplayName("Tests for lists")
    class TestsForLists {

        @Test
        @DisplayName("Testing empty list")
        public void testOddNumbersExterminatorEmptylist() {

            List<Integer> numbers = new ArrayList<>();

            OddNumbersExterminator exterminator = new OddNumbersExterminator();
            List<Integer> temporaryList = exterminator.exterminate(numbers);

            Assertions.assertEquals(0, exterminator.getEvenNumbersQuantity());
            Assertions.assertNull(exterminator.exterminate(numbers));
        }

        @Test
        @DisplayName("Testing normal list")
        public void testOddNumbersExterminatorNormalList() {
            List<Integer> numbers = new ArrayList<>();
           numbers.add(3);
           numbers.add(4);

           OddNumbersExterminator exterminator = new OddNumbersExterminator();
           List<Integer> temporaryList = exterminator.exterminate(numbers);
           int[] b = new int[]{4};

            Assertions.assertEquals(1, exterminator.getEvenNumbersQuantity());

            boolean result = Arrays.equals(exterminator.getEvenNumbersAsArray(),b);
            Assertions.assertTrue(result);
        }

    }

}
