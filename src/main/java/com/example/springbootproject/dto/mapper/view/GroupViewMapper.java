package com.example.springbootproject.dto.mapper.view;

import com.example.springbootproject.dto.responce.GroupResponse;
import com.example.springbootproject.model.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {
    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() != null) {
            groupResponse.setId(group.getId());
        }
        groupResponse.setName(group.getName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;
    }

    public List<GroupResponse> getGroups(List<Group> groups) {
        List<GroupResponse> getGroups = new ArrayList<>();
        for (Group g : groups) {
            getGroups.add(viewGroup(g));
        }
        return getGroups;
    }


}
