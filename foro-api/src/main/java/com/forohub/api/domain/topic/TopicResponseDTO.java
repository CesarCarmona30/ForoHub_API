package com.forohub.api.domain.topic;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponseDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        Long authorId,
        Long courseId,
        List<Long> answers
) {}