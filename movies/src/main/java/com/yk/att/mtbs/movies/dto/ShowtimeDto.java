package com.yk.att.mtbs.movies.dto;

import java.time.OffsetDateTime;

public record ShowtimeDto(Integer id, Integer movieId, Integer theatreId, OffsetDateTime startTime, OffsetDateTime endTime) {}