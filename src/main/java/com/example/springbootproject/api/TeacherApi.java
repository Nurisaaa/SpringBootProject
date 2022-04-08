package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.dto.responce.TeacherResponse;
import com.example.springbootproject.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("{courseId}/teachers")
public class TeacherApi {
    private final TeacherService teacherService;

    @PostMapping
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest,
                                       @PathVariable("courseId") Long id) {
        return teacherService.saveTeacher(id, teacherRequest);
    }

    @PatchMapping("{id}")
    public TeacherResponse updateTeacher(@PathVariable("id") Long id,
                                         @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers(@PathVariable("courseId") Long id) {
        return teacherService.getAllTeacher(id);
    }

    @GetMapping("{id}")
    public TeacherResponse getTeacherById(@PathVariable("id") Long id) {
        return teacherService.getTeacherById(id);
    }
}
