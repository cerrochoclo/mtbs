package com.yk.att.mtbs.movies.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ShowtimeDto(@NotNull Integer id, @NotNull Integer movieId, @NotNull Integer theatreId, @NotNull OffsetDateTime startTime, @NotNull OffsetDateTime endTime) {}