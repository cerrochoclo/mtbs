package model;

public record Booking(int id, int showtimeId, int seatNumber, int userId, float price) {}


//id          SERIAL PRIMARY KEY,
//showtime_id INT REFERENCES showtime (id),
//seat_number INT,
//user_id     INT REFERENCES mtbsuser (id),
//price       NUMERIC(10, 2)
