package LLD._11_10_12_practice.SplitWise.models;

import LLD._11_10_12_practice.SplitWise.services.UserService;

public class PercentageExpense extends Expense{
    public PercentageExpense(String id, double amount, User paidBy, ExpenseType expenseType, Group group) {
        super(id, amount, paidBy, expenseType, group);
    }

    @Override
    public boolean validateSplit() {
        if(!this.getGroup().getMembers().contains(this.getPaidBy().getId()))
        {
            System.out.println("User: " + this.getPaidBy().getId() +", does not belong to group: " + this.getGroup().getId());
            return false;
        }

        if (this.getExpenseType() != ExpenseType.PERCENTAGE) {
            System.out.println("ExpenseType Does Not Match with Exact Expense");
            return false;
        }

        double totalPercentage = 100;
        double sumOfPercentage = 0;

        for(int splitValue: this.getSplits().values())
        {
            sumOfPercentage += splitValue;
        }

        if (totalPercentage != sumOfPercentage){
            System.out.println("Sum of all percentage is not equal to 100%");
            return false;
        }

        System.out.println("Split Is valid for Exact Expense");
//        distributeSplit();
        return true;
    }

//    @Override
//    public void distributeSplit() {
//    }
}
