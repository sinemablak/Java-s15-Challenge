package com.library.personnel;

import com.library.enums.BorrowingPeriod;

public abstract class Person {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private long TCKN;
    private BorrowingPeriod borrowingPeriod;


    public Person(String name,String surname){
        this.name=name;
        this.surname=surname;
        this.TCKN=TCKN;
    }

    public Person(String name, String surname, long TCKN, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.TCKN = TCKN;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(String name) {
        this.name=name;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTCKN() {
        return TCKN;
    }

    public void setTCKN(long TCKN) {
        this.TCKN = TCKN;
    }
    public BorrowingPeriod getBorrowingPeriod() {
        return borrowingPeriod;
    }
    public void setBorrowingPeriod(BorrowingPeriod borrowingPeriod) {
        this.borrowingPeriod = borrowingPeriod;
    }



    public abstract void whoYouAre();

}
