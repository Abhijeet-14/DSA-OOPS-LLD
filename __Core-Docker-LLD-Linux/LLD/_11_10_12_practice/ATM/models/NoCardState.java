package LLD._11_10_12_practice.ATM.models;

public class NoCardState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Please Insert Your card");
        atm.setHasCard(true);
        atm.setCurrentATMState(new HasCardState());
    }
}
