package LLD.Splitwise;

import LLD.Splitwise.controllers.BillController;
import LLD.Splitwise.controllers.UserController;
import LLD.Splitwise.controllers.GroupController;
import LLD.Splitwise.models.Group;
import LLD.Splitwise.models.User;
import LLD.Splitwise.services.BillService;
import LLD.Splitwise.services.GroupService;
import LLD.Splitwise.services.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class driver {
    public static void main(String[] args) {

        UserController userController = new UserController(new UserService());
        BillController billController =new BillController(new BillService());
        GroupController groupController = new GroupController(new GroupService());

        User user1 = userController.addUser("user1", "pawan");
        User user2 = userController.addUser("user2", "gyab");
        User user3 = userController.addUser("user3", "punit");
        User user4 = userController.addUser("user4", "prakhs");
        User user5 = userController.addUser("user5", "paresh");

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        System.out.println(user4.toString());
        System.out.println(user5.toString());

        List<String> members= new ArrayList<>();

        members.add("m1");
        members.add("m2");
        members.add("m3");

        Group group1 = groupController.addGroup("group1", "avengers", members);

        System.out.println(group1.toString());

        HashMap<String, Integer> contibutions = new HashMap<>();
        contibutions.put("useer1", 100);
        contibutions.put("useer2", 100);
        contibutions.put("useer3", 100);
        contibutions.put("useer4", 100);
        contibutions.put("useer5", 100);

        HashMap<String, Integer> paidBy = new HashMap<>();
        paidBy.put("user1", 200);
        paidBy.put("user2", 75);
        paidBy.put("user3", 100);
        paidBy.put("user4", 75);
        paidBy.put("user5", 50);


        billController.addBill("bill1", "group1", 50, contibutions, paidBy);

        int balance1 = billController.getUserBalance("user1");
        int balance2 = billController.getUserBalance("user2");
        int balance3 = billController.getUserBalance("user3");
        int balance4 = billController.getUserBalance("user4");
        int balance5 = billController.getUserBalance("user5");

        System.out.println(balance1);
        System.out.println(balance2);
        System.out.println(balance3);
        System.out.println(balance4);
        System.out.println(balance5);
    }
}
