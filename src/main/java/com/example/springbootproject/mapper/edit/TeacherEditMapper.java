package com.example.springbootproject.mapper.edit;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherEditMapper {

    public Teacher saveTeacher(Course course, TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setCourse(course);
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setEmail(teacherRequest.getEmail());
    }
}
