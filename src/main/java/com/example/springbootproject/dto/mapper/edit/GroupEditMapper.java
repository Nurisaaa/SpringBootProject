package com.example.springbootproject.dto.mapper.edit;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupEditMapper {

    public Group saveGroup(Course course, GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        }
        Group group = new Group();
        group.setName(groupRequest.getName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        group.setCourses(course);
        return group;
    }

    public void updateGroup(Group group, GroupRequest groupRequest) {
        group.setName(groupRequest.getName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
    }
}
