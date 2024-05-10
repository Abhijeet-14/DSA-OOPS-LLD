package LLD._11_10_12_practice.ATM.models;

public class CheckBalanceState extends ATMState{
    public CheckBalanceState(){
        System.out.println("You choose CASH_WITHDRAW, We Are processing your request");
    }

    public void displayAmount(ATM atm, Card card){
        int currentBalance = card.getAccount().getBalance();

        System.out.println("Your Current Balance: " + currentBalance);
        exit(atm);
    }
}
