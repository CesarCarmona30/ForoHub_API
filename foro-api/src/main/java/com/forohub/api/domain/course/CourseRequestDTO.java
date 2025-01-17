package com.forohub.api.domain.course;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequestDTO(
        @NotBlank String name,
        @NotNull @Valid Category category
) { }