package com.kodilla.testing.forum;

public class ForumComment {

    private String commentBody;
    private String author;
    private ForumPost forumPost;

    public ForumComment(String commentBody, String author, ForumPost forumPost) {
        this.commentBody = commentBody;
        this.author = author;
        this.forumPost = forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumComment)) return false;
        ForumComment that = (ForumComment) o;
        return getCommentBody().equals(that.getCommentBody()) && getAuthor().equals(that.getAuthor()) && getForumPost().equals(that.getForumPost());
    }

    @Override
    public int hashCode() {
        int result = commentBody.hashCode();
        result = 31 * result + forumPost.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
