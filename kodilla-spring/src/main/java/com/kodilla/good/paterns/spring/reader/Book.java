package com.kodilla.good.paterns.spring.reader;

public final class Book {
    private final String title;

    public Book(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
