package LLD._11_10_12_practice.ATM.models;

public class BankAccount {
    private String id;
    private int balance;

    public BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
