package LLD._3_Car_Rental_System.DB;

import LLD._3_Car_Rental_System.model.Station;
import LLD._3_Car_Rental_System.model.User;
import LLD._3_Car_Rental_System.model.VehicleType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DB {
    public static Map<VehicleType, Integer> priceList =new HashMap<>();

    public static Map<String, Integer> distance =new HashMap<>();

    public DB(){
        priceList.put(VehicleType.SUV, 300);
        priceList.put(VehicleType.Sedan, 200);
        priceList.put(VehicleType.Scooter, 20);
        priceList.put(VehicleType.HatchBack, 100);
        priceList.put(VehicleType.Bike, 600);

        // Point, Distance
        distance.put("P0", 0);
        distance.put("P1", 10);
        distance.put("P2", 20);
        distance.put("P3", 30);
        distance.put("P4", 40);
        distance.put("P5", 50);
    }
}
