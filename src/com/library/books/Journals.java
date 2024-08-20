package com.library.books;

import com.library.personnel.Author;

import java.time.LocalDate;

public class Journals extends  Book{
    public Journals(String book_ID, Author author, String name, double price, BookStatus status, String edition, LocalDate dateOfPurchase) {
        super(book_ID, author, name, price, status, edition, dateOfPurchase);
    }

    @Override
    public void showDetails() {
        System.out.println("Journal - ID: " + getBook_ID() + ", Name: " + getName() + ", Author: " + getAuthor().getName());
    }
}
