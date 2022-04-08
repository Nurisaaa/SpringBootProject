package com.example.springbootproject.dto.mapper.view;

import com.example.springbootproject.dto.responce.CourseResponse;
import com.example.springbootproject.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {
    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        if (course.getId() != null) {
            courseResponse.setId(course.getId());
        }
        courseResponse.setName(course.getName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;

    }

    public List<CourseResponse> viewCourses(List<Course> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course c : courses) {
            courseResponses.add(viewCourse(c));
        }
        return courseResponses;
    }
}
