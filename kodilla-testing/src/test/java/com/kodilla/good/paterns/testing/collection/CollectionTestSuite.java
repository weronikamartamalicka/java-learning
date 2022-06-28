package com.kodilla.good.paterns.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@Nested
@DisplayName("Collection test suit")
public class CollectionTestSuite {
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

            List<Integer> numbers = Arrays.asList();

            OddNumbersExterminator exterminator = new OddNumbersExterminator();
            exterminator.exterminate(numbers);

            Assertions.assertEquals(0, exterminator.getEvenNumbersQuantity());
        }

        @Test
        @DisplayName("Testing normal list")
        public void testOddNumbersExterminatorNormalList() {

            List<Integer> numbers = Arrays.asList(3,4);
            List<Integer> testingNumbers = Arrays.asList(4);

           OddNumbersExterminator exterminator = new OddNumbersExterminator();
           List <Integer> temporaryList = exterminator.exterminate(numbers);

            Assertions.assertEquals(1, exterminator.getEvenNumbersQuantity());

            boolean result = temporaryList.equals(testingNumbers);
            Assertions.assertTrue(result);
        }

    }

}
