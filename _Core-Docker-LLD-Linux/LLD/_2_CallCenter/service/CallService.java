package LLD._2_CallCenter.service;

import LLD._2_CallCenter.model.Call;

public class CallService {

    public Call createCall(String id){
        return new Call(id);
    }
}
