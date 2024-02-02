package LLD._2_CallCenter.model;

import java.util.HashMap;
import java.util.Map;

public  class Employee {

    private String employeeId;
    private String name;
    private JobType jobTitle;
    private boolean onCall;

    public Employee(String employeeId, String name, JobType jobTitle){
        this.employeeId = employeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.onCall = false;
    }


    // Getter & Setter

    public boolean isOnCall() {
        return onCall;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobType jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle=" + jobTitle +
                ", onCall=" + onCall +
                '}';
    }
}
