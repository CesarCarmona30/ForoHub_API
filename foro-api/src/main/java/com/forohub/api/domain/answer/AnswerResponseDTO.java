package com.forohub.api.domain.answer;

import java.time.LocalDateTime;

public record AnswerResponseDTO(
        Long id,
        String message,
        LocalDateTime creationDate,
        Long authorId,
        boolean solution
) {
    public AnswerResponseDTO(Answer answer) {
        this(answer.getId(), answer.getMessage(), LocalDateTime.now(), answer.getAuthorId(), false);
    }
}
