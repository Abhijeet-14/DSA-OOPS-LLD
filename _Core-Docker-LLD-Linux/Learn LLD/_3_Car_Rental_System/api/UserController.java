package LLD._3_Car_Rental_System.api;

import LLD._3_Car_Rental_System.model.User;
import LLD._3_Car_Rental_System.model.Vehicle;
import LLD._3_Car_Rental_System.service.StationService;
import LLD._3_Car_Rental_System.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(
            UserService userService
    ){
        this.userService = userService;
    }

    public User createUser(String id, String name){
        return this.userService.createUser(id,name);
    }

    public User dropVehicle(String dropPoint, String userId){
        return this.userService.dropVehicle(dropPoint, userId);
    }

    public User bookVehicle(Vehicle vehicle, String pickUpPoint, String userId){
        return this.userService.bookVehicle(vehicle, pickUpPoint, userId);
    }
}
