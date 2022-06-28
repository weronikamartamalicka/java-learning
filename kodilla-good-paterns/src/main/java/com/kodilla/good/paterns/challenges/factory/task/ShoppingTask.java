package com.kodilla.good.paterns.challenges.factory.task;

public final class ShoppingTask implements Task{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        return taskName;
    }

    @Override
    public String getTaskName() {
        return whatToBuy;
    }

    @Override
    public boolean isTaskExecuted() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingTask)) return false;
        ShoppingTask that = (ShoppingTask) o;
        return Double.compare(that.quantity, quantity) == 0 && getTaskName().equals(that.getTaskName()) && whatToBuy.equals(that.whatToBuy);
    }

    @Override
    public int hashCode() {
        int result = taskName.hashCode();
        result = 31 * result + whatToBuy.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingTask{" +
                "taskName='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
