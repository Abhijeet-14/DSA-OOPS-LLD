package LLD._11_10_12_practice.SplitWise.models;

import java.util.HashMap;

public class EqualExpense extends Expense{

    public EqualExpense(String id, double amount, User paidBy, ExpenseType expenseType, Group group) {
        super(id, amount, paidBy, expenseType, group);
    }

    @Override
    public boolean validateSplit() {
        if(!this.getGroup().getMembers().contains(this.getPaidBy().getId()))
        {
            System.out.println("User: " + this.getPaidBy().getId() +", does not belong to group: " + this.getGroup().getId());
            return false;
        }

        if(this.getExpenseType() != ExpenseType.EQUAL){
            System.out.println("ExpenseType Does Not Match with Equal Expense");
            return false;
        }

        System.out.println("Split Is valid for Equal Expense");
        return true;
    }
}
