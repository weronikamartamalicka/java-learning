package com.kodilla.good.paterns.challenges.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library> {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library copiedLibrary = super.clone();
        copiedLibrary.books = new HashSet<>();

        for(Book book : books) {
            copiedLibrary.getBooks().add(book);
        }
        return copiedLibrary;
    }
}
