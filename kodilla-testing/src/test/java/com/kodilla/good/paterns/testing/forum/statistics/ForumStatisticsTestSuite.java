package com.kodilla.good.paterns.testing.forum.statistics;

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

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(100.0,countOfUsers);
            assertEquals(0.0,countOfPosts);
            assertEquals(100.0,countOfComments);
            assertEquals(0.0,averageCountOfPostsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerUser);
            assertEquals(0.0,averageCountOfCommentsPerPost);
        }

        @Test
        public void calculateAdvStatistics1000Posts() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(1000));
            when(statisticsMock.commentsCount()).thenReturn(1000);
            when(statisticsMock.postsCount()).thenReturn(1000);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(1000.0,countOfUsers);
            assertEquals(1000.0,countOfPosts);
            assertEquals(1000.0,countOfComments);
            assertEquals(1.0,averageCountOfPostsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerPost);

        }

        @Test
        public void calculateAdvStatistics0Comments() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(1000));
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.postsCount()).thenReturn(1000);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(1000.0,countOfUsers);
            assertEquals(1000.0,countOfPosts);
            assertEquals(0.0,countOfComments);
            assertEquals(1.0,averageCountOfPostsPerUser);
            assertEquals(0.0,averageCountOfCommentsPerUser);
            assertEquals(0.0,averageCountOfCommentsPerPost);

        }

        @Test
        public void calculateAdvStatisticsLessCommentsThanPosts() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(100));
            when(statisticsMock.commentsCount()).thenReturn(100);
            when(statisticsMock.postsCount()).thenReturn(1000);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(100.0,countOfUsers);
            assertEquals(1000.0,countOfPosts);
            assertEquals(100.0,countOfComments);
            assertEquals(10.0,averageCountOfPostsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerUser);
            assertEquals(0.10,averageCountOfCommentsPerPost);


        }

        @Test
        public void calculateAdvStatisticsLessPostsThanComments() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(100));
            when(statisticsMock.commentsCount()).thenReturn(1000);
            when(statisticsMock.postsCount()).thenReturn(100);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(100.0,countOfUsers);
            assertEquals(100.0,countOfPosts);
            assertEquals(1000.0,countOfComments);
            assertEquals(1.0,averageCountOfPostsPerUser);
            assertEquals(10.0,averageCountOfCommentsPerUser);
            assertEquals(10.0,averageCountOfCommentsPerPost);

        }
    }

    @Nested
    @DisplayName("ForumStatisticsUsers")
    class ForumStatisticsUsers {

        @Test
        public void calculateAdvStatistics0Users() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(usersNames = new ArrayList<>());
            when(statisticsMock.commentsCount()).thenReturn(100);
            when(statisticsMock.postsCount()).thenReturn(100);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(0.0,countOfUsers);
            assertEquals(100.0,countOfPosts);
            assertEquals(100.0,countOfComments);
            assertEquals(0.0,averageCountOfPostsPerUser);
            assertEquals(0.0,averageCountOfCommentsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerPost);


        }

        @Test
        public void calculateAdvStatistics100Users() {
            ForumStatistics forumStatistics = new ForumStatistics();

            when(statisticsMock.usersNames()).thenReturn(listGenerator(100));
            when(statisticsMock.commentsCount()).thenReturn(100);
            when(statisticsMock.postsCount()).thenReturn(100);

            forumStatistics.calculateAdvStatistics(statisticsMock);

            double countOfUsers = forumStatistics.usersCount();
            double countOfPosts = forumStatistics.postsCount();
            double countOfComments = forumStatistics.commentsCount();
            double averageCountOfPostsPerUser = forumStatistics.getAverageOfPostsPerUser();
            double averageCountOfCommentsPerUser = forumStatistics.getAverageOfCommentsPerUser();
            double averageCountOfCommentsPerPost = forumStatistics.getAverageOfCommentsPerPost();

            assertEquals(100.0,countOfUsers);
            assertEquals(100.0,countOfPosts);
            assertEquals(100.0,countOfComments);
            assertEquals(1.0,averageCountOfPostsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerUser);
            assertEquals(1.0,averageCountOfCommentsPerPost);


        }
    }
}
