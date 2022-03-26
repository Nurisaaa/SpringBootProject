package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.dto.responce.TeacherResponse;

import java.util.List;

public interface TeacherService {
    TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest);

    TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest);

    void deleteTeacher(Long id);

    TeacherResponse getTeacherById(Long id);

    List<TeacherResponse> getAllTeacher(Long id);
}
