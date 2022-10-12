package LLD._0_Flipkart_Machin_Coding.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static Map<String, User> allUser = new HashMap<>();

    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
