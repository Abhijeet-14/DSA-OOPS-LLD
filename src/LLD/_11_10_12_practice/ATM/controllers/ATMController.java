package LLD._11_10_12_practice.ATM.controllers;

import LLD._11_10_12_practice.ATM.services.ATMService;

public class ATMController {
    private ATMService atmService;

    public void addATM(String atmId, int cashAmount, boolean hasCard){
        this.atmService.addATM(atmId, cashAmount, hasCard);
    }

    public void seeCurrentCash(String atmId){
        this.atmService.seeCurrentCash(atmId);
    }
}
