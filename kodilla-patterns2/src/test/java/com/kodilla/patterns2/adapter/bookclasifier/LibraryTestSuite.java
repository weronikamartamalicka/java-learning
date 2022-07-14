package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void publicationYearMedianTest() {

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Katarzyna Katarzyna", "Kowalski kowalska",
                2003, "VPN2349"));
        bookSet.add(new Book("Katarzyna Paciorkowska", "Kowalski kowal",
                2001, "FJK8373"));
        bookSet.add(new Book("Katarzyna Katarzyn", "Kowalski kowal kowale",
                1995, "VHG5639"));
        bookSet.add(new Book("Katarzyna Kat", "Kowalski kowal kowale Kowalskiego",
                2003, "GHJ4628"));

        MedianAdapter adapter = new MedianAdapter();

        int median = adapter.publicationYearMedian(bookSet);

        assertEquals(2003, median);
    }
}
