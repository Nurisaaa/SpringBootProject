package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.responce.StudentResponse;
import com.example.springbootproject.mapper.edit.StudentEditMapper;
import com.example.springbootproject.mapper.view.StudentViewMapper;
import com.example.springbootproject.model.Group;
import com.example.springbootproject.model.Student;
import com.example.springbootproject.repository.GroupRepository;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;
    private final GroupRepository groupRepository;


    @Override
    public StudentResponse saveStudent(Long id, StudentRequest studentRequest) {
        Group group = groupRepository.findById(id).get();
        return studentViewMapper
                .viewStudent(studentRepository.
                        save(studentEditMapper
                                .saveStudent(group,studentRequest)));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).get();
        studentEditMapper.updateStudent(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.save(student));
    }

    @Override
    public List<StudentResponse> getAllStudents(Long id) {
        List<Student> students = studentRepository.findAllById(id);
        return studentViewMapper.viewStudents(students);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return studentViewMapper.viewStudent(student);
    }
}
