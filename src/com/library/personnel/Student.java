package com.library.personnel;

import com.library.enums.BorrowingPeriod;

public class Student extends Person{
    public Student(String name) {
        super(name);
        this.setBorrowingPeriod(BorrowingPeriod.STUDENT);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Student named " + getName());
    }
}
