package com.kodilla.good.paterns.singletone;

import com.kodilla.good.paterns.challenges.singletone.SettingsFileEngine;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);

        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        boolean result = settingsFileEngine.loadSettings();

        assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        boolean result = settingsFileEngine.saveSettings();

        assertTrue(result);
    }
}
