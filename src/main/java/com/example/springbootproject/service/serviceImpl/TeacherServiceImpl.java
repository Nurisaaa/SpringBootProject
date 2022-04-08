package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.TeacherRequest;
import com.example.springbootproject.dto.responce.TeacherResponse;
import com.example.springbootproject.exception.BadRequest;
import com.example.springbootproject.dto.mapper.edit.TeacherEditMapper;
import com.example.springbootproject.dto.mapper.view.TeacherViewMapper;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.model.Teacher;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.repository.TeacherRepository;
import com.example.springbootproject.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist " , id)
                ));
        String password = passwordEncoder.encode(teacherRequest.getPassword());
        teacherRequest.setPassword(password);
        return teacherViewMapper
                .viewTeacher(teacherRepository
                        .save(teacherEditMapper
                                .saveTeacher(course, teacherRequest)));
    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = getTeacher(id);
        teacherEditMapper.update(teacher, teacherRequest);
        return teacherViewMapper
                .viewTeacher(teacherRepository
                        .save(teacher));
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = getTeacher(id);
        teacherRepository.delete(teacher);
        log.info("Teacher deleted successfully");
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = getTeacher(id);
        return teacherViewMapper.viewTeacher(teacher);
    }

    @Override
    public List<TeacherResponse> getAllTeacher(Long id) {
        List<Teacher> teachers = teacherRepository.findAllById(id);
        return teacherViewMapper.viewTeachers(teachers);
    }

    private Teacher getTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist " , id)
                ));
        return teacher;
    }
}
