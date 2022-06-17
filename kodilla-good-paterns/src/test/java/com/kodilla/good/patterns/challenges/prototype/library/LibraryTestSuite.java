package com.kodilla.good.patterns.challenges.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        Book bookOne = new Book("Morderca w brązowym garniturze", "Michał Wiśniewski", LocalDate.of(2007,05,24));
        Book bookTwo = new Book("Morderca w zielonym garniturze", "Michał Wiśniewski", LocalDate.of(2008,05,24));
        Book bookThree = new Book("Morderca w szarym garniturze", "Michał Wiśniewski", LocalDate.of(2009,05,24));
        Book bookFour = new Book("Morderca w różowym garniturze", "Michał Wiśniewski", LocalDate.of(2010,05,24));
        Book bookFive = new Book("Morderca w czarnym garniturze", "Michał Wiśniewski", LocalDate.of(2011,05,24));

        Library library = new Library("Michał Wiśniewski");

        library.getBooks().add(bookOne);
        library.getBooks().add(bookTwo);
        library.getBooks().add(bookThree);
        library.getBooks().add(bookFour);
        library.getBooks().add(bookFive);

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;

        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Michał Wiśniewski library number two");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Michał Wiśniewski library number three");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        assertEquals(5, library.getBooks().size());
        assertEquals(5, shallowClonedLibrary.getBooks().size());
        assertEquals(5, deepClonedLibrary.getBooks().size());
    }
}
