package LLD._0_Flipkart_Machin_Coding;


import LLD._0_Flipkart_Machin_Coding.api.ResturantController;
import LLD._0_Flipkart_Machin_Coding.api.UserController;
import LLD._0_Flipkart_Machin_Coding.model.Restaurant;
import LLD._0_Flipkart_Machin_Coding.model.User;
import LLD._0_Flipkart_Machin_Coding.service.RestaurantService;
import LLD._0_Flipkart_Machin_Coding.service.UserService;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Flipkart Machine Coding\n");


        ResturantController resturantController = new ResturantController(new RestaurantService());
        UserController userController = new UserController(new UserService());

        resturantController.addRestaurant("restaurant1");
        resturantController.addRestaurant("restaurant2");
        resturantController.addRestaurant("restaurant3");
        resturantController.addRestaurant("restaurant1");

        userController.addUser("user1");
        userController.addUser("user2");
        userController.addUser("user1");

        System.out.println(Restaurant.allRestaurant);
        System.out.println(User.allUser);
        System.out.println();

        resturantController.addRating("user1", "restaurant1", 5);

        resturantController.addRating("user2", "restaurant1", 9);
        resturantController.addRating("user1", "restaurant2", 7);
//        resturantController.addRating("user2", "restaurant1", 8);


        resturantController.addRating("user1", "restaurant2", 7,
                Arrays.asList("dosa", "samosa"),
                "Samosa and tea were good");
        resturantController.addRating("user2", "restaurant1", 8,
                Arrays.asList("dosa"),
                "Dosa was awesome");

        System.out.println(resturantController.getRestaurant("restaurant1"));
        System.out.println(resturantController.getRestaurant("restaurant2"));
        System.out.println(resturantController.getRestaurant("restaurant3"));
        System.out.println();

        System.out.println(resturantController.listRatings("restaurant1", 5));
        System.out.println();

//        System.out.println(resturantController.listRatings("restaurant1", 7));
        System.out.println(resturantController.listRatings("restaurant1",
                2, 5, 8, "desc"));
        System.out.println("\n");

        System.out.println(resturantController.getRestaurant("restaurant1"));

        System.out.println(resturantController.listRestaurant(1));

    }
}
