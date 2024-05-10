package LLD._11_10_12_practice.SplitWise;

import LLD._11_10_12_practice.SplitWise.controllers.ExpenseController;
import LLD._11_10_12_practice.SplitWise.controllers.GroupController;
import LLD._11_10_12_practice.SplitWise.controllers.UserController;
import LLD._11_10_12_practice.SplitWise.models.ExpenseType;
import LLD._11_10_12_practice.SplitWise.services.ExpenseService;
import LLD._11_10_12_practice.SplitWise.services.GroupService;
import LLD._11_10_12_practice.SplitWise.services.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Splitwise");

        // Create users
        UserController userController = new UserController(new UserService());
        userController.addUser("user1", "user1");
        userController.addUser("user2", "user2");
        userController.addUser("user3", "user3");
        userController.addUser("user4", "user4");

        // Create Groups
        GroupController groupController = new GroupController(new GroupService());
        groupController.addGroup("group1", "group1");
        groupController.addGroup("group2", "group2");

        // add users to groups
        Set<String> member1 = new HashSet<>();
        member1.add("user1");
        member1.add("user2");
        member1.add("user3");
        groupController.addMember("group1", member1);

        Set<String> member2 = new HashSet<>();
        member2.add("user1");
        member2.add("user2");
        member2.add("user4");

        groupController.addMember("group2", member2);

        groupController.showAllGroups();

        // Create Expense
        ExpenseController expenseController = new ExpenseController(new ExpenseService());
        expenseController.addExpense("expense1", 600, "user1", ExpenseType.EQUAL, "group1");
        expenseController.addExpense("expense2", 700, "user2", ExpenseType.EXACT, "group2");
        expenseController.addExpense("expense3", 1000, "user3", ExpenseType.PERCENTAGE, "group1");
        expenseController.addExpense("expense4", 800, "user2", ExpenseType.PERCENTAGE, "group2");

        // split Expense in that group - Equal
        expenseController.calculateExpense("expense1", null );

        // split Expense in that group - Exact
        HashMap<String, Integer> splitData1 = new HashMap<>();
        splitData1.put("user1", 200);
        splitData1.put("user4", 100);
        expenseController.calculateExpense("expense2", splitData1 );

        // split Expense in that group - Percentage
        HashMap<String, Integer> splitData2 = new HashMap<>();
        splitData2.put("user1", 40);
        splitData2.put("user4", 30);
        expenseController.calculateExpense("expense3", splitData2 );

        // split Expense in that group - Percentage
        HashMap<String, Integer> splitData3 = new HashMap<>();
        splitData3.put("user1", 55);
        splitData3.put("user4", 19);
        expenseController.calculateExpense("expense4", splitData3 );


        // show balancesheet by user
        // show balancesheet of all user
        userController.showAllDues();

        // show balancesheet of all group
    }
}
