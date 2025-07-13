package model;

import java.time.OffsetDateTime;

public record Showtime(int id, int movieId, int theatreId, OffsetDateTime startTime, OffsetDateTime endTime) {}



//id         SERIAL PRIMARY KEY,
//movie_id   INT REFERENCES movie (id),
//theatre_id INT REFERENCES theatre (id),
//start_time TIMESTAMP,
//end_time   TIMESTAMP,