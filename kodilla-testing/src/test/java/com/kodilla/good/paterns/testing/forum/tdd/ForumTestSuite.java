package com.kodilla.good.paterns.testing.forum.tdd;

import com.kodilla.good.paterns.testing.forum.ForumComment;
import com.kodilla.good.paterns.testing.forum.ForumPost;
import com.kodilla.good.paterns.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@Nested
@DisplayName("TDD: Forum Test Suite \uD83D\uDE31")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter ++;
        System.out.println("Preparing to execute the test number # " + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

        @Test
        public void testAddPost() {
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");

            forumUser.addPost("mrsmith", "Hello everyone");

            Assertions.assertEquals(1, forumUser.getPostQuantity());
        }

        @Test
        public void testGetPost() {
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");

            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            ForumPost retrievedPost;
            retrievedPost = forumUser.getPosts(0);

            Assertions.assertEquals(forumPost, retrievedPost);
        }

        @Test
        public void testRemovePostNotExisting() {
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");

            boolean result = forumUser.removePost(forumPost);

            Assertions.assertFalse(result);
        }

        @Test
        public void testRemovePost() {
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");

            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            boolean result = forumUser.removePost(forumPost);

            Assertions.assertTrue(result);
            Assertions.assertEquals(0,forumUser.getPostQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestsForComments {

        @Test
        public void testAddComment() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");

            forumUser.addComment(forumPost, "mrsmith", "Nice to meet you too!");

            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        public void testGetComments() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");
            ForumComment forumComment = new ForumComment("Nice to meet you too!", "mrsmith", forumPost);

            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            ForumComment retrievedComment = forumUser.getComments(0);

            Assertions.assertEquals(forumComment, retrievedComment);
        }

        @Test
        public void testRemoveCommentNotExisting() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");
            ForumComment forumComment = new ForumComment("Nice to meet you too!", "mrsmith", forumPost);

            boolean result = forumUser.removeComment(forumComment);

            Assertions.assertFalse(result);
        }

        @Test
        public void testRemoveComment() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone", "mrsmith");
            ForumComment forumComment = new ForumComment("Nice to meet you too!", "mrsmith", forumPost);

            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            boolean result = forumUser.removeComment(forumComment);

            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}


