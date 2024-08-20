package com.library.personnel;

import com.library.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String name, String surname, long TCKN, String phoneNumber, String email, List<Book> books) {
        super(name, surname, TCKN, phoneNumber, email);
        this.books = books;
    }

    public void newBook(Book book){
        books.add(book);
    }
    public void showBooks(){
        for (Book book:books){
            book.display();
        }
    }
    @Override
    public void whoYouAre() {
        System.out.println("I am an Author named " + getName());
    }

}
