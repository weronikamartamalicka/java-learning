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

        Statement statementTwo = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statementTwo.execute(sqlProcedureCall);

        Statement statementOne = dbManager.getConnection().createStatement();
        String sqlCheck = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = 'Not set'";
        ResultSet resultSet = statementOne.executeQuery(sqlCheck);

        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }

        assertEquals(0, howMany);
        resultSet.close();
        statement.close();
        statementOne.close();
        statementTwo.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        statement.executeUpdate(sqlUpdate);

        String sqlProcedure = "CALL UpdateBestsellers()";
        Statement statementOne = dbManager.getConnection().createStatement();
        statementOne.execute(sqlProcedure);

        Statement statementTwo = dbManager.getConnection().createStatement();
        String sqlQuery = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 0";
        ResultSet resultSet = statementTwo.executeQuery(sqlQuery);

        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        assertEquals(1,howMany);

        resultSet.close();
        statement.close();
        statementOne.close();
        statementTwo.close();
    }
}
