package LLD._2_CallCenter.model;

import java.util.HashMap;
import java.util.Map;

public class Call {

    private String id;
    private Employee assignTo;

    public static Map<String, Call> allCalls = new HashMap<>();

    public Call(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Employee assignTo) {
        this.assignTo = assignTo;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id='" + id + '\'' +
                ", assignTo=" + assignTo +
                '}';
    }
}
