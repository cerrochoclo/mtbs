
CREATE DATABASE mtsb;
\c mtsb
CREATE TABLE movie
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255),
    duration     INT,
    rating       VARCHAR(5),
    release_year INT
);
CREATE TABLE theatre
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE showtime
(
    id         SERIAL PRIMARY KEY,
    movie_id   INT REFERENCES movie (id),
    theatre_id INT REFERENCES theatre (id),
    start_time TIMESTAMP,
    end_time   TIMESTAMP,
    UNIQUE (movie_id, theatre_id, start_time)
);
CREATE TABLE mtsbuser
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(100)
);
CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE userroles
(
    user_id INT REFERENCES mtsbuser (id),
    role_id INT REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);
CREATE TABLE booking
(
    id          SERIAL PRIMARY KEY,
    showtime_id INT REFERENCES showtime (id),
    seat_number INT,
    user_id     INT REFERENCES mtsbuser (id),
    price       NUMERIC(10, 2)
);



INSERT INTO movie(id, title, duration, rating, release_year) VALUES(1,'Back to The Future 2',108,'PG-13',1989);
INSERT INTO movie(id, title, duration, rating, release_year)
VALUES (2,'Hagiga Basnooker', 95, 'R', 1975);
INSERT INTO theatre(id,name)
VALUES (1,'Cinema City Glilot');
INSERT INTO theatre(id,name)
VALUES (2,'Rav Chen Dizengoff');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (1,1, 1, '2025-07-12 18:30:00', '2025-07-12 20:30:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (2,1, 1, '2025-07-12 21:00:00', '2025-07-12 23:00:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (3,1, 2, '2025-07-13 10:30:00', '2025-07-13 12:30:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (4,1, 2, '2025-07-13 13:00:00', '2025-07-13 15:00:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (5,2, 1, '2025-07-12 18:30:00', '2025-07-12 20:30:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (6,2, 1, '2025-07-14 21:59:00', '2025-07-14 23:59:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (7,2, 2, '2025-07-15 10:30:00', '2025-07-15 12:30:00');
INSERT INTO showtime(id,movie_id, theatre_id, start_time, end_time)
VALUES (8,2, 2, '2025-07-12 13:00:00', '2025-07-12 15:00:00');
INSERT INTO mtsbuser(id,name, email, password)
VALUES (1,'Moshe Cohen', 'moshe.cohen@zmail.com', '123456');
INSERT INTO mtsbuser(id,name, email, password)
VALUES (2,'Avi Levi', 'avi.levi@zmail.com', 'aabbccdd');
INSERT INTO mtsbuser(id,name, email, password)
VALUES (3,'Yigal Boss', 'yigal.boss@theatre.com', '000000');
INSERT INTO role(id,name)
VALUES (1,'user');
INSERT INTO role(id,name)
VALUES (2,'admin');
INSERT INTO userroles(user_id,role_id)
VALUES(1,1);
INSERT INTO userroles(user_id,role_id)
VALUES(2,1);
INSERT INTO userroles(user_id,role_id)
VALUES(3,2);


