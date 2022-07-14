package com.kodilla.patterns2.observer.homework;

public interface Observable {

    void notifyMentor();
    void addMentor(Observer observer);
    void removeMentor(Observer observer);
}
