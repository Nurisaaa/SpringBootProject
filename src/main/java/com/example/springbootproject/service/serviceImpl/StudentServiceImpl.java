package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.responce.StudentResponse;
import com.example.springbootproject.exception.BadRequest;
import com.example.springbootproject.dto.mapper.edit.StudentEditMapper;
import com.example.springbootproject.dto.mapper.view.StudentViewMapper;
import com.example.springbootproject.model.Group;
import com.example.springbootproject.model.Student;
import com.example.springbootproject.repository.GroupRepository;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;
    private final GroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public StudentResponse saveStudent(Long id, StudentRequest studentRequest) {
//        String email = studentRequest.getEmail();
//        boolean existsByEmail = studentRepository.existsByEmail(email);
//        if (existsByEmail) {
//            throw new BadRequest(
//                    String.format("Student with email %s is already exists " , email
//                    ));
//        }
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with id %d does not exist " , id)
                ));
        studentRequest.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        return studentViewMapper
                .viewStudent(studentRepository.
                        save(studentEditMapper
                                .saveStudent(group, studentRequest)));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }

    @Transactional
    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = getStudent(id);
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
        Student student = getStudent(id);
        return studentViewMapper.viewStudent(student);
    }

    private Student getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with id %d does not exist " , id)
                ));
        return student;
    }
}
