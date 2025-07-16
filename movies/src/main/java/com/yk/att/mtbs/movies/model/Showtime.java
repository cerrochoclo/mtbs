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
public class Showtime implements MtbsEntity<Showtime> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Integer movieId;
        private Integer theatreId;
        private OffsetDateTime startTime;
        private OffsetDateTime endTime;
        private Integer maxSeats;
        private boolean isDeleted;

        @Override
        public Showtime copy(boolean forceIsDeleted) {
                return new Showtime(this.id,
                        this.movieId,
                        this.theatreId,
                        this.startTime,
                        this.endTime,
                        this.maxSeats,
                        forceIsDeleted || this.isDeleted
                );
        }

        @Override
        public boolean getIsDeleted() {
                return this.isDeleted;
        }
}



//id         SERIAL PRIMARY KEY,
//movie_id   INT REFERENCES movie (id),
//theatre_id INT REFERENCES theatre (id),
//start_time TIMESTAMP,
//end_time   TIMESTAMP,