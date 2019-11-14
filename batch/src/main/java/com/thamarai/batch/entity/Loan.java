package com.thamarai.batch.entity;

import java.util.*;

public class Loan {

    private Long id;

    private Date date;

    private int isSecondLoan;

    private int copy;

    public Loan() {
    }

    public Loan(Date date, int isSecondLoan, int copy) {
        this.date = date;
        this.isSecondLoan = isSecondLoan;
        this.copy = copy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIsSecondLoan() {
        return isSecondLoan;
    }

    public void setIsSecondLoan(int isSecondLoan) {
        this.isSecondLoan = isSecondLoan;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }
}
