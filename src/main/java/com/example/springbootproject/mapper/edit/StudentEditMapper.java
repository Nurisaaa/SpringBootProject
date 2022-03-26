package com.example.springbootproject.mapper.edit;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.model.Group;
import com.example.springbootproject.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentEditMapper {

    public Student saveStudent(Group group, StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setGroup(group);
        return student;
    }

    public void updateStudent(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
