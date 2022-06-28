package com.kodilla.good.paterns.stream;

import com.kodilla.good.paterns.stream.forumUser.Forum;
import com.kodilla.good.paterns.stream.forumUser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer,ForumUser> resultList = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> 2022 - forumUser.getDateOfBirth().getYear() >= 20)
                .filter(forumUser -> forumUser.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getPeselId, forumUser -> forumUser));

        resultList.entrySet().stream()
                .forEach(System.out::println);

        //System.out.println(resultList);
    }
}


