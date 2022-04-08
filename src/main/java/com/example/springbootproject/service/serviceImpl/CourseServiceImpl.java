package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.responce.CourseResponse;
import com.example.springbootproject.exception.BadRequest;
import com.example.springbootproject.dto.mapper.edit.CourseEditMapper;
import com.example.springbootproject.dto.mapper.view.CourseViewMapper;
import com.example.springbootproject.model.Company;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.repository.CompanyRepository;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper courseViewMapper;
    private final CompanyRepository companyRepository;

    @Override
    public CourseResponse saveCourse(Long id, CourseRequest courseRequest) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist " , id)
                )
        );
        return courseViewMapper
                .viewCourse(courseRepository
                        .save(editMapper
                                .saveCourse(company, courseRequest)));
    }


    @Override
    public List<CourseResponse> getAllCourse(Long id) {
        List<Course> coursesOfCompany = companyRepository.getById(id).getCourses();
        return courseViewMapper.viewCourses(coursesOfCompany);
    }

    @Override
    public CourseResponse getByIdCourse(long id) {
        Course course = getCourse(id);
        return courseViewMapper.viewCourse(course);
    }

    @Override
    public void deleteCourse(long id) {
        Course course = getCourse(id);
        courseRepository.delete(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = getCourse(id);
        editMapper.update(course, courseRequest);
        return courseViewMapper.viewCourse(courseRepository.save(course));
    }

    @Override
    public CourseResponse getCourseByName(String name, long id) {

        return null;
    }

    private Course getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Course with this %d does not exist ", id)
                ));
        return course;
    }
}