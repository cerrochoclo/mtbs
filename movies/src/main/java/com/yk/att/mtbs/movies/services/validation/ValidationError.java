package com.yk.att.mtbs.movies.services.validation;

import lombok.Getter;

@Getter
public enum ValidationError {
    THEATRE_CONFLICTING_SHOWTIMES("There are Conflicting Shows at the theatre");

    private final String message;


    ValidationError(String message) {
        this.message = message;
    }

}
