package com.kodilla.good.paterns.testing.forum;

import java.util.*;

public class ForumUser {
    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();;

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        ForumPost forumPost = new ForumPost(postBody, author);
        posts.add(forumPost);
    }

    public void addComment(ForumPost forumPost, String author, String commentBody) {
        ForumComment forumComment = new ForumComment(commentBody, author, forumPost);
        comments.add(forumComment);
    }

    public int getPostQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public ForumPost getPosts(int postNumber) {
        if(postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getComments(int commentNumber) {
        if(commentNumber >= 0 && commentNumber < comments.size()) {
            return comments.get(commentNumber);
        }
        return null;
    }

    public boolean removePost(ForumPost forumPost) {
        if(posts.contains(forumPost)) {
            posts.remove(forumPost);
            return true;
        }
        return false;
    }

    public boolean removeComment(ForumComment forumComment) {
        if(comments.contains(forumComment)) {
            comments.remove(forumComment);
            return true;
        }
        return false;
    }

}
