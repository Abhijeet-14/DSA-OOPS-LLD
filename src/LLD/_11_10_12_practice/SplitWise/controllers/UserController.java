package LLD._11_10_12_practice.SplitWise.controllers;

import LLD._11_10_12_practice.SplitWise.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public void addUser(String id, String name){
        this.userService.addUser(id, name);
    }

    public void showAllDues(){
        this.userService.showAllDues();
    }
}
