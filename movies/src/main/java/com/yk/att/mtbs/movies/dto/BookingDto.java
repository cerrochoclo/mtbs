package com.yk.att.mtbs.movies.dto;

import jakarta.validation.constraints.NotNull;

public record BookingDto(@NotNull Integer id, @NotNull Integer showtimeId, @NotNull Integer seatNumber, @NotNull Integer userId, @NotNull Float price) {}
