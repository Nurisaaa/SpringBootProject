package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.responce.CourseResponse;
import com.example.springbootproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{compId}/courses")
public class CourseApi {
    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourses(@PathVariable("compId") Long id) {
        return courseService.getAllCourse(id);
    }

    @PostMapping
    public CourseResponse saveCourse(@RequestBody CourseRequest courseRequest,
                                     @PathVariable("compId") Long id) {
        return courseService.saveCourse(id, courseRequest);
    }

    @PatchMapping("update/{id}")
    public CourseResponse updateCourse(@RequestBody CourseRequest courseRequest,
                                       @PathVariable("id") Long id) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("{id}")
    public CourseResponse getCourseById(@PathVariable("id") Long id) {
        return courseService.getByIdCourse(id);
    }

}
