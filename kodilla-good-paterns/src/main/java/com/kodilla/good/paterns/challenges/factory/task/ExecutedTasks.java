package com.kodilla.good.paterns.challenges.factory.task;

import java.util.HashMap;
import java.util.Map;

public final class ExecutedTasks {
    private final Map<String, Boolean> taskStatus = new HashMap<>();

    public void storeTaskStatus(Task... task) {

        for(Task executingTask : task) {
            String taskName = executingTask.getTaskName();
            Boolean isTaskExecuted = executingTask.isTaskExecuted();

            taskStatus.put(taskName, isTaskExecuted);
        }


    }

    public Map<String, Boolean> getTaskStatus() {
        return new HashMap<>(taskStatus);
    }
}
