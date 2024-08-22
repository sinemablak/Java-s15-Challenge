package com.library.operations;

import com.library.books.Book;
import com.library.personnel.Reader;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<MemberRecord> memberRecords;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.memberRecords = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateBook(Book book) {
        // Implement book update logic here
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        memberRecords.add(new MemberRecord(reader));
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
        memberRecords.removeIf(record -> record.getReader().equals(reader));
    }

    public Book findBookByID(String bookID) {
        return books.stream().filter(book -> book.getBook_ID().equals(bookID)).findFirst().orElse(null);
    }
}
