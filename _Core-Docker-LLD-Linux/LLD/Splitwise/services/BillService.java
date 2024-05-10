package LLD.Splitwise.services;

import LLD.Splitwise.models.Bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CLIENT FIRST INTERACTION
public class BillService implements billServiceInterface {

    public static Map<String, Bill> billDetails = new HashMap<>();

    @Override
    public Bill addBill(String id, String groupId, Integer amount, HashMap<String, Integer> contributions, HashMap<String, Integer> paidBy) {

        Bill bill = new Bill();

        bill.setId(id);
        bill.setGroupId(groupId);
        bill.setContributions(contributions);
        bill.setAmount(0);
        bill.setPaidBy(paidBy);

        billDetails.put(bill.getId(), bill);

        return bill;
    }


}
