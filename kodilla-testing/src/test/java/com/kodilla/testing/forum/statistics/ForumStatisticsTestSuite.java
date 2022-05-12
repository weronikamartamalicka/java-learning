package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@Nested
@DisplayName("ForumStatisticsTestSuite")
@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void beforeEach() {

    }
    @Nested
    @DisplayName("ForumStatisticsPostAndComments")
    class ForumStatisticsPostAndComments {

        @Test
        public void calculateAdvStatistics0Posts(Statistics statisticsMock) {

        }

        @Test
        public void calculateAdvStatistics1000Posts(Statistics statisticsMock) {

        }

        @Test
        public void calculateAdvStatistics0Comments(Statistics statisticsMock) {

        }

        @Test
        public void calculateAdvStatisticsLessCommentsThanPosts(Statistics statisticsMock) {

        }

        @Test
        public void calculateAdvStatisticsLessPostsThanComments(Statistics statisticsMock) {

        }
    }

    @Nested
    @DisplayName("ForumStatisticsUsers")
    class ForumStatisticsUsers {

        @Test
        public void calculateAdvStatistics0Users(Statistics statisticsMock) {

        }

        @Test
        public void calculateAdvStatistics100Users(Statistics statisticsMock) {

        }
    }
}
