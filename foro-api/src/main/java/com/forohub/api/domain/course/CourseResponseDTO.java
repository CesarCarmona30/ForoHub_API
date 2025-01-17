package com.forohub.api.domain.course;

public record CourseResponseDTO(
        Long id,
        String name,
        Category category
) {
}
