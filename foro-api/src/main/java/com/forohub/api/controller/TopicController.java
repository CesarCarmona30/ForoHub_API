package com.forohub.api.controller;

import com.forohub.api.domain.topic.TopicRequestDTO;
import com.forohub.api.domain.topic.TopicResponseDTO;
import com.forohub.api.service.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<String> createTopic(@RequestBody TopicRequestDTO topicRequestDTO) {
        topicService.createTopic(topicRequestDTO);
        return ResponseEntity.ok("Tópico creado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<TopicResponseDTO>> getTopicsByAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(topicService.getTopicsByAuthor(authorId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TopicResponseDTO>> getTopicsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(topicService.getTopicsByCourse(courseId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<String> resolveTopic(@PathVariable Long id) {
        topicService.resolveTopic(id);
        return ResponseEntity.ok("Tópico marcado como resuelto");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok("Tópico eliminado correctamente");
    }

}
