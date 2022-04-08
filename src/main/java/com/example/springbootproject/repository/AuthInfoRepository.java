package com.example.springbootproject.repository;

import com.example.springbootproject.model.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthInfoRepository extends JpaRepository<AuthInfo,Long> {
    Optional<AuthInfo> findByEmail(String email);
}
