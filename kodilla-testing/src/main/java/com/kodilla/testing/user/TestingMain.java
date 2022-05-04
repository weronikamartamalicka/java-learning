package com.kodilla.testing.user;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();

        if (result == "theForumUser") {
            System.out.println("OK");
        } else {
            System.out.println("Error!");
        }
    }
}
