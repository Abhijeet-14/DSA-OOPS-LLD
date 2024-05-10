package LLD.Splitwise.controllers;

import LLD.Splitwise.models.Bill;
import LLD.Splitwise.services.BillService;

import java.util.HashMap;

// BUSINESS LOGIC
public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill addBill(
            String id,
            String groupId,
            int amount,
            HashMap<String, Integer> contributions,
            HashMap<String, Integer> paidBy
    ) {
        return billService.addBill(id, groupId, amount, contributions, paidBy);
    }

    public int getUserBalance(String userId){

        int balance = 0;

        for( String billId: billService.billDetails.keySet()){
            Bill bill = billService.billDetails.get(billId);

            if (bill.getContributions().containsKey(userId)){
                balance = balance - bill.getContributions().get(userId);
            }
            if(bill.getPaidBy().containsKey(userId)){
                balance = balance + bill.getPaidBy().get(userId);
            }
        }

        return balance;
    }

    @Override
    public String toString() {
        return "BillController{" +
                "billService=" + billService +
                '}';
    }
}
