package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Tasks implements Observable {
    private final int number;
    private final String name;
    private final ArrayDeque<Tasks> tasks;
    private final List<Observer> observers;


    public Tasks(final int number, final String name) {
        this.number = number;
        this.name = name;
        tasks = new ArrayDeque<>();
        observers = new ArrayList<>();
    }

    @Override
    public void notifyMentor() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void addMentor(Observer observer) {
        observers.add(observer);
        notifyMentor();
    }

    @Override
    public void removeMentor(Observer observer) {
        observers.remove(observer);
    }

    public void addTask(Tasks task) {
        tasks.addLast(task);

    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public ArrayDeque<Tasks> getTasks() {
        return tasks;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
