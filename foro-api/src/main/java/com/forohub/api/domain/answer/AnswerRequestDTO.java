package com.forohub.api.domain.answer;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerRequestDTO(
        @NotNull Long topicId,
        @NotBlank String message,
        @NotNull Long authorId
) { }