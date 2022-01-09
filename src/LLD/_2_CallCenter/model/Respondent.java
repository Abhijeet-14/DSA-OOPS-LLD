package LLD._2_CallCenter.model;

import java.util.HashMap;
import java.util.Map;

public class Respondent extends Employee{
    public static Map<String, Respondent> allRespondent = new HashMap<>();

    public Respondent(String employeeId, String name ){
        super(employeeId, name, JobType.Respondent);
    }
}
