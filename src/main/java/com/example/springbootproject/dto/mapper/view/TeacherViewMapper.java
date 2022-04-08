package com.example.springbootproject.dto.mapper.view;

import com.example.springbootproject.dto.responce.TeacherResponse;
import com.example.springbootproject.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {
    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        if(teacher.getId() != null){
            teacherResponse.setId(teacher.getId());
        }
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
//        teacherResponse.setEmail(teacher.getEmail());
        return teacherResponse;
    }

    public List<TeacherResponse> viewTeachers(List<Teacher> teachers) {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for (Teacher t : teachers) {
            teacherResponses.add(viewTeacher(t));
        }
        return teacherResponses;
    }
}
