package LLD._11_10_12_practice.SplitWise.models;

import java.util.HashMap;

public class User {
    private String id;
    private String name;
    private HashMap<String, Integer> dues;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.dues = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getDues() {
        return dues;
    }

    public void setDues(HashMap<String, Integer> dues) {
        this.dues = dues;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dues=" + dues +
                '}';
    }
}
