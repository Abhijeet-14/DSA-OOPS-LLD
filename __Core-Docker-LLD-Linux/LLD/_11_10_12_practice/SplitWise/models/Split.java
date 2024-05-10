package LLD._11_10_12_practice.SplitWise.models;

public class Split {
    private String id;
    private User payBy;
    private User payTo;
    private int amountToPay;

    public Split(String id, User payBy, User payTo, int amountToPay) {
        this.id = id;
        this.payBy = payBy;
        this.payTo = payTo;
        this.amountToPay = amountToPay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getPayBy() {
        return payBy;
    }

    public void setPayBy(User payBy) {
        this.payBy = payBy;
    }

    public User getPayTo() {
        return payTo;
    }

    public void setPayTo(User payTo) {
        this.payTo = payTo;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    public String toString() {
        return "Split{" +
                "id='" + id + '\'' +
                ", payBy=" + payBy +
                ", payTo=" + payTo +
                ", amountToPay=" + amountToPay +
                '}';
    }
}
