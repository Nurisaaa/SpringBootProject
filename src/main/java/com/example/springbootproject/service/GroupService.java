package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.responce.GroupResponse;

import java.util.List;

public interface GroupService {
    GroupResponse saveGroup(Long id, GroupRequest group);

    GroupResponse getGroupById(Long id);

    void deleteGroup(Long id);

    GroupResponse updateGroup(Long id, GroupRequest group);

    List<GroupResponse> getAllGroups(Long id);

//    GroupResponse getGroupById(Long id);
//    Group groupRequest(RequestGroup requestGroup);
}
