package com.example.springbootproject.repository;

import com.example.springbootproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
    List<Course> findAllById(Long id);
}
