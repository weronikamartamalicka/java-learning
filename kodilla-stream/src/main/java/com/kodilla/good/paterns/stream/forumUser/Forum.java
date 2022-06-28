package com.kodilla.good.paterns.stream.forumUser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    public final List<ForumUser> getUserList() {
        final List<ForumUser> listOfUsers = new ArrayList<>();

        listOfUsers.add(new ForumUser(03506,"katarzynamalec",'F', 1992, 04, 22, 3));
        listOfUsers.add(new ForumUser(02345,"wojciechkadlo",'M', 1992, 05, 03, 0));
        listOfUsers.add(new ForumUser(01065,"zbigniewmatuszczyk",'M', 1991, 03, 15, 20));
        listOfUsers.add(new ForumUser(02506,"katarzynapalec",'F', 1990, 05, 21, 30));
        listOfUsers.add(new ForumUser(03516,"katarzynamala",'F', 1995, 01, 23, 300));
        listOfUsers.add(new ForumUser(00506,"katarzynaborowska",'F', 1992, 01, 20, 3));

        return new ArrayList<>(listOfUsers);
    }
}
