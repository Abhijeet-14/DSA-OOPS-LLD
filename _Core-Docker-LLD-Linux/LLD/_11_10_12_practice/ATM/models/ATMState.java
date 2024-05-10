package LLD._11_10_12_practice.ATM.models;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card){System.out.println("Oops! Something went wrong");}
    public void verifyPIN(ATM atm, Card card, int pin){System.out.println("Oops! Something went wrong");}
    public void selectOperation(ATM atm, Card card, Operations operation){System.out.println("Oops! Something went wrong");}
    public void cashWithdraw(ATM atm, Card card, int withdrawAmount){System.out.println("Oops! Something went wrong");}
    public void displayAmount(ATM atm, Card card){System.out.println("Oops! Something went wrong");}

    public void returnCard(ATM atm) {
        atm.setHasCard(false);
        System.out.println("Please Collect Your card");
    }

    public void exit(ATM atm) {
        if (atm.isHasCard())
            returnCard(atm);

        atm.setCurrentATMState(new NoCardState());
        System.out.println("Thank You So much for using ATM");
    }
}
