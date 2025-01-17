package com.forohub.api.service;

import com.forohub.api.domain.answer.Answer;
import com.forohub.api.domain.topic.Topic;
import com.forohub.api.domain.topic.TopicRepository;
import com.forohub.api.domain.topic.TopicRequestDTO;
import com.forohub.api.domain.topic.TopicResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void createTopic(TopicRequestDTO topicRequestDTO) {
        var topic = new Topic(topicRequestDTO);
        topicRepository.save(topic);
    }

    public List<TopicResponseDTO> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TopicResponseDTO> getTopicsByAuthor(Long authorId) {
        return topicRepository.findByAuthorId(authorId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TopicResponseDTO> getTopicsByCourse(Long courseId) {
        return topicRepository.findByCourseId(courseId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public void resolveTopic(Long id) {
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
        topic.setStatus(true); // Marcar como resuelto
        topicRepository.save(topic);
    }

    private TopicResponseDTO convertToResponseDTO(Topic topic) {
        List<Long> answerIds = topic.getAnswers().stream()
                .map(Answer::getId) // Extraer el ID de cada respuesta
                .toList();

        return new TopicResponseDTO(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus() ? "Resuelto" : "No resuelto",
                topic.getAuthorId(),
                topic.getCourseId(),
                answerIds
        );
    }

    public void deleteTopic(Long id) {
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
        topicRepository.delete(topic);
    }

}
