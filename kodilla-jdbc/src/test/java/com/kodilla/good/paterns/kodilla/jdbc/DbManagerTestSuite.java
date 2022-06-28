package com.kodilla.good.paterns.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME"));
            counter ++;
        }
        resultSet.close();
        statement.close();

        assertEquals(6, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException{

        DbManager dbManager = DbManager.getInstance();
        String sqlQuery = "SELECT U.ID, U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_NUMBER\n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY USER_ID HAVING COUNT(*) >= 2";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME") + ", " +
                    resultSet.getInt("POST_NUMBER"));
            counter ++;
        }
        resultSet.close();
        statement.close();

        assertEquals(1, counter);

    }
}
