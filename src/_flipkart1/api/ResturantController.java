package api;

import service.RestaurantService;

import java.util.List;

public class ResturantController {
    private RestaurantService restaurantService;

    public ResturantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void addRestaurant(String name) {
        this.restaurantService.addRestaurant(name);
    }

    public void addRating(String username, String restaurantName, int rate) {
        this.restaurantService.addRating(username, restaurantName, rate);
    }

    public void addRating(String username, String restaurantName, int rate, List<String> dishes, String review) {
        this.restaurantService.addRating(username, restaurantName, rate, dishes, review);
    }

    public List<String> listRatings(String restaurantName, int noOfRatings) {
        return this.restaurantService.listRatings(restaurantName, noOfRatings);
    }

    public List<String> listRatings(String restaurantName, int noOfRatings, int lower, int higher, String orderBy) {
        return this.restaurantService.listRatings(restaurantName, noOfRatings, lower, higher, orderBy);
    }

    public String getRestaurant(String restaurantName) {
        return this.restaurantService.getRestaurant(restaurantName);
    }

    public List<String> listRestaurant(int noOfRestaurant) {
        return this.restaurantService.listRestaurant(noOfRestaurant);
    }

}
