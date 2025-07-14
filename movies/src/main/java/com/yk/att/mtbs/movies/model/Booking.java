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
public class Booking implements MtbsEntity<Booking> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Integer showtimeId;
        private Integer seatNumber;
        private Integer userId;
        private Float price;
        private boolean isDeleted;

        @Override
        public Booking copy(boolean forceIsDeleted) {
                return new Booking(this.id,
                        this.showtimeId,
                        this.seatNumber,
                        this.userId,
                        this.price,
                        forceIsDeleted || this.isDeleted);
        }

        @Override
        public boolean getIsDeleted() {
                return this.isDeleted;
        }
}


//id          SERIAL PRIMARY KEY,
//showtime_id INT REFERENCES showtime (id),
//seat_number INT,
//user_id     INT REFERENCES mtbsuser (id),
//price       NUMERIC(10, 2)
