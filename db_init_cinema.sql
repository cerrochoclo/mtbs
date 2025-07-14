
CREATE DATABASE mtbs;
\c mtbs
CREATE ROLE app_user WITH LOGIN PASSWORD 'password';
ALTER ROLE app_user CREATEDB CREATEROLE;
GRANT ALL PRIVILEGES ON DATABASE mtbs TO app_user;

CREATE TABLE movie
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255),
    genre        VARCHAR(255),
    duration     INT,
    rating       VARCHAR(5),
    release_year INT,
    is_deleted   BOOLEAN DEFAULT FALSE
);
CREATE TABLE theatre
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE showtime
(
    id         SERIAL PRIMARY KEY,
    movie_id   INT REFERENCES movie (id) ON DELETE CASCADE ,
    theatre_id INT REFERENCES theatre (id) ON DELETE CASCADE,
    start_time TIMESTAMP,
    end_time   TIMESTAMP,
    is_deleted   BOOLEAN DEFAULT FALSE,

    UNIQUE (movie_id, theatre_id, start_time)
);

CREATE TABLE booking
(
    id          SERIAL PRIMARY KEY,
    showtime_id INT REFERENCES showtime (id) ON DELETE CASCADE,
    seat_number INT,
    user_id     INT,
    price       NUMERIC(10, 2),
    is_deleted   BOOLEAN DEFAULT FALSE
);
ALTER TABLE movie OWNER TO app_user;
ALTER TABLE showtime OWNER TO app_user;
ALTER TABLE theatre OWNER TO app_user;
ALTER TABLE booking OWNER TO app_user;


INSERT INTO movie(id, title, duration, rating, release_year, is_deleted) VALUES(1,'Back to The Future 2',108,'PG-13',1989, false);
INSERT INTO movie(id, title, duration, rating, release_year, is_deleted)
VALUES (2,'Hagiga Basnooker', 95, 'R', 1975, false);
INSERT INTO theatre(id,name)
VALUES (1,'Cinema City Glilot');
INSERT INTO theatre(id,name)
VALUES (2,'Rav Chen Dizengoff');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (1,1, 1, '2025-07-12 18:30:00', '2025-07-12 20:30:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (2,1, 1, '2025-07-12 21:00:00', '2025-07-12 23:00:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (3,1, 2, '2025-07-13 10:30:00', '2025-07-13 12:30:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (4,1, 2, '2025-07-13 13:00:00', '2025-07-13 15:00:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (5,2, 1, '2025-07-12 18:30:00', '2025-07-12 20:30:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (6,2, 1, '2025-07-14 21:59:00', '2025-07-14 23:59:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (7,2, 2, '2025-07-15 10:30:00', '2025-07-15 12:30:00', false);
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time, is_deleted)
VALUES (8,2, 2, '2025-07-12 13:00:00', '2025-07-12 15:00:00', false);

SELECT setval(pg_get_serial_sequence('movie', 'id'), max(id)) FROM movie;
SELECT setval(pg_get_serial_sequence('showtime', 'id'), max(id)) FROM showtime;
SELECT setval(pg_get_serial_sequence('booking', 'id'), max(id)) FROM booking;


