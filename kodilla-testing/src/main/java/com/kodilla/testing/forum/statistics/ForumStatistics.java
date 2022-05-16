package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class ForumStatistics {

    int usersCount = 0;
    int postsCount = 0;
    int commentsCount = 0;
    double averageOfPostsPerUser = 0.0;
    double averageOfCommentsPerUser = 0.0;
    double averageOfCommentsPerPost = 0.0;
    List<String>listOfUsers;



    public void calculateAdvStatistics(Statistics statistics) {

        int usersCount = this.usersCount();
        int postsCount = this.postsCount();
        int commentsCount = this.commentsCount();

        if(usersCount != 0 && postsCount != 0) {

            double averageOfPostsPerUser = postsCount / usersCount;
            double averageOfCommentsPerUser = commentsCount / usersCount;
            double averageOfCommentsPerPost = commentsCount / postsCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setPostsCount(postsCount);
            this.setAverageOfCommentsPerPost(averageOfCommentsPerPost);
            this.setAverageOfCommentsPerUser(averageOfCommentsPerUser);
            this.setAverageOfPostsPerUser(averageOfPostsPerUser);
        }
        else if(usersCount == 0){

            double averageOfCommentsPerPost = commentsCount / postsCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setPostsCount(postsCount);
            this.setAverageOfCommentsPerPost(averageOfCommentsPerPost);
        }
        else {

            double averageOfPostsPerUser = postsCount / usersCount;
            double averageOfCommentsPerUser = commentsCount / usersCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setPostsCount(postsCount);
            this.setAverageOfCommentsPerUser(averageOfCommentsPerUser);
            this.setAverageOfPostsPerUser(averageOfPostsPerUser);
        }
    }

    public void showStatistics() {
        System.out.println("Post count: " + postsCount + "Users count" + usersCount + "Comments count" + commentsCount);
    }

    public List<String> usersNames(List<String> usersNames) {
        listOfUsers = new ArrayList<>();
        listOfUsers.addAll(usersNames);
        return listOfUsers;
    }

    public int usersCount() {
        int result = listOfUsers.size();
        return result;
    }

    public int postsCount() {
        return postsCount;
    }

    public int commentsCount() {
        return commentsCount;
    }

    public double getAverageOfPostsPerUser() {
        return averageOfPostsPerUser;
    }

    public double getAverageOfCommentsPerUser() {
        return averageOfCommentsPerUser;
    }

    public double getAverageOfCommentsPerPost() {
        return averageOfCommentsPerPost;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setAverageOfPostsPerUser(double averageOfPostsPerUser) {
        this.averageOfPostsPerUser = averageOfPostsPerUser;
    }

    public void setAverageOfCommentsPerUser(double averageOfCommentsPerUser) {
        this.averageOfCommentsPerUser = averageOfCommentsPerUser;
    }

    public void setAverageOfCommentsPerPost(double averageOfCommentsPerPost) {
        this.averageOfCommentsPerPost = averageOfCommentsPerPost;
    }
}
