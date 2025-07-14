package com.yk.att.mtbs.movies.services;

public class ValidationException extends Throwable {
    public ValidationException(String aggregateMessage) {
        super(aggregateMessage);
    }
}
