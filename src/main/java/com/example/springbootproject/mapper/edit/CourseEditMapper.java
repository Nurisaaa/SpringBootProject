package com.example.springbootproject.mapper.edit;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.model.Company;
import com.example.springbootproject.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseEditMapper {

    public Course saveCourse(Company company, CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(company);
        return course;
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setName(courseRequest.getName());
        course.setDuration(courseRequest.getDuration());

    }

}
