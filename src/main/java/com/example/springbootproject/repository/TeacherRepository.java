package com.example.springbootproject.repository;

import com.example.springbootproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findById(Long id);

    List<Teacher> findAllById(Long id);
}
