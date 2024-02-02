package LLD.Splitwise.services;

import LLD.Splitwise.models.Group;
import java.util.List;

public interface group_service_interface {

    public abstract Group addGroup(String id, String name, List<String> members);
}
