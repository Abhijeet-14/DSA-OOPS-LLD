package LLD._3_Car_Rental_System.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static Map<String, User> userList =new HashMap<>();

    private String id;
    private String name;
    private Vehicle vehicle;
    private String bookPoint;
    private String dropPoint;
    private int travelCost;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getBookPoint() {
        return bookPoint;
    }

    public void setBookPoint(String bookPoint) {
        this.bookPoint = bookPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(String dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(int travelCost) {
        this.travelCost = travelCost;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", vehicle=" + vehicle +
                ", bookPoint='" + bookPoint + '\'' +
                ", dropPoint='" + dropPoint + '\'' +
                ", travelCost='" + travelCost + '\'' +
                '}';
    }
}
