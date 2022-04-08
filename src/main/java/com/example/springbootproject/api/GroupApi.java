package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.responce.GroupResponse;
import com.example.springbootproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{courseId}/groups")
public class GroupApi {

    private final GroupService groupService;

    @PostMapping
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest,
                                   @PathVariable("courseId") Long id) {
        return groupService.saveGroup(id, groupRequest);
    }

    @GetMapping()
    public List<GroupResponse> getAllGroups(@PathVariable("courseId") Long id) {
        return groupService.getAllGroups(id);
    }

    @PatchMapping("update/{id}")
    public GroupResponse updateGroup(@PathVariable("id") Long id,
                                     @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteGroupById(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
    }

    @GetMapping("{id}")
    public GroupResponse getGroupById(@PathVariable("id") Long id) {
        return groupService.getGroupById(id);
    }
}
