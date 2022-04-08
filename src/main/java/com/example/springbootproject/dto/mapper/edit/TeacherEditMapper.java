package com.example.springbootproject.dto.mapper.edit;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.enums.Authority;
import com.example.springbootproject.model.AuthInfo;
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
        teacher.setCourse(course);
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(teacherRequest.getEmail());
        authInfo.setAuthority(Authority.TEACHER);
        authInfo.setPassword(teacherRequest.getPassword());
        teacher.setAuthInfo(authInfo);
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
//        teacher.setEmail(teacherRequest.getEmail());
    }
}
