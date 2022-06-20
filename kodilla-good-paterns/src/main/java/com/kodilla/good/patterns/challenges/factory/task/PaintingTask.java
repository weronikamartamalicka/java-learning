package com.kodilla.good.patterns.challenges.factory.task;

import java.util.Objects;

public final class PaintingTask implements Task{
    private final String taskName;
    private final String color;
    private final String whatToPaint;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {
        return taskName;
    }

    @Override
    public String getTaskName() {
        return whatToPaint;
    }

    @Override
    public boolean isTaskExecuted() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaintingTask)) return false;
        PaintingTask that = (PaintingTask) o;
        return getTaskName().equals(that.getTaskName()) && color.equals(that.color) && whatToPaint.equals(that.whatToPaint);
    }

    @Override
    public int hashCode() {
        int result = whatToPaint.hashCode();
        result = 31 * result + taskName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PaintingTask{" +
                "taskName='" + taskName + '\'' +
                ", color='" + color + '\'' +
                ", whatToPaint='" + whatToPaint + '\'' +
                '}';
    }
}
