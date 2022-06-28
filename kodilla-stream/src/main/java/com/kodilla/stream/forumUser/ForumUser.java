package com.kodilla.stream.forumUser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int peselId;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postsCount;

    public ForumUser(final int peselId, final String userName, final char sex, final int yearOfBirth, final int monthOfBirth, final int dayOfBirth, final int postsCount) {
        this.peselId = peselId;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsCount = postsCount;
    }

    public int getPeselId() {
        return peselId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "peselId=" + peselId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsCount=" + postsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return getPeselId() == forumUser.getPeselId() && getSex() == forumUser.getSex() && getPostsCount() == forumUser.getPostsCount() && Objects.equals(getUserName(), forumUser.getUserName()) && Objects.equals(getDateOfBirth(), forumUser.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        result = 31 * result + peselId;
        return result;
    }
}
