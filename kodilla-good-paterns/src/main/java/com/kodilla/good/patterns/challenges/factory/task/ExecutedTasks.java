package com.kodilla.good.patterns.challenges.factory.task;

import java.util.HashMap;
import java.util.Map;

public final class ExecutedTasks {
    private final Map taskStatus = new HashMap<>();

    public void storeTaskStatus(Task task) {

        String taskName = task.getTaskName();
        Boolean isTaskExecuted = task.isTaskExecuted();

        taskStatus.put(isTaskExecuted, taskName);
    }

    public Map getTaskStatus() {
        return new HashMap<>(taskStatus);
    }
}
