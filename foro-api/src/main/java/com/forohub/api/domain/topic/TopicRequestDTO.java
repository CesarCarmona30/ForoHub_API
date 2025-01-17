package com.forohub.api.domain.topic;

import com.forohub.api.domain.answer.Answer;
import com.forohub.api.domain.course.Course;
import com.forohub.api.domain.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record TopicRequestDTO(
        @NotBlank String title,
        @NotBlank String message,
        @NotNull @Valid Long authorId,
        @NotNull @Valid Long courseId
) { }