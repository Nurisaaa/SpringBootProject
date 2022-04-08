package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.responce.GroupResponse;
import com.example.springbootproject.exception.BadRequest;
import com.example.springbootproject.dto.mapper.edit.GroupEditMapper;
import com.example.springbootproject.dto.mapper.view.GroupViewMapper;
import com.example.springbootproject.model.Course;
import com.example.springbootproject.model.Group;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.repository.GroupRepository;
import com.example.springbootproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;
    private final CourseRepository courseRepository;

    @Override
    public GroupResponse saveGroup(Long id, GroupRequest group) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist " , id)
                ));
        return groupViewMapper
                .viewGroup(groupRepository
                        .save(groupEditMapper
                                .saveGroup(course, group)));
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group = getGroup(id);
        return groupViewMapper.viewGroup(group);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = getGroup(id);
        groupRepository.delete(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = getGroup(id);
        groupEditMapper.updateGroup(group, groupRequest);
        return groupViewMapper.viewGroup(groupRepository.save(group));
    }

    @Override
    public List<GroupResponse> getAllGroups(Long id) {
        List<Group> getAllGroups = courseRepository.getById(id).getGroup();
        return groupViewMapper.getGroups(getAllGroups);
    }

    private Group getGroup(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist " , id)
                ));
        return group;
    }
}
