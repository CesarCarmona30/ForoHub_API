package com.forohub.api.service;

import com.forohub.api.domain.answer.Answer;
import com.forohub.api.domain.answer.AnswerRepository;
import com.forohub.api.domain.answer.AnswerRequestDTO;
import com.forohub.api.domain.answer.AnswerResponseDTO;
import com.forohub.api.domain.topic.Topic;
import com.forohub.api.domain.topic.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final TopicRepository topicRepository;

    public AnswerService(AnswerRepository answerRepository, TopicRepository topicRepository) {
        this.answerRepository = answerRepository;
        this.topicRepository = topicRepository;
    }

    public AnswerResponseDTO createAnswer(AnswerRequestDTO answerRequestDTO) {
        // Buscar el Topic relacionado
        Topic topic = topicRepository.findById(answerRequestDTO.topicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        // Crear la nueva Answer
        Answer answer = new Answer(answerRequestDTO, topic);

        // Guardar la Answer en la base de datos
        answerRepository.save(answer);

        // Convertir a DTO y devolver
        return new AnswerResponseDTO(answer);
    }

    // Actualizar una respuesta existente
    public AnswerResponseDTO updateAnswer(Long id, AnswerRequestDTO request) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with ID: " + id));
        answer.setMessage(request.message());
        answer.setTopicId(request.topicId());
        answerRepository.save(answer);
        return new AnswerResponseDTO(answer);
    }

    // Eliminar una respuesta
    public void deleteAnswer(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with ID: " + id));
        answerRepository.delete(answer);
    }

    // Listar todas las respuestas
    public List<AnswerResponseDTO> listAnswers() {
        return answerRepository.findAll().stream()
                .map(AnswerResponseDTO::new)
                .collect(Collectors.toList());
    }

    // Obtener una respuesta específica por ID
    public AnswerResponseDTO getAnswerById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with ID: " + id));
        return new AnswerResponseDTO(answer);
    }
}
