package LLD._3_Car_Rental_System.model;

import java.util.*;

public class Station  {
    public static Map<String, Station> stationList =new HashMap<>();

    private String id;
    private String name;
    private List<Vehicle> vehicles;
    private String location;

    public Station(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
