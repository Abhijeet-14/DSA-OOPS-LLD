package LLD._11_10_12_practice.ATM.models;

public class Card {
    private String id;
    private int PIN;
    private BankAccount account;

    public Card(String id, int PIN) {
        this.id = id;
        this.PIN = PIN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", PIN=" + PIN +
                ", account=" + account +
                '}';
    }
}
