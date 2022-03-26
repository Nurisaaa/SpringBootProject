package com.example.springbootproject.dto.responce;

import com.example.springbootproject.model.Group;
import com.example.springbootproject.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String name;
    private String duration;
    private List<Group> groups;
    private Teacher teacher;
}
