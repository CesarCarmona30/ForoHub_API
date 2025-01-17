package com.forohub.api.domain.answer;

import com.forohub.api.domain.topic.Topic;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    private LocalDateTime createdDate;
    private Long authorId;
    private Boolean solution;

    public Answer(AnswerRequestDTO answerRequestDTO, Topic topic) { }

    public Answer(AnswerRequestDTO answerRequestDTO) {
        this.message = answerRequestDTO.message();
        this.topic = topic;
        this.createdDate = LocalDateTime.now();
        this.authorId = answerRequestDTO.authorId();
        this.solution = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Boolean getSolution() {
        return solution;
    }

    public void setSolution(Boolean solution) {
        this.solution = solution;
    }

    public void setTopicId(Long topicId) {
        topic.setId(topicId);
    }
}
