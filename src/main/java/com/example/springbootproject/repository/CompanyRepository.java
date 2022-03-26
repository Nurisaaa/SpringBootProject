package com.example.springbootproject.repository;

import com.example.springbootproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);
}
