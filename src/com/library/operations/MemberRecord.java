package com.library.operations;

import com.library.books.Book;
import com.library.personnel.Reader;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MemberRecord {
    private Reader reader;
    private Map<Book, LocalDate> borrowedBooks;

    public MemberRecord(Reader reader) {
        this.reader = reader;
        this.borrowedBooks = new HashMap<>();
    }

    public void addRecord(Book book, LocalDate returnDate) {
        borrowedBooks.put(book, returnDate);
    }

    public void removeRecord(Book book) {
        borrowedBooks.remove(book);
    }

    public Map<Book, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Reader getReader() {
        return reader;
    }
}
