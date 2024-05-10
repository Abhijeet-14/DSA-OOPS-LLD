package LLD._11_10_12_practice.SplitWise.services;

import LLD._11_10_12_practice.SplitWise.models.*;

import java.util.HashMap;
import java.util.Set;

public class ExpenseService {
    public static HashMap<String, Expense> expenseList = new HashMap<>();

    public void addExpense(String id, int amount, String userId, ExpenseType expenseType, String groupId) {
        User paidBy = UserService.getUser(userId);
        Group group = GroupService.getGroup(groupId);

        if(!group.getMembers().contains(paidBy.getId())){
            System.out.println("User: " + paidBy.getId() + " doesn't belong to this group: " + group.getId());
            return;
        }

        Expense newExpense = null;
        if(expenseType == ExpenseType.EXACT) {
            newExpense = new ExactExpense(id, amount, paidBy, expenseType, group);
        }
        else if (expenseType == ExpenseType.EQUAL) {
            newExpense = new EqualExpense(id, amount, paidBy, expenseType, group);
        }
        else if (expenseType == ExpenseType.PERCENTAGE) {
            newExpense = new PercentageExpense(id, amount, paidBy, expenseType, group);
        }
        else{
            return;
        }

        System.out.println(newExpense.toString());
        expenseList.put(id, newExpense);
    }

    public void calculateSplit(String expenseId, HashMap<String, Integer> splitData) {
        Expense currExpense = expenseList.get(expenseId);

        System.out.println(currExpense instanceof PercentageExpense);

        if(currExpense.getExpenseType() == ExpenseType.EQUAL) {
            currExpense = (EqualExpense) currExpense;
        }
        else if(currExpense.getExpenseType() == ExpenseType.EXACT) {
            currExpense = (ExactExpense) currExpense;
            if(splitData.size() != 0) {
                double amountPaid = currExpense.getAmount();
                double sumOfSplit = 0;
                for (int amount : splitData.values()) {
                    sumOfSplit += amount;
                }
                double actualPaidByUserWhoPaidInitial = amountPaid - sumOfSplit;

                splitData.put(currExpense.getPaidBy().getId(),(int) actualPaidByUserWhoPaidInitial);

            }
        }
        else if(currExpense.getExpenseType() == ExpenseType.PERCENTAGE) {
            currExpense = (PercentageExpense) currExpense;
            if(splitData.size() != 0) {
                int amountPaidInPercent = 100;
                double sumOfSplitPercent = 0;
                for (Integer percent : splitData.values()) {
                    sumOfSplitPercent += percent;
                }
                double actualPaidByUserWhoPaidInitial = amountPaidInPercent - sumOfSplitPercent;

                splitData.put(currExpense.getPaidBy().getId(),(int) actualPaidByUserWhoPaidInitial);

            }
        }
        else
            return;

        currExpense.setSplits(splitData);

        System.out.println("Expense: " + currExpense);
        if(currExpense.validateSplit() == true)
            distributeSplit(currExpense);

    }

    private void distributeSplit(Expense currExpense) {
        String initialPaidBy = currExpense.getPaidBy().getId();
        UserService userService = new UserService();
        if(currExpense.getExpenseType() == ExpenseType.EQUAL)
        {
            double amountToPay = currExpense.getAmount();
            Set<String> groupMember = currExpense.getGroup().getMembers();

            amountToPay = amountToPay/groupMember.size();
            for(String userId: groupMember){
                if(userId != initialPaidBy)
                    userService.updateDues(userId, initialPaidBy, amountToPay);
            }
        }
        else {
            HashMap<String, Integer> currSplit = currExpense.getSplits();
            for (String userId : currSplit.keySet()) {
                if (userId != initialPaidBy) {
                    double amountToPay = 0;
                    if (currExpense.getExpenseType() == ExpenseType.PERCENTAGE)
                        amountToPay = currExpense.getAmount() * ((double) currSplit.get(userId) / 100);

                    else if (currExpense.getExpenseType() == ExpenseType.EXACT)
                        amountToPay = currSplit.get(userId);

                    // updateDues
                    userService.updateDues(userId, initialPaidBy, amountToPay);
                }
            }
        }
    }

}
