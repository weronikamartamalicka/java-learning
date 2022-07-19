package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {

        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = 'Not set'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        String sqlCheck = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = 'Not set'";
        ResultSet resultSet = statement.executeQuery(sqlCheck);

        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }

        assertEquals(howMany, 0);
        resultSet.close();
        statement.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        statement.executeUpdate(sqlUpdate);

        String sqlProcedure = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedure);

        String sqlQuery = "SELECT COUNT(*) FROM BOOKS AS HOW_MANY_NOT_BESTSELLERS WHERE BESTSELLER = 0";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY_NOT_BESTSELLERS");
        }
        assertEquals(0,howMany);
        resultSet.close();
        statement.close();
    }
}
