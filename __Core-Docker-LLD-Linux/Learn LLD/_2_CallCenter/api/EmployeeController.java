package LLD._2_CallCenter.api;

import LLD._2_CallCenter.model.Employee;
import LLD._2_CallCenter.model.JobType;
import LLD._2_CallCenter.service.EmployeeService;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Employee createEmployee(String employeeId, String name, JobType jobTitle) throws Exception{
        return this.employeeService.createEmployee(employeeId, name, jobTitle);
    }
}
