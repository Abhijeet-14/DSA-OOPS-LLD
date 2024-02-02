package LLD._11_10_12_practice.SplitWise.models;

import java.util.HashMap;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private ExpenseType expenseType;

    private Group group;
    private HashMap<String, Integer> splits;

    public Expense(String id, double amount, User paidBy, ExpenseType expenseType, Group group) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.expenseType = expenseType;
        this.group = group;
        this.splits = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public HashMap<String, Integer> getSplits() {
        return splits;
    }

    public void setSplits(HashMap<String, Integer> splits) {
        this.splits = splits;
    }

    public abstract boolean validateSplit();
//    public abstract void distributeSplit();


    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", expenseType=" + expenseType +
                ", group=" + group +
                ", splits=" + splits +
                '}';
    }
}
