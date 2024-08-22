package com.library.books;

import com.library.enums.BookStatus;
import com.library.personnel.Author;
import com.library.personnel.Person;

import java.time.LocalDate;


public abstract class Book {
    private String book_ID;
    private Author author;
    private String name;
    private double price;
    private BookStatus status;
    private String edition;
    private LocalDate dateOfPurchase;
    private Person owner;

    public Book(String book_ID,Author author,String name,double price,BookStatus status,String edition,LocalDate dateOfPurchase){
        this.book_ID=book_ID;
        this.author=author;
        this.name=name;
        this.price=price;
        this.status=status;
        this.edition=edition;
        this.dateOfPurchase=dateOfPurchase;
        this.owner=null;
    }
    public String getBook_ID(){
        return book_ID;
    }
    public void setBook_ID(String book_ID){
        this.book_ID=book_ID;
    }
    public void setAuthor(Author author){
        this.author=author;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    public Person getOwner(){
        return owner;
    }
    public void setOwner(Person owner){
        this.owner=owner;
    }
    //metodlar
    public String getTitle(){
        return name;
    }
    public Author getAuthor(){
        return author;
    }
    public void changeOwner(Person newOwner){
        if(this.status==BookStatus.AVAILABLE){
            this.owner=newOwner;
            this.status=BookStatus.BORROWED;
        }else{
            System.out.println("The book is currently not available for ownership change.");
        }
    }
    public void updateStatus(BookStatus status){
        this.status=status;
    }
    public void display(){
        System.out.println("Book ID: " + book_ID);
        System.out.println("Author: " + author.getName());
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Status: " + status);
        System.out.println("Edition: " + edition);
        System.out.println("Date of Purchase: " + dateOfPurchase);
    }

    public abstract void showDetails();



}
