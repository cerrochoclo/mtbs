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
public class Movie implements MtbsEntity<Movie>{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String title;
        private String genre;
        private Integer duration;
        private String rating;
        private Integer releaseYear;
        private boolean isDeleted;

        @Override
        public Movie copy(boolean forceIsDeleted) {
                return new Movie(this.id,
                        this.title,
                        this.genre,
                        this.duration,
                        this.rating,
                        this.releaseYear,
                        forceIsDeleted || this.isDeleted);
        }

        @Override
        public boolean getIsDeleted() {
                return this.isDeleted;
        }
}


//id           SERIAL PRIMARY KEY,
//title        VARCHAR(255),
//duration     INT,
//rating       VARCHAR(5),
//release_year INT
