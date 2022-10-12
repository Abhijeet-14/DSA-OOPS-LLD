package LLD._11_10_12_practice.SplitWise.controllers;

import LLD._11_10_12_practice.SplitWise.services.GroupService;

import java.util.Set;

public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService =groupService;
    }

    public void addGroup(String id, String groupName){
        this.groupService.addGroup(id, groupName);
    }

    public void addMember(String id, Set<String> members) {
        this.groupService.addMember(id, members);
    }

    public void showAllGroups(){
        GroupService.showAllGroups();
    }
}
