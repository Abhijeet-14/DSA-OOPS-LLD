package LLD._11_10_12_practice.ATM.models;

public class HasCardState extends ATMState{

    public HasCardState(){
        System.out.println("Please enter your PIN");
    }

    @Override
    public void verifyPIN(ATM atm, Card card, int pin) {
        if(card.getPIN() == pin){
            atm.setCurrentATMState(new VerifyPINState());
        }
        else{
            System.out.println("Incorrect PIN");
            exit(atm);
        }
    }

}
