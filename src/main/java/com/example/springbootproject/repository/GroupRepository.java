package com.example.springbootproject.repository;

import com.example.springbootproject.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findById(Long id);

    List<Group> findAllById(Long id);
}
