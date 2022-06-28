package com.kodilla.good.paterns.challenges.factory.task;

public final class TaskFactory {
    public final static String SHOPPING = "SHOPPING";
    public final static String PAINTING = "PAINTING";
    public final static String DRIVING = "DRIVING";

    public final Task makeTask(String taskName) {

        switch(taskName) {
            case SHOPPING:
                return new ShoppingTask("Dinner shopping", "Buy Milk, honey and salt", 2.0);
            case PAINTING:
                return new PaintingTask("Home renovation", "White", "Paint Kitchen");
            case DRIVING:
                return new DrivingTask("Sightseeing excursion", "France", "Drive a Car");
            default:
                return null;
        }
    }
}
