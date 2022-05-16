package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@Nested
@DisplayName("ForumStatisticsTestSuite")
@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private List<String> usersNames;

    public List<String> listGenerator(int length) {
    usersNames = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            usersNames.add(String.valueOf(i));
        }
        return usersNames;
    }
    @Nested
    @DisplayName("ForumStatisticsPostAndComments")
    class ForumStatisticsPostAndComments {

        @Test
        public void calculateAdvStatistics0Posts() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(100));
            when(statisticsMock.commentsCount()).thenReturn(100);
            when(statisticsMock.postsCount()).thenReturn(0);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            int countOfUsers = forumStatistics.usersCount();
            int countOfPosts = forumStatistics.postsCount();
            int countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(100,countOfUsers);
            assertEquals(0,countOfPosts);
            assertEquals(100,countOfComments);
            assertEquals(0,averageCountOfPostsPerUser);
            assertEquals(1,averageCountOfCommentsPerUser);
            assertEquals(0,averageCountOfCommentsPerPost);
        }

        @Test
        public void calculateAdvStatistics1000Posts() {


        }

        @Test
        public void calculateAdvStatistics0Comments() {


        }

        @Test
        public void calculateAdvStatisticsLessCommentsThanPosts() {


        }

        @Test
        public void calculateAdvStatisticsLessPostsThanComments() {

        }
    }

    @Nested
    @DisplayName("ForumStatisticsUsers")
    class ForumStatisticsUsers {

        @Test
        public void calculateAdvStatistics0Users() {


        }

        @Test
        public void calculateAdvStatistics100Users() {


        }
    }
}
