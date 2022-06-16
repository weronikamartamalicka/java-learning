package com.kodilla.good.patterns.challenges.singletone;

public enum Logger {
    INSTANCE;
    private String lastLog = "";

    public void log(final String log) {
        this.lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}
