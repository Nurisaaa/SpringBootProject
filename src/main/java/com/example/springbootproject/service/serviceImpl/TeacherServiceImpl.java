package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.dto.responce.TeacherResponse;
import com.example.springbootproject.mapper.edit.TeacherEditMapper;
import com.example.springbootproject.mapper.view.TeacherViewMapper;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.model.Teacher;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.repository.TeacherRepository;
import com.example.springbootproject.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;
    private final CourseRepository courseRepository;

    @Override
    public TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest) {
        Course course = courseRepository.findById(id).get();
        return teacherViewMapper
                .viewTeacher(teacherRepository
                        .save(teacherEditMapper
                                .saveTeacher(course, teacherRequest)));
    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherEditMapper.update(teacher,teacherRequest);
        return teacherViewMapper
                .viewTeacher(teacherRepository
                        .save(teacher));
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.delete(teacher);
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        return teacherViewMapper.viewTeacher(teacher);
    }

    @Override
    public List<TeacherResponse> getAllTeacher(Long id) {
        List<Teacher> teachers = teacherRepository.findAllById(id);
        return teacherViewMapper.viewTeachers(teachers);
    }
}
