package com.example.springbootproject.dto.mapper.view;

import com.example.springbootproject.dto.responce.StudentResponse;
import com.example.springbootproject.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {
    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() != null) {
            studentResponse.setId(student.getId());
        }
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
//        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(String.valueOf(student.getStudyFormat()));
        return studentResponse;
    }

    public List<StudentResponse> viewStudents(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student s : students) {
            studentResponses.add(viewStudent(s));
        }
        return studentResponses;
    }
}
