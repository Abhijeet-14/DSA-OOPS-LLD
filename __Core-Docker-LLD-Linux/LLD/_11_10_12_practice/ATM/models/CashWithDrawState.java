package LLD._11_10_12_practice.ATM.models;

public class CashWithDrawState extends ATMState{
    public CashWithDrawState(){
        System.out.println("You choose CASH_WITHDRAW, Please enter Withdrawal Amount");
    }

    public void cashWithdraw(ATM atm, Card card, int withdrawAmount){
        if(atm.getCashAmount() < withdrawAmount){
            System.out.println("Sorry, ATM out of cash for this amount ");
            exit(atm);
        }

        else if(card.getAccount().getBalance() < withdrawAmount){
            System.out.println("Sorry, You Don't have sufficient fund");
            exit(atm);
        }
        else{
            // deduct amount from card
            int newAccountBalance = card.getAccount().getBalance() - withdrawAmount;
            card.getAccount().setBalance(newAccountBalance);

            // deduct amount from ATM
            int newATMBalance = atm.getCashAmount() - withdrawAmount;
            atm.setCashAmount(newATMBalance);

            exit(atm);
        }

    }

}
