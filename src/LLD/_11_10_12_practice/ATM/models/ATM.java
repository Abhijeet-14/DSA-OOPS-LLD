package LLD._11_10_12_practice.ATM.models;

public class ATM {

    private String id;
    private int cashAmount;

    private boolean hasCard;

    private ATMState currentATMState = new NoCardState();

    public ATM(String id, int cashAmount, boolean hasCard) {
        this.id = id;
        this.cashAmount = cashAmount;
        this.hasCard = hasCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id='" + id + '\'' +
                ", cashAmount=" + cashAmount +
                ", hasCard=" + hasCard +
                '}';
    }
}
