package com.kodilla.good.patterns.singletone;

import com.kodilla.good.patterns.challenges.singletone.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void saveLastLog() {
        logger = Logger.INSTANCE;
        logger.log("testLog");
        System.out.println("Last log saved");
    }

    @Test
    public void testGetLastLog() {
        String lastLog = logger.getLastLog();

        System.out.println(lastLog);
        assertEquals("testLog", lastLog);
    }
}
