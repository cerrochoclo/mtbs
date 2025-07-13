package com.yk.att.mtbs.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Showtime {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int movieId;
        private int theatreId;
        private OffsetDateTime startTime;
        private OffsetDateTime endTime;
}



//id         SERIAL PRIMARY KEY,
//movie_id   INT REFERENCES movie (id),
//theatre_id INT REFERENCES theatre (id),
//start_time TIMESTAMP,
//end_time   TIMESTAMP,