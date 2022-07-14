package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int notificationCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Tasks tasks) {
        System.out.println("You have new task to check!" + "/n"
                + "[number] : " + tasks.getNumber() + "[desc] : " + tasks.getName());

        notificationCount++;
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}
