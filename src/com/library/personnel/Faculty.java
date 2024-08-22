package com.library.personnel;

import com.library.enums.BorrowingPeriod;

public class Faculty extends Person{
    public Faculty(String name) {
        super(name);
        this.setBorrowingPeriod(BorrowingPeriod.FACULTY);
    }
    @Override
    public void whoYouAre() {
        System.out.println("I am a Faculty member named " + getName());
    }
}
