package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.responce.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(Long id, StudentRequest studentRequest);

    void deleteStudent(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);

    List<StudentResponse> getAllStudents(Long id);

    StudentResponse getStudentById(Long id);
}
