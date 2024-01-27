package LLD.Splitwise.services;

import LLD.Splitwise.models.Group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService implements  group_service_interface{
    public static Map<String, Group> groupList = new HashMap<>();

    @Override
    public Group addGroup(String id, String name, List<String> members) {
        Group group = new Group();
        group.setId(id);
        group.setName(name);
        group.setMembers(members);

        groupList.put(group.getId(), group);

        return group;
    }
}
