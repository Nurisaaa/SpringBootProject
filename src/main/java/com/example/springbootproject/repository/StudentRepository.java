package com.example.springbootproject.repository;

import com.example.springbootproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);

    List<Student> findAllById(Long id);

//    boolean existsByEmail(String name);
}
