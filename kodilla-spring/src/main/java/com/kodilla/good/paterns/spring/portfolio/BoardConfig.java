package com.kodilla.good.paterns.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    ArrayList<String> toDoList;
    @Autowired
    @Qualifier("listInProgress")
    ArrayList<String> listInProgress;
    @Autowired
    @Qualifier("doneList")
    ArrayList<String> doneList;

    @Bean
    @Scope("prototype")
    public Board getBoard() {
        return new Board(new TaskList(toDoList), new TaskList(listInProgress), new TaskList(doneList));
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public ArrayList<String> getToDoList() {
        toDoList = new ArrayList<>();
        toDoList.add("Sleep 8 hours");
        return new ArrayList<>(toDoList);
    }

    @Bean(name = "listInProgress")
    @Scope("prototype")
    public ArrayList<String> getListInProgress() {
        listInProgress = new ArrayList<>();
        listInProgress.add("Learn java");
        return new ArrayList<>(listInProgress);
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public ArrayList<String> getDoneList() {
        doneList = new ArrayList<>();
        doneList.add("Wash dishes");
        return new ArrayList<>(doneList);
    }
}
