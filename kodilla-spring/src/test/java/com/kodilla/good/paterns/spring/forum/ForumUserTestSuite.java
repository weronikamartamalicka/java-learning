package com.kodilla.good.paterns.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForumUserTestSuite {
 @Test
    public void testGetUsername(){
     ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
     ForumUser forumUser = context.getBean(ForumUser.class);
     java.lang.String userName = forumUser.getUserName();

     assertEquals(userName, "John Smith");
    }
}
