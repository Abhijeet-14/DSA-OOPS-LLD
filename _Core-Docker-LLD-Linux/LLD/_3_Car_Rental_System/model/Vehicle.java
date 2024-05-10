package LLD._3_Car_Rental_System.model;

import LLD._3_Car_Rental_System.DB.DB;

public class Vehicle {
    private String id;
    private VehicleType type;
    private Station station;

    public Vehicle(String id, VehicleType type, Station station) {
        this.id = id;
        this.type = type;
        this.station = station;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station pickUpPoint) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", type=" + type +
//                ", station=" + station +
                '}';
    }
}
