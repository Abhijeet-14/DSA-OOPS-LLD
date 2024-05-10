package LLD._11_10_12_practice.SplitWise.services;

import LLD._11_10_12_practice.SplitWise.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    public static HashMap<String, User> userList = new HashMap<>();

    public static User getUser(String userId) {
        return userList.get(userId);
    }

    public void addUser(String id, String name){
        User newUser = new User(id, name);
        userList.put(id, newUser);
    }

    public void showAllDues(){

        for(User currUser: userList.values()) {
            System.out.println(currUser.getId() + ": " + currUser.getDues());
        }
    }

    public void updateDues(String payBy, String payTo, double amount){
        int amountToPay = (int) amount;
        if(!userList.containsKey(payTo)){
            System.out.println("User id is invalid");
            return;
        }

        User currUser = UserService.userList.get(payBy);

        HashMap<String, Integer> currDues = currUser.getDues();
        currDues.put(payTo, currDues.getOrDefault(payTo, 0) + amountToPay);

        currUser.setDues(currDues);
    }
}
