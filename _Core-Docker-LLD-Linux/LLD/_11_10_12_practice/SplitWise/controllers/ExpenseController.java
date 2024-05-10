package LLD._11_10_12_practice.SplitWise.controllers;

import LLD._11_10_12_practice.SplitWise.models.ExpenseType;
import LLD._11_10_12_practice.SplitWise.services.ExpenseService;

import java.util.HashMap;

public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    public void addExpense(String id, int amount, String userId, ExpenseType expenseType, String groupId) {
        this.expenseService.addExpense(id, amount, userId, expenseType, groupId);
    }

    public void calculateExpense(String expenseId, HashMap<String, Integer> splitData) {
        this.expenseService.calculateSplit(expenseId, splitData);
    }
}
