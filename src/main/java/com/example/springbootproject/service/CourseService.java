package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.responce.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(Long id, CourseRequest courseRequest);

    List<CourseResponse> getAllCourse(Long id);

    CourseResponse getByIdCourse(long id);

    void deleteCourse(long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    CourseResponse getCourseByName(String name, long id);
//    Course courseRequest(RequestCourse requestCourse);
}
