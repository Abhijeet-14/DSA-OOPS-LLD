package LLD._11_10_12_practice.SplitWise.services;


import LLD._11_10_12_practice.SplitWise.models.Group;

import java.util.HashMap;
import java.util.Set;

public class GroupService {
    public static HashMap<String, Group> groups = new HashMap<>();

    public static Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    public void addGroup(String id, String groupName){
        Group newGroup = new Group(id, groupName);

        groups.put(id, newGroup);
    }

    public void addMember(String id, Set<String> members) {
        groups.get(id).setMembers(members);
    }

    public static void showAllGroups(){
        System.out.println("Groups: " + groups);
    }


}
