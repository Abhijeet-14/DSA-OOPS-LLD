package LLD._0_Flipkart_Machin_Coding.api;

import LLD._0_Flipkart_Machin_Coding.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String name) {

        this.userService.addUser(name);
    }
}
