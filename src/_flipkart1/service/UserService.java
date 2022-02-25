package service;

import model.User;

public class UserService {

    public void addUser(String name){
        User newUser = new User(name);
        User.allUser.put(name, newUser);
    }
}
