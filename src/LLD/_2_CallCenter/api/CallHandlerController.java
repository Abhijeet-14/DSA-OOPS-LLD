package LLD._2_CallCenter.api;

import LLD._2_CallCenter.model.Call;
import LLD._2_CallCenter.service.CallHandlerService;
import LLD._2_CallCenter.service.CallService;

public class CallHandlerController {
    private CallHandlerService callHandlerService;
    private CallService callService;

    public CallHandlerController(CallHandlerService callHandlerService, CallService callService){
        this.callHandlerService = callHandlerService;
        this.callService = callService;
    }

    public Call createCall(String id){
        return this.callService.createCall(id);
    }

    public String assignCall(Call call){
        return this.callHandlerService.assignCall(call);
    }

    public void hungUpCall(Call call){
        this.callHandlerService.hungUpCall(call);
    }
}
