package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    public void testListBooksWithConditionReturnList() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {

        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultListOf0Books = new ArrayList<>();

        List<Book> resultListOf15Book = generateListOfNBooks(15);
        List<Book> resultListOf40Book = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Book);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("Forty Books")).thenReturn(resultListOf40Book);

        List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("Zero Books");
        List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("Forty Books");

        assertEquals(0,theListOf0Books.size());
        assertEquals(15,theListOf15Books.size());
        assertEquals(0,theListOf40Books.size());
    }

    @Test
    public void testListBooksWithConditionLessThan3() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfReturnList() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUserOne = new LibraryUser("Katarzyna", "Berg", 35178);
        LibraryUser libraryUserTwo = new LibraryUser("Katarzyna", "Ferg", 35658);
        LibraryUser libraryUserThree = new LibraryUser("Katarzyna", "Kerg", 35908);

        List<Book> resultListOf0Book = new ArrayList<>();
        List<Book> resultListOf5Book = generateListOfNBooks(5);
        List<Book> resultListOf1Book = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserThree)).thenReturn(resultListOf0Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserOne)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserTwo)).thenReturn(resultListOf5Book);

        assertEquals(0,bookLibrary.listBooksInHandsOf(libraryUserThree).size());
        assertEquals(1,bookLibrary.listBooksInHandsOf(libraryUserOne).size());
        assertEquals(5,bookLibrary.listBooksInHandsOf(libraryUserTwo).size());

        verify(libraryDatabaseMock, times(0)).listBooksInHandsOf(libraryUserThree);
    }
}
