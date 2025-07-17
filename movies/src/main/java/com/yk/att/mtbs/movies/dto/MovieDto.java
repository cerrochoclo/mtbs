package com.yk.att.mtbs.movies.dto;

import jakarta.validation.constraints.NotNull;

public record MovieDto(Integer id, @NotNull String title, String genre, @NotNull Integer duration, String rating, Integer releaseYear) {}