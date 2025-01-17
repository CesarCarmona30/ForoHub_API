package com.forohub.api.controller;

import com.forohub.api.domain.answer.AnswerRequestDTO;
import com.forohub.api.domain.answer.AnswerResponseDTO;
import com.forohub.api.service.AnswerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    // Crear una nueva respuesta
    @PostMapping
    public ResponseEntity<AnswerResponseDTO> createAnswer(@RequestBody @Valid AnswerRequestDTO request) {
        AnswerResponseDTO createdAnswer = answerService.createAnswer(request);
        return ResponseEntity.status(201).body(createdAnswer);
    }

    // Actualizar una respuesta existente
    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> updateAnswer(@PathVariable Long id, @RequestBody @Valid AnswerRequestDTO request) {
        AnswerResponseDTO updatedAnswer = answerService.updateAnswer(id, request);
        return ResponseEntity.ok(updatedAnswer);
    }

    // Eliminar una respuesta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

    // Listar todas las respuestas
    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> listAnswers() {
        List<AnswerResponseDTO> answers = answerService.listAnswers();
        return ResponseEntity.ok(answers);
    }

    // Obtener una respuesta específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> getAnswerById(@PathVariable Long id) {
        AnswerResponseDTO answer = answerService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }
}
