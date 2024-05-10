package LLD._11_10_12_practice.ATM.models;

public class VerifyPINState extends ATMState{
    public VerifyPINState(){
        System.out.println("Please Choose One Operation");
    }

    @Override
    public void selectOperation(ATM atm, Card card, Operations operation) {
        if(operation == Operations.CASH_WITHDRAW){
            atm.setCurrentATMState(new CashWithDrawState());
        }
        else if(operation == Operations.CHECK_BALANCE){
            atm.setCurrentATMState(new CheckBalanceState());
        }
        else{
            System.out.println("Invalid Operation");
            exit(atm);
        }
    }

}
