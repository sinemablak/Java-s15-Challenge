package com.library.personnel;

import com.library.books.Book;
import com.library.enums.BookStatus;
import com.library.enums.BorrowingPeriod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private List<Book> borrowedBooks;
    private BorrowingPeriod borrowingPeriod;

    public Reader(String name, String surname) {
        super(name, surname);
        this.borrowedBooks = new ArrayList<>();
    }

    public Reader(String name, String surname, long TCKN, String phoneNumber, String email) {
        super(name, surname, TCKN, phoneNumber, email);
        this.borrowedBooks = new ArrayList<>();
    }

    public Reader(String name, String surname, long TCKN, String phoneNumber, String email, List<Book> borrowedBooks) {
        super(name, surname, TCKN, phoneNumber, email);
        this.borrowedBooks = borrowedBooks != null ? borrowedBooks : new ArrayList<>();
    }
    public Reader(String name, BorrowingPeriod borrowingPeriod) {
        super(name, ""); // Assuming Person's other fields can be empty or default
        this.borrowedBooks = new ArrayList<>();
        this.borrowingPeriod = borrowingPeriod;
    }


    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
    public void purchaseBook(Book book){
        borrowedBooks.add(book);
        book.changeOwner(this);
        this.borrowingPeriod = BorrowingPeriod.DEFAULT;
    }
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 5) {
            if (book.getStatus() == BookStatus.AVAILABLE) {
                borrowedBooks.add(book);
                book.updateStatus(BookStatus.BORROWED);
                book.setOwner(this);
                LocalDate dueDate = LocalDate.now().plusDays(borrowingPeriod.getDays()); // Use borrowingPeriod field
                System.out.println("Successfully borrowed book: " + book.getTitle() +
                        ". Please return it by: " + dueDate);
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
