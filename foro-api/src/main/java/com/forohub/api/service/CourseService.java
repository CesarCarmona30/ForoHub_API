package com.forohub.api.service;

import com.forohub.api.domain.course.Course;
import com.forohub.api.domain.course.CourseRepository;
import com.forohub.api.domain.course.CourseRequestDTO;
import com.forohub.api.domain.course.CourseResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getName(),
                        course.getCategory()
                ))
                .collect(Collectors.toList());
    }

    public void createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course(courseRequestDTO);
        courseRepository.save(course);
    }

    public void updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        course.setName(courseRequestDTO.name());
        course.setCategory(courseRequestDTO.category());
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        courseRepository.delete(course);
    }
}
