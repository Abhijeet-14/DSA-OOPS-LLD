package LLD._2_CallCenter;

import LLD._2_CallCenter.api.CallHandlerController;
import LLD._2_CallCenter.api.EmployeeController;
import LLD._2_CallCenter.model.*;
import LLD._2_CallCenter.service.CallHandlerService;
import LLD._2_CallCenter.service.CallService;
import LLD._2_CallCenter.service.EmployeeService;

public class Driver {
    public static void main(String[] args) throws Exception {
        CallHandlerController callController = new CallHandlerController(new CallHandlerService(), new CallService());
        EmployeeController employeeController = new EmployeeController(new EmployeeService());

        // 2 Respondent
        Employee respondent1 = employeeController.createEmployee("R1","John", JobType.Respondent);
        Employee respondent2 = employeeController.createEmployee("R2","patrick", JobType.Respondent);

        // 2 Manager
        Employee manager1 = employeeController.createEmployee("M1","cena", JobType.Manager);
        Employee manager2 = employeeController.createEmployee("M2","kris", JobType.Manager);

        // 2 Director
        Employee director1 = employeeController.createEmployee("D1","Pean", JobType.Director);
        Employee director2 = employeeController.createEmployee("D2","Ronn", JobType.Director);

        System.out.println(Respondent.allRespondent.values());
        System.out.println(Director.allDirector.values());
        System.out.println(Manager.allManager.values());

        Call call1 = callController.createCall("C1");
        Call call2 = callController.createCall("C2");
        Call call3 = callController.createCall("C3");

        System.out.println(callController.assignCall(call1));
        System.out.println(callController.assignCall(call2));
        System.out.println(callController.assignCall(call3));

        System.out.println(callController.assignCall(call3));

        callController.hungUpCall(call3);

        System.out.println(callController.assignCall(call3));

        System.out.println(Call.allCalls);
    }
}


