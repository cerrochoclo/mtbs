package com.yk.att.mtbs.movies.dto;

import java.time.OffsetDateTime;

public record ShowtimeDto(int id, int movieId, int theatreId, OffsetDateTime startTime, OffsetDateTime endTime) {}