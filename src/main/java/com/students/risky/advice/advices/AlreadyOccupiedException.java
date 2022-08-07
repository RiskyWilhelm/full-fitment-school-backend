package com.students.risky.advice.advices;

public class AlreadyOccupiedException extends RuntimeException{
    public AlreadyOccupiedException(String message) {
        super(message);
    }
}
