package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    double usersCount = 0.0;
    double postsCount = 0.0;
    double commentsCount = 0.0;
    double averageOfPostsPerUser = 0.0;
    double averageOfCommentsPerUser = 0.0;
    double averageOfCommentsPerPost = 0.0;

    public void calculateAdvStatistics(Statistics statistics) {

        double usersCount = statistics.usersNames().size();
        double postsCount = statistics.postsCount();
        double commentsCount = statistics.commentsCount();

        if(usersCount != 0.0 && postsCount != 0.0) {

            double averageOfPostsPerUser = postsCount / usersCount;
            double averageOfCommentsPerUser = commentsCount / usersCount;
            double averageOfCommentsPerPost = commentsCount / postsCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setCommentsCount(commentsCount);
            this.setAverageOfCommentsPerPost(averageOfCommentsPerPost);
            this.setAverageOfCommentsPerUser(averageOfCommentsPerUser);
            this.setAverageOfPostsPerUser(averageOfPostsPerUser);
        }
        else if(usersCount == 0.0){

            double averageOfCommentsPerPost = commentsCount / postsCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setCommentsCount(commentsCount);
            this.setAverageOfCommentsPerPost(averageOfCommentsPerPost);
        }
        else {

            double averageOfPostsPerUser = postsCount / usersCount;
            double averageOfCommentsPerUser = commentsCount / usersCount;

            this.setPostsCount(postsCount);
            this.setUsersCount(usersCount);
            this.setCommentsCount(commentsCount);
            this.setAverageOfCommentsPerUser(averageOfCommentsPerUser);
            this.setAverageOfPostsPerUser(averageOfPostsPerUser);
        }
    }

    public void showStatistics() {
        System.out.println("Post count: " + postsCount + "Users count" + usersCount + "Comments count" + commentsCount);
    }

    public double usersCount() {
        return usersCount;
    }

    public double postsCount() {
        return postsCount;
    }

    public double commentsCount() {
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

    public void setUsersCount(double usersCount) {
        this.usersCount = usersCount;
    }

    public void setPostsCount(double postsCount) {
        this.postsCount = postsCount;
    }

    public void setCommentsCount(double commentsCount) {
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
