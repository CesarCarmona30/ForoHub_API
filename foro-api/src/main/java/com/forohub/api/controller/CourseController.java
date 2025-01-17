package com.forohub.api.controller;

import com.forohub.api.domain.course.CourseRequestDTO;
import com.forohub.api.domain.course.CourseResponseDTO;
import com.forohub.api.service.CourseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.createCourse(courseRequestDTO);
        return ResponseEntity.ok("Curso creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.updateCourse(id, courseRequestDTO);
        return ResponseEntity.ok("Curso actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Curso eliminado correctamente");
    }
}
