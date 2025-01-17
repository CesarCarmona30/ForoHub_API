package com.forohub.api.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByAuthorId(Long authorId);
    List<Topic> findByCourseId(Long courseId);
}
