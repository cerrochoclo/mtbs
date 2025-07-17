package com.yk.att.mtbs.movies.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ShowtimeDto(Integer id, @NotNull Integer movieId, @NotNull Integer theatreId, @NotNull OffsetDateTime startTime, @NotNull OffsetDateTime endTime, @NotNull Integer maxSeats) {}