package LLD._3_Car_Rental_System;

import LLD._3_Car_Rental_System.DB.DB;
import LLD._3_Car_Rental_System.api.StationController;
import LLD._3_Car_Rental_System.api.UserController;
import LLD._3_Car_Rental_System.model.Station;
import LLD._3_Car_Rental_System.model.User;
import LLD._3_Car_Rental_System.model.Vehicle;
import LLD._3_Car_Rental_System.model.VehicleType;
import LLD._3_Car_Rental_System.service.StationService;
import LLD._3_Car_Rental_System.service.UserService;

public class Driver {
    public static void main(String[] args) {
        // Initiate DB
        new DB();

        System.out.println(DB.distance);
        System.out.println(DB.priceList);

        UserController userController = new UserController(new UserService());
        StationController stationController = new StationController(new StationService());

        User user1 = userController.createUser("U1", "John");
        User user2 = userController.createUser("U2", "Mike");

        System.out.println(User.userList);

        Station station1  = stationController.createStation("s1", "Tata", "P2");
        Station station2  = stationController.createStation("s2", "KGP", "P5");


        stationController.addVehicleToStation("v1", VehicleType.SUV, station1.getId() );
        stationController.addVehicleToStation("v2", VehicleType.Sedan, station1.getId() );
        stationController.addVehicleToStation("v3", VehicleType.Bike, station2.getId() );
        stationController.addVehicleToStation("v3", VehicleType.SUV, station2.getId() );

        System.out.println(Station.stationList);
        System.out.println();
        System.out.println(stationController.searchVehicle(VehicleType.SUV, "P0"));

        Vehicle v1 = new Vehicle("v1", VehicleType.SUV, station1);
        System.out.println(userController.bookVehicle(v1, "P3", "U1"));
        System.out.println(userController.dropVehicle( "P5", "U1"));
    }
}
