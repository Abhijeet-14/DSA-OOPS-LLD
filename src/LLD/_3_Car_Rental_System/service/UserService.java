package LLD._3_Car_Rental_System.service;

import LLD._3_Car_Rental_System.DB.DB;
import LLD._3_Car_Rental_System.model.Station;
import LLD._3_Car_Rental_System.model.User;
import LLD._3_Car_Rental_System.model.Vehicle;

public class UserService {

    public User bookVehicle(Vehicle vehicle, String pickUpPoint, String userId){
        if(!DB.distance.containsKey(pickUpPoint)){
            System.out.println("PickupPoint is Invalid");
            return null;
        }

        User user = User.userList.get(userId);
        user.setBookPoint(pickUpPoint);
        user.setVehicle(vehicle);
        return user;
    }

    public User dropVehicle(String dropPoint, String userId){
        if(!DB.distance.containsKey(dropPoint)){
            System.out.println("PickupPoint is Invalid");
            return null;
        }

        User user = User.userList.get(userId);

        int travelDistance = 0;
        if(user.getBookPoint().equals(dropPoint))
            travelDistance = 50;
        else
            travelDistance = DB.distance.get(dropPoint) - DB.distance.get(user.getBookPoint());

        System.out.println(user);
        user.setDropPoint(dropPoint);
        user.setTravelCost(travelDistance + DB.priceList.get(user.getVehicle().getType()));

        user.setVehicle(null);

        return user;
    }

    public User createUser(String id, String name){
        User user =  new User(id, name);
        User.userList.put(id, user);
        return user;
    }
}
