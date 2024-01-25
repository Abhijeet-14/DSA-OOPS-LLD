package oops._3_Concepts._1_Data_hiding;

/*
    data hiding is a technique to hide internal object details
    i.e., data members
 */
public class _1_Data_hiding {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.details();
        System.out.println("Error, if we try to access class variable");
//        System.out.println(ba.username); throw error as it is private
    }

}

class BankAccount {
    // this can't be access by any where - Data Hiding
    private double balance = 1000;
    private String username = "Adam";
    private String password = "123";

    public void details() {
        System.out.println(balance);
        System.out.println(username);
        System.out.println(password);
    }

}
