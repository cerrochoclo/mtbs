package com.yk.att.mtbs.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
        private String genre;
        private int duration;
        private String rating;
        private int releaseYear;
}


//id           SERIAL PRIMARY KEY,
//title        VARCHAR(255),
//duration     INT,
//rating       VARCHAR(5),
//release_year INT
