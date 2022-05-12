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

        List<Book> resultListOf0Books = new ArrayList<Book>();

        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionLessThan3() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());

        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfReturnList0() {

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser libraryUserOne = new LibraryUser("Katarzyna", "Berg", 35178, 0);
        LibraryUser libraryUserTwo = new LibraryUser("Katarzyna", "Berg", 35478, 5);
        LibraryUser libraryUserThree = new LibraryUser("Katarzyna", "Berg", 32178, 1);

        List<Book> resultListOf5Book = generateListOfNBooks(5);
        List<Book> resultListOf1Book = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserTwo)).thenReturn(resultListOf5Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserThree)).thenReturn(resultListOf1Book);

        List<Book> resultListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUserOne);
        List<Book> resultListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUserTwo);
        List<Book> resultListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUserThree);

        assertEquals(0,resultListOfBooks0.size());
        assertEquals(5,resultListOfBooks5.size());
        assertEquals(1,resultListOfBooks1.size());
    }
}
