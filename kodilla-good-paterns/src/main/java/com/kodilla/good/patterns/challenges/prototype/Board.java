package com.kodilla.good.patterns.challenges.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Board extends Prototype<Board> {
    private String name;
    private final Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return new HashSet<>(lists);
    }

    public void addTasksList(TasksList tasksList) {
        lists.add(tasksList);
    }

    public void removeTasksList(TasksList tasksList) {
        lists.remove(tasksList);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TasksList> createEmptyList() {
         Set<TasksList> shallowCopiedLists = new HashSet<>();
        return shallowCopiedLists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();

        Set<TasksList> shallowCopiedLists = clonedBoard.createEmptyList();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.lists.remove(clonedList);
        }
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name) &&
                Objects.equals(lists, board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}
