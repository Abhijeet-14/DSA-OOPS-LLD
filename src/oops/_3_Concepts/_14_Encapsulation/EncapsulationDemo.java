package oops._3_Concepts._14_Encapsulation;

/*
    Grouping up of Data members and function in a single unit is ENCAPSULATION

    - Assume class as CAPSULE.
       - and variables and function are inside it.

    Data Hiding + Abstraction = Encapsulation

    Note: Tightly Encapsulated class -> all variables private, then tightly encapsulated class.
*/

class Account{
    // Data Hiding
    private double balance;

    // abstract method
    public double getBalance() {
        return balance;
    }

    // abstract method
    public void setBalance(double balance) {
        this.balance = balance;
    }
}


public class EncapsulationDemo {
    public static void main(String[] args) {
        Account acc =new Account();
        acc.setBalance(1000);
        System.out.println("Balance: " + acc.getBalance());

    }
}
