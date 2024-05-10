package LLD._2_CallCenter.service;

import LLD._2_CallCenter.model.*;

import java.util.*;

public class CallHandlerService {
    public String assignCall(Call call) {
        if(call.getAssignTo() != null)
            return "\nAlready assigned to an Employee: " + call.getAssignTo().toString();

        Employee employee;

        List<List<Employee>> employeeList = new ArrayList<>();
        employeeList.add(new ArrayList<>(Respondent.allRespondent.values()));
        employeeList.add(new ArrayList<>(Manager.allManager.values()));
        employeeList.add(new ArrayList<>(Director.allDirector.values()));

        for(int index = 0; index < 3; index++) {
            employee = assignToType(employeeList.get(index), call);

            if(employee != null) {
                Call.allCalls.put(call.getId(), call);

                return "\nSuccessfully assigned the call to:" +
                        "\n\tEmployeeName: " + employee.getName() +
                        "\n\tEmployeeId: " + employee.getEmployeeId() +
                        "\n\tEmployeeType: " + employee.getJobTitle();
            }
        }

        return "Sorry, No Employee is available to take your call at this moment!";

    }

    public Employee assignToType(List<Employee> employeeList, Call call) {
        for(Employee employee : employeeList) {
            if(!employee.isOnCall()) {
                call.setAssignTo(employee);
                employee.setOnCall(true);
                return employee;
            }
        }

        return null;
    }

    public void hungUpCall(Call call) {
        Employee employee = call.getAssignTo();
        if(employee == null) {
            System.out.println("Call is Not Assigned to Any Employee");
            return;
        }
        employee.setOnCall(false);

        call.setAssignTo(null);

        System.out.println("Successfully Hung Up the call:\n\t" + call.toString() + ",  " + employee.toString() );
    }
}
