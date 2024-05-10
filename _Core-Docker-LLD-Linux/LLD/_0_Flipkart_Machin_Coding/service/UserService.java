package LLD._0_Flipkart_Machin_Coding.service;

import LLD._0_Flipkart_Machin_Coding.model.User;

public class UserService {

    public void addUser(String name){
        User newUser = new User(name);
        User.allUser.put(name, newUser);
    }
}
