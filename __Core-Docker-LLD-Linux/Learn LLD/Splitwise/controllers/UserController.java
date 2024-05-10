package LLD.Splitwise.controllers;

import LLD.Splitwise.models.User;
import LLD.Splitwise.services.UserService;

public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User addUser(String id, String name) {
        return userService.addUser(id, name);
    }
}
