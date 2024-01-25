package LLD.Splitwise.models;

import java.util.HashMap;

// Object Layout
public class Bill {

    String id;
    Integer amount;
    String groupId;
    HashMap<String, Integer> contributions;
    HashMap<String, Integer> paidBy;

    public Bill() {
    }

    public Bill(String id, Integer amount, String groupId) {
        super();
        this.id = id;
        this.amount = amount;
        this.groupId = groupId;
        this.contributions = new HashMap<>();
        this.paidBy = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public String getId(int a) {
        return "A";
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public HashMap<String, Integer> getContributions() {
        return contributions;
    }

    public void setContributions(HashMap<String, Integer> contributions) {
        this.contributions = contributions;
    }

    public HashMap<String, Integer> getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(HashMap<String, Integer> paidBy) {
        this.paidBy = paidBy;
    }


}

