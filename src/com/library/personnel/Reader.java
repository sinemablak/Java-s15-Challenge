package com.library.personnel;

import com.library.books.Book;
import com.library.books.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private List<Book> borrowedBooks;

    public Reader(String name, String surname, List<Book> borrowedBooks) {
        super(name, surname);
        this.borrowedBooks = borrowedBooks;
    }
    public Reader(String name, String surname, long TCKN, String phoneNumber, String email, List<Book> borrowedBooks) {
        super(name, surname, TCKN, phoneNumber, email);
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
    public void purchaseBook(Book book){
        borrowedBooks.add(book);
        book.changeOwner(this);
    }
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 5) {
            if (book.getStatus() == BookStatus.AVAILABLE) {
                borrowedBooks.add(book);
                book.updateStatus(BookStatus.BORROWED);
                book.setOwner(this);
                System.out.println("Successfully borrowed book: " + book.getTitle());
            } else {
                System.out.println("The book is not available for borrowing.");
            }
        } else {
            System.out.println("Cannot borrow more than 5 books.");
        }
    }
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.updateStatus(BookStatus.AVAILABLE);
            book.setOwner(null);
            System.out.println("Successfully returned book: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }
    public void showBook(Book book) {
        System.out.println("Book ID: " + book.getBook_ID());
        System.out.println("Author: " + book.getAuthor().getName());
        System.out.println("Name: " + book.getName());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Status: " + book.getStatus());
        System.out.println("Edition: " + book.getEdition());
        System.out.println("Date of Purchase: " + book.getDateOfPurchase());

        if (book.getOwner() != null) {
            System.out.println("Owner: " + book.getOwner().getName());
        } else {
            System.out.println("Owner: Not assigned");
        }
    }


    @Override
    public void whoYouAre() {
        System.out.println("I am a Reader named " + getName());

    }
}
