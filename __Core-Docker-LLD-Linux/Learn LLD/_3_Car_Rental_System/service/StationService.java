package LLD._3_Car_Rental_System.service;

import LLD._3_Car_Rental_System.DB.DB;
import LLD._3_Car_Rental_System.model.Station;
import LLD._3_Car_Rental_System.model.User;
import LLD._3_Car_Rental_System.model.Vehicle;
import LLD._3_Car_Rental_System.model.VehicleType;

import java.util.*;

public class StationService {
    private static int currentDistance;

    public Map<Station, Integer> searchVehicle(VehicleType vehicleType, String pickUpPoint) {
        if(!DB.distance.containsKey(pickUpPoint)) {
            System.out.println("PickupPoint is Invalid");
            return null;
        }

        currentDistance = DB.distance.get(pickUpPoint);

        List<Station> stationList = new ArrayList<>(Station.stationList.values());
        if(stationList.size() == 0) {
            System.out.println("No Station is present");
            return null;
        }

//        if(vehicleType == null) {
//            System.out.println("Returning all station");
//            return stationList;
//        }

//        List<Station> availableStation = new ArrayList<>();
        Map< Station, Integer > availableStation = new HashMap<>();

        for(Station station : stationList) {
            for(Vehicle vehicle: station.getVehicles()){
                if(vehicle.getType().equals(vehicleType)) {
                    int travelPrice = DB.distance.get(station.getLocation()) - currentDistance;
                    availableStation.put(station, travelPrice + DB.priceList.get(vehicleType));
                }
            }
        }

        // lowest to highest

        // if match nearer
//        Object avaStationList[] = availableStation.entrySet().toArray();
//        Collections.sort(availableStation,
//                (a,b) ->
//                        (DB.distance.get(a.getLocation()) - currentDistance)
//                                - (DB.distance.get(a.getLocation()) - currentDistance)
//        );
//        List<List<Station>> result = new ArrayList<>();
//        availableStation.keySet();

        return availableStation;//availableStation.keySet());
    }

    public Station createStation(String id, String name, String location) {
        Station station = new Station(id, name, location);
        Station.stationList.put(id, station);

        return station;
    }

    public Station addVehicleToStation(String id, VehicleType type, String stationId) {
        if(Station.stationList.containsKey(stationId)) {
            Station station = Station.stationList.get(stationId);
            station.getVehicles().add(new Vehicle(id, type, station));

            return station;
        }

        System.out.println("Station Id is invalid");
        return null;
    }
}

