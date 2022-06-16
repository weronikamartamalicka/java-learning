package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        if(context.containsBean("toDoList")) {
            ArrayList<String> toDoList = (ArrayList<String>) board.getToDoList().getTasks();
            toDoList.add("Eat more vegetables");
            toDoList.stream().forEach(System.out::println);
        }
        if(context.containsBean("listInProgress")) {
            ArrayList<String> inProgressList = (ArrayList<String>) board.getToDoList().getTasks();
            inProgressList.add("Learn JavaFx");
            inProgressList.stream().forEach(System.out::println);
        }
        if(context.containsBean("doneList")) {
            ArrayList<String> doneList = (ArrayList<String>) board.getToDoList().getTasks();
            doneList.add("Be nice");
            doneList.stream().forEach(System.out::println);
        }

        ArrayList<String> listToDo = (ArrayList<String>) context.getBean("toDoList");
        ArrayList<String> inProgressList = (ArrayList<String>) context.getBean("listInProgress");
        ArrayList<String> doneList = (ArrayList<String>) context.getBean("doneList");

        listToDo.stream().forEach(System.out::println);
        inProgressList.stream().forEach(System.out::println);
        doneList.stream().forEach(System.out::println);
    }

    @Test
    void testToDoList() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        ArrayList<String> listToDo = (ArrayList<String>) context.getBean("toDoList");
        ArrayList<String> inProgressList = (ArrayList<String>) context.getBean("listInProgress");
        ArrayList<String> doneList = (ArrayList<String>) context.getBean("doneList");

        listToDo.stream().forEach(System.out::println);
        inProgressList.stream().forEach(System.out::println);
        doneList.stream().forEach(System.out::println);

        assertEquals(1, listToDo.size());
        assertEquals(1, inProgressList.size());
        assertEquals(1, doneList.size());
    }
}
