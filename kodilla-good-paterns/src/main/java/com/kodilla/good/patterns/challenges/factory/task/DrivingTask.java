package com.kodilla.good.patterns.challenges.factory.task;

import java.util.Objects;

public final class DrivingTask implements Task{
    private final String taskName;
    private final String where;
    private final String using;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        return taskName;
    }

    @Override
    public String getTaskName() {
        return using;
    }

    @Override
    public boolean isTaskExecuted() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrivingTask)) return false;
        DrivingTask that = (DrivingTask) o;
        return getTaskName().equals(that.getTaskName()) && where.equals(that.where) && using.equals(that.using);
    }

    @Override
    public int hashCode() {
        int result = taskName.hashCode();
        result = 31 * result + where.hashCode();
        result = 31 * result + using.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DrivingTask{" +
                "taskName='" + taskName + '\'' +
                ", where='" + where + '\'' +
                ", using='" + using + '\'' +
                '}';
    }
}
