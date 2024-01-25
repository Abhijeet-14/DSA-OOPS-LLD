package LLD._3_Car_Rental_System.api;

import LLD._3_Car_Rental_System.model.Station;
import LLD._3_Car_Rental_System.model.VehicleType;
import LLD._3_Car_Rental_System.service.StationService;

import java.util.List;
import java.util.Map;

public class StationController {
    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    public Station createStation(String id, String name, String location){
        return this.stationService.createStation(id, name, location);
    }
    public Station addVehicleToStation(String id, VehicleType type, String stationId) {
        return this.stationService.addVehicleToStation(id, type, stationId);
    }

    public Map<Station,Integer> searchVehicle(VehicleType vehicleType, String pickUpPoint){
        return this.stationService.searchVehicle(vehicleType, pickUpPoint);
    }


}
