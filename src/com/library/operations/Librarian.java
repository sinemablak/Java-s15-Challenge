package com.library.operations;

import com.library.books.Book;
import com.library.personnel.Person;
import com.library.personnel.Reader;

public class Librarian extends Person {
    public Librarian(String name, String surname, long TCKN, String phoneNumber, String email) {
        super(name, surname, TCKN, phoneNumber, email);
    }

    public void addBook(Book book, Library library) {
        library.addBook(book);
    }

    public void removeBook(Book book, Library library) {
        library.removeBook(book);
    }

    public void updateBook(Book book, Library library) {
        library.updateBook(book);
    }

    public void registerReader(Reader reader, Library library) {
        library.addReader(reader);
    }

    public void deregisterReader(Reader reader, Library library) {
        library.removeReader(reader);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Librarian named " + getName());
    }


}
