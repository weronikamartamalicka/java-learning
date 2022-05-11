package com.kodilla.testing.shape.tdd;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.*;

@Nested
@DisplayName("TDD: Shape Collector Test Suite \uD83D\uDE31")
public class ShapeCollectorTestSuite {

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
        testCounter++;
        System.out.println("Preparing to execute the test number # " + testCounter);
    }

    @Nested
    @DisplayName("Tests for circles")
    class TestsForCircles {

        @Test
        public void testAddFigure() {
            Shape circle = new Circle("circle", 30.5);
            ShapeCollector circleCollector = new ShapeCollector();
            circleCollector.addFigure(circle);

            Assertions.assertEquals(1, circleCollector.getFiguresQuantity());
        }

        @Test
        public void testRemoveFigure() {
            Shape circle = new Circle("circle", 30.5);
            ShapeCollector circleCollector = new ShapeCollector();
            circleCollector.addFigure(circle);

            boolean result = circleCollector.removeFigure(circle);

            Assertions.assertEquals(0, circleCollector.getFiguresQuantity());
            Assertions.assertTrue(result);
        }

        @Test
        public void testRemoveFigureNotExisting() {
            Shape circle = new Circle("circle", 30.5);
            ShapeCollector circleCollector = new ShapeCollector();

            boolean result = circleCollector.removeFigure(circle);

            Assertions.assertFalse(result);
        }

        @Test
        public void testGetFigure() {
            Shape circle = new Circle("circle", 30.5);
            ShapeCollector circleCollector = new ShapeCollector();
            circleCollector.addFigure(circle);
            Shape retrievedFigure = circleCollector.getFigure(0);

            Assertions.assertEquals(retrievedFigure, circle);
        }

        @Test
        public void testShowFigures() {
            Shape circle = new Circle("circle", 30.5);
            ShapeCollector circleCollector = new ShapeCollector();
            circleCollector.addFigure(circle);
            String showedFigure = circleCollector.showFigures();

            Assertions.assertEquals(showedFigure, circle.getShapeName());
        }
    }

    @Nested
    @DisplayName("Tests for squares")
    class TestsForSquares {

        @Test
        public void testAddFigure() {
            Shape square = new Square("square", 32.5);
            ShapeCollector squareCollector = new ShapeCollector();
            squareCollector.addFigure(square);

            Assertions.assertEquals(1, squareCollector.getFiguresQuantity());
        }

        @Test
        public void testRemoveFigure() {
            Shape square = new Square("square", 32.5);
            ShapeCollector squareCollector = new ShapeCollector();
            squareCollector.addFigure(square);

            boolean result = squareCollector.removeFigure(square);

            Assertions.assertEquals(0, squareCollector.getFiguresQuantity());
            Assertions.assertTrue(result);
        }

        @Test
        public void testRemoveFigureNotExisting() {
            Shape square = new Square("square", 32.5);
            ShapeCollector squareCollector = new ShapeCollector();

            boolean result = squareCollector.removeFigure(square);

            Assertions.assertFalse(result);
        }

        @Test
        public void testGetFigure() {
            Shape square = new Square("square", 32.5);
            ShapeCollector squareCollector = new ShapeCollector();
            squareCollector.addFigure(square);
            Shape retrievedFigure = squareCollector.getFigure(0);

            Assertions.assertEquals(retrievedFigure, square);
        }

        @Test
        public void testShowFigures() {
            Shape square = new Square("square", 32.5);
            ShapeCollector squareCollector = new ShapeCollector();
            squareCollector.addFigure(square);
            String showedFigure = squareCollector.showFigures();

            Assertions.assertEquals(showedFigure, square.getShapeName());
        }
    }

    @Nested
    @DisplayName("Tests for triangles")
    class TestsForTriangles {

        @Test
        public void testAddFigure() {
            Shape triangle = new Triangle("triangle", 30.5);
            ShapeCollector triangleCollector = new ShapeCollector();
            triangleCollector.addFigure(triangle);

            Assertions.assertEquals(1, triangleCollector.getFiguresQuantity());
        }

        @Test
        public void testRemoveFigure() {
            Shape triangle = new Triangle("triangle", 30.5);
            ShapeCollector triangleCollector = new ShapeCollector();
            triangleCollector.addFigure(triangle);

            boolean result = triangleCollector.removeFigure(triangle);

            Assertions.assertEquals(0, triangleCollector.getFiguresQuantity());
            Assertions.assertTrue(result);
        }

        @Test
        public void testRemoveFigureNotExisting() {
            Shape triangle = new Triangle("triangle", 30.5);
            ShapeCollector triangleCollector = new ShapeCollector();

            boolean result = triangleCollector.removeFigure(triangle);

            Assertions.assertFalse(result);
        }

        @Test
        public void testGetFigure() {
            Shape triangle = new Triangle("triangle", 30.5);
            ShapeCollector triangleCollector = new ShapeCollector();
            triangleCollector.addFigure(triangle);
            Shape retrievedFigure = triangleCollector.getFigure(0);

            Assertions.assertEquals(retrievedFigure, triangle);
        }

        @Test
        public void testShowFigures() {
            Shape triangle = new Triangle("triangle", 30.5);
            ShapeCollector triangleCollector = new ShapeCollector();
            triangleCollector.addFigure(triangle);
            String showedFigure = triangleCollector.showFigures();

            Assertions.assertEquals(showedFigure, triangle.getShapeName());
        }
    }
}
