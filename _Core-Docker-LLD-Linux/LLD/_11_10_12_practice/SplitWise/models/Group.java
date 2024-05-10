package LLD._11_10_12_practice.SplitWise.models;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private String id;
    private String groupName;
    private Set<String> members;

    public Group(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
        this.members = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<String> getMembers() {
        return members;
    }

    public void setMembers(Set<String> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", members=" + members +
                '}';
    }
}
