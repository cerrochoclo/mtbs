package model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record Movie(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id,
        String title,
        String genre,
        int duration,
        String rating,
        int releaseYear) {}


//id           SERIAL PRIMARY KEY,
//title        VARCHAR(255),
//duration     INT,
//rating       VARCHAR(5),
//release_year INT
