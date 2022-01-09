package LLD.Splitwise.controllers;

import LLD.Splitwise.models.Group;
import LLD.Splitwise.services.GroupService;

import java.util.List;

public class GroupController {
    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public Group addGroup(String id, String name, List<String> members) {
        return groupService.addGroup(id, name, members);
    }

    @Override
    public String toString() {
        return "GroupController{" +
                "groupService=" + groupService +
                '}';
    }
}
