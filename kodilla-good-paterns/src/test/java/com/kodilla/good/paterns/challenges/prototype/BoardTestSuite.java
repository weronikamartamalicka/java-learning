package com.kodilla.good.paterns.challenges.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {
    @Test
    public void testToString() {

        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1 )
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1 )
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        TasksList doneList = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1 )
                .limit(10)
                .forEach(n -> doneList.getTasks().add(new Task("Done Task number " + n)));

        Board board = new Board("Board number 1");
        board.addTasksList(listToDo);
        board.addTasksList(listInProgress);
        board.addTasksList(doneList);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Board number 2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Board number three");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);

        board.removeTasksList(doneList);

        assertEquals(2, board.getLists().size());
        assertEquals(2, clonedBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
    }
}
