package LLD._11_10_12_practice.ATM;

import LLD._11_10_12_practice.ATM.models.ATM;
import LLD._11_10_12_practice.ATM.models.BankAccount;
import LLD._11_10_12_practice.ATM.models.Card;
import LLD._11_10_12_practice.ATM.models.Operations;

public class Driver {
    public static void main(String[] args) {
        System.out.println("ATM Machine");

        ATM atmObject = new ATM("atm1", 5000, false);

        BankAccount account = new BankAccount("acc1", 4500);

        Card card = new Card("card1", 123);
        card.setAccount(account);

        System.out.println("\nCurrent ATM details: " + atmObject);
        System.out.println("Current Card details: " + card);
        System.out.println("\nWithDraw 1700");// Withdraw 1700
        atmObject.getCurrentATMState().insertCard(atmObject, card);
        atmObject.getCurrentATMState().verifyPIN(atmObject, card, 123);
        atmObject.getCurrentATMState().selectOperation(atmObject, card, Operations.CASH_WITHDRAW);
        atmObject.getCurrentATMState().cashWithdraw(atmObject, card, 1700);

        System.out.println("\nCheck Balance");// Check Balance
        atmObject.getCurrentATMState().insertCard(atmObject, card);
        atmObject.getCurrentATMState().verifyPIN(atmObject, card, 123);
        atmObject.getCurrentATMState().selectOperation(atmObject, card, Operations.CHECK_BALANCE);
        atmObject.getCurrentATMState().displayAmount(atmObject, card);

        System.out.println("\nCurrent ATM details: " + atmObject);
        System.out.println("Current Card details: " + card);
        System.out.println("\nWithDraw 4000");// Withdraw 1700
        atmObject.getCurrentATMState().insertCard(atmObject, card);
        atmObject.getCurrentATMState().verifyPIN(atmObject, card, 123);
        atmObject.getCurrentATMState().selectOperation(atmObject, card, Operations.CASH_WITHDRAW);
        atmObject.getCurrentATMState().cashWithdraw(atmObject, card, 4000);

        System.out.println("\nCheck Balance");// Check Balance
        atmObject.getCurrentATMState().insertCard(atmObject, card);
        atmObject.getCurrentATMState().verifyPIN(atmObject, card, 123);
        atmObject.getCurrentATMState().selectOperation(atmObject, card, Operations.CHECK_BALANCE);
        atmObject.getCurrentATMState().displayAmount(atmObject, card);


    }
}
