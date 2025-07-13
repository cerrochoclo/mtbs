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
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int showtimeId;
        private int seatNumber;
        private int userId;
        private float price;
}


//id          SERIAL PRIMARY KEY,
//showtime_id INT REFERENCES showtime (id),
//seat_number INT,
//user_id     INT REFERENCES mtbsuser (id),
//price       NUMERIC(10, 2)
