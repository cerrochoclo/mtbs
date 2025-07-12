CREATE TABLE movie (
	id SERIAL PRIMARY KEY,
	title VARCHAR(255),
	duration INT,
	rating INT,
	release_year INT
)
CREATE TABLE showtime (
	id SERIAL PRIMARY KEY,
	movie_id INT REFERENCES movie(id),
	theatre_id INT REFERENCES theatre(id),
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	UNIQUE(movie_id,theatre_id,start_time)
)
CREATE TABLE theatre (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
)
CREATE TABLE user (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	email VARCHAR(255),
	password VARCHAR(100)
)
CREATE TABLE userroles (
	user_id INT REFERENCES user(id) PRIMARY KEY,
	role_id INT REFERENCES role(id) PRIMARY KEY
)
CREATE TABLE role (
	id SERIAL PRIMARY KEY
	name VARCHAR(255)
)
CREATE TABLE booking (
	id SERIAL PRIMARY KEY,
	movie_id INT REFERENCES showtime(movie_id),
	theatre_id INT REFERENCES showtime(theatre_id),
	start_time TIMESTAMP REFERENCES showtime(start_time),
	seat_number INT,
	user_id INT REFERENCES user(id),
	price NUMERIC(10,2),
	UNIQUE(movie_id,theatre_id,start_time,seat_number)
)


