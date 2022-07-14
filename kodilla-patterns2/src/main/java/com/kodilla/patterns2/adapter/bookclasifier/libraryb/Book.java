package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Objects;

public class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;

    public Book(final String author, final String title, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublication == book.yearOfPublication && author.equals(book.author) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, yearOfPublication);
    }
}
