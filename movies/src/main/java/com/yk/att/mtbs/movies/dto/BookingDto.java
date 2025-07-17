package com.yk.att.mtbs.movies.dto;

import jakarta.validation.constraints.NotNull;

public record BookingDto(Integer id, @NotNull Integer showtimeId, @NotNull Integer seatNumber, @NotNull String userName, @NotNull Float price) {}
