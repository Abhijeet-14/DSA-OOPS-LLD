package LLD._2_CallCenter.service;

import LLD._2_CallCenter.exception.CanTCreateEmployee;
import LLD._2_CallCenter.model.*;

public class EmployeeService {

    public Employee createEmployee(String employeeId, String name, JobType jobTitle) throws Exception {
        if(jobTitle.equals(JobType.Director)) {
            Director director = new Director(employeeId, name);
            Director.allDirector.put(employeeId, director);
            return director;

        } else if(jobTitle.equals(JobType.Manager)) {
            Manager manager = new Manager(employeeId, name);
            Manager.allManager.put(employeeId, manager);
            return manager;

        } else if(jobTitle.equals(JobType.Respondent)) {
            Respondent respondent = new Respondent(employeeId, name);
            Respondent.allRespondent.put(employeeId, respondent);
            return respondent;
        } else
            throw new CanTCreateEmployee();
    }
}
