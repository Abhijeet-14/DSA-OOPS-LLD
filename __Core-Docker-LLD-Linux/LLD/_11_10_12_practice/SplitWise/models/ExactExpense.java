package LLD._11_10_12_practice.SplitWise.models;

public class ExactExpense extends Expense {

    public ExactExpense(String id, double amount, User paidBy, ExpenseType expenseType, Group group) {
        super(id, amount, paidBy, expenseType, group);
    }

    @Override
    public boolean validateSplit() {
        System.out.println("Inside Exact validation");
        if(!this.getGroup().getMembers().contains(this.getPaidBy().getId()))
        {
            System.out.println("User: " + this.getPaidBy().getId() +", does not belong to group: " + this.getGroup().getId());
            return false;
        }

        if (this.getExpenseType() != ExpenseType.EXACT) {
            System.out.println("ExpenseType Does Not Match with Exact Expense");
            return false;
        }

        double actualAmountPaid = this.getAmount();
        double sumOfSplitAmount = 0;

        for(int splitValue: this.getSplits().values())
            sumOfSplitAmount += splitValue;

        if (actualAmountPaid != sumOfSplitAmount){
            System.out.println("Sum of all split is not equal to Actual Amount Paid");
            return false;
        }

        System.out.println("Split Is valid for Exact Expense");
        return true;
    }
}
