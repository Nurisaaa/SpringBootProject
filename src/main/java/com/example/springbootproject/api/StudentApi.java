package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.responce.StudentResponse;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("{groupId}/students")
public class StudentApi {
    private final StudentService studentService;

    @PostMapping
    public StudentResponse saveStudents(@RequestBody StudentRequest studentRequest, @PathVariable("groupId") Long id) {
        return studentService.saveStudent(id, studentRequest);
    }

    @PatchMapping("{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable("id") Long id) {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(@PathVariable("groupId") Long id) {
        return studentService.getAllStudents(id);
    }
}
