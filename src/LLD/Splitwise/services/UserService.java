package LLD.Splitwise.services;

import LLD.Splitwise.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService implements user_service_interface {

    public static Map<String, User> userList=  new HashMap<>();

    @Override
    public User addUser(String id, String name) {
        User user = new User();

        user.setId(id);
        user.setName(name);

        // add to MOCK DB
        userList.put(user.getId(), user);

        return user;
    }
}
