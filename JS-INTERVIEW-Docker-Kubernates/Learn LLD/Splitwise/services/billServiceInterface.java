package LLD.Splitwise.services;


import LLD.Splitwise.models.Bill;

import java.util.List;
import java.util.HashMap;

public interface billServiceInterface {

    public abstract Bill addBill(String id, String groupId, Integer amount, HashMap<String, Integer> contributions, HashMap<String, Integer> paidBy);
}
