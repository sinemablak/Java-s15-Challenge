package com.library.enums;

public enum BorrowingPeriod {
    STUDENT(30),
    FACULTY(60),
    DEFAULT(14);

    private final int days;

    BorrowingPeriod(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
