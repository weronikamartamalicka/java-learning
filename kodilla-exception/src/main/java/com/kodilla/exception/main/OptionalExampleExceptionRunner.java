package com.kodilla.exception.main;

import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExampleExceptionRunner {

    public static void main(String[] args) {
        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);

        String userName = optionalUser.orElse(new User("Zbigniew")).getName();
        System.out.println(userName);

        optionalUser.ifPresent(user1 -> System.out.println(user1.getName()));
    }
}
