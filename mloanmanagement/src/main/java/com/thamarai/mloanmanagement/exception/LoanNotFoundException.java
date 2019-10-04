package com.thamarai.mloanmanagement.exception;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String s) {
        super(s);
    }
}
