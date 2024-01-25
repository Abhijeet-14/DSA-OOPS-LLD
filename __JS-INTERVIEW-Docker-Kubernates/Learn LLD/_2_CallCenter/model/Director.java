package LLD._2_CallCenter.model;

import java.util.HashMap;
import java.util.Map;

public class Director extends Employee {
    public static Map<String, Director> allDirector = new HashMap<>();

    public Director(String employeeId, String name) {
        super(employeeId, name, JobType.Director);
    }
}
