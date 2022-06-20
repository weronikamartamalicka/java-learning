package com.kodilla.good.patterns.factory.task;

import com.kodilla.good.patterns.challenges.factory.task.ExecutedTasks;
import com.kodilla.good.patterns.challenges.factory.task.Task;
import com.kodilla.good.patterns.challenges.factory.task.TaskFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {
    private final static TaskFactory taskFactory = new TaskFactory();

    @Test
     void testShoppingTaskFactory() {

        Task task = taskFactory.makeTask(TaskFactory.SHOPPING);

        assertEquals("Buy Milk, honey and salt",task.getTaskName());
    }

    @Test
    void testPaintingTaskFactory() {

        Task task = taskFactory.makeTask(TaskFactory.PAINTING);

        assertEquals("Paint Kitchen",task.getTaskName());
    }

    @Test
    void testDrivingTaskFactory() {

        Task task = taskFactory.makeTask(TaskFactory.DRIVING);

        assertEquals("Drive a Car",task.getTaskName());
    }

    @Test
    void testGetStoresTaskStatus() {

        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING);
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING);
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING);

        ExecutedTasks executedTasks = new ExecutedTasks();

        executedTasks.storeTaskStatus(shoppingTask, paintingTask, drivingTask);

        Map<Boolean, String> taskMap = executedTasks.getTaskStatus();

        System.out.println(taskMap.values());

        assertEquals(3,taskMap.size());

    }
}
