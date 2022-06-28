package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;


public final class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(String name) {
        this.name = name;
    }

    public void addTaskList(TaskList task) {
        taskLists.add(task);
    }

    public boolean removeTaskList(TaskList task) {
        return taskLists.remove(task);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "taskLists=" + taskLists +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Board)) return false;
        Board board = (Board) o;
        return getTaskLists().equals(board.getTaskLists()) && getName().equals(board.getName());
    }

}
