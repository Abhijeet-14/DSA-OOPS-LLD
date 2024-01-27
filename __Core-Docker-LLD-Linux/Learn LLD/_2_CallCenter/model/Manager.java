package LLD._2_CallCenter.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager extends Employee{
    public static Map<String,Manager> allManager= new HashMap<>();

    public Manager(String employeeId, String name ){
        super(employeeId, name, JobType.Manager);
    }
}
