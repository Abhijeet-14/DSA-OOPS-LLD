package LLD._11_10_12_practice.ATM.services;

import LLD._11_10_12_practice.ATM.models.ATM;

import java.util.HashMap;

public class ATMService {
    public static HashMap<String, ATM> atmList;
    public void addATM(String atmId, int cashAmount, boolean hasCard) {
        ATM newAtm = new ATM(atmId,cashAmount,false);
    }

    public void seeCurrentCash(String atmId) {
        System.out.println(atmList.get(atmId).getCashAmount());
    }
}
