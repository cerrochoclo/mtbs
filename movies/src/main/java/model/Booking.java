package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Booking(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id,
        int showtimeId,
        int seatNumber,
        int userId,
        float price) {}


//id          SERIAL PRIMARY KEY,
//showtime_id INT REFERENCES showtime (id),
//seat_number INT,
//user_id     INT REFERENCES mtbsuser (id),
//price       NUMERIC(10, 2)
