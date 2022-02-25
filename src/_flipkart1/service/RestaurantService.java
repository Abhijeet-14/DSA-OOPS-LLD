package service;

import model.Rate;
import model.Restaurant;
import model.User;

import java.util.*;

public class RestaurantService {

    public void addRestaurant(String name) {
        if(Restaurant.allRestaurant.get(name)!=null)
        {
            System.out.println("Restaurant Already Exist");
            return;
        }
        Restaurant newRestaurant = new Restaurant(name);
        Restaurant.allRestaurant.put(name, newRestaurant);
    }

    public void addRating(String userName, String restaurantName, int rate) {
        Restaurant restaurant = Restaurant.allRestaurant.get(restaurantName);
        User user = User.allUser.get(userName);
        // map contains user..
        // user1 -> 4

        if(rate >= 0 && rate <= 10) {
            restaurant.addRating(new Rate(rate));
            Restaurant.allRestaurant.put(restaurantName, restaurant);

        } else {
            System.out.println("Rate value should be in between 0-10");
        }
    }

    public void addRating(String userName, String restaurantName, int rate,
                          List<String> dishes, String review) {
        Restaurant restaurant = Restaurant.allRestaurant.get(restaurantName);
        User user = User.allUser.get(userName);

        if(rate >= 0 && rate <= 10) {
            restaurant.addRating(new Rate(rate, dishes, review));
            Restaurant.allRestaurant.put(restaurantName, restaurant);
        } else {
            System.out.println("Rate value should be in between 0-10");
        }
    }

    public List<String> listRatings(String restaurantName, int noOfRatings) {
        Restaurant restaurant = Restaurant.allRestaurant.get(restaurantName);
        List<Rate> ratings = restaurant.getRatings();

        Collections.sort(ratings, (a, b) -> -a.getRate() + b.getRate());
        List<String> result = new ArrayList<>();


        for(Rate rate : restaurant.getRatings()) {
            if(noOfRatings == 0)
                break;
            result.add("Rating: " + rate.getRate() + "Items: " + rate.getDishes()
                    + "Review: " + rate.getReview());
            noOfRatings--;
        }

        return result;
    }

    public List<String> listRatings(String restaurantName, int noOfRatings, int lower, int higher, String orderBy) {
        Restaurant restaurant = Restaurant.allRestaurant.get(restaurantName);
        List<Rate> ratings = restaurant.getRatings();

        Collections.sort(ratings, (a, b) -> -a.getRate() + b.getRate());
        List<Rate> result = new ArrayList<>();

        for(Rate rate : ratings) {
            if(rate.getRate() >= lower && rate.getRate() <= higher) {
                result.add(rate);
            }
        }

        List<String> stringResult = new ArrayList<>();

        if(orderBy.equals("asc")) {
            Collections.sort(result, (a, b) -> a.getRate()- b.getRate());
        }

        for(Rate rate : result) {
            if(noOfRatings == 0)
                break;
            stringResult.add("Rating: " + rate.getRate() + "Items: " + rate.getDishes()
                    + "Review: " + rate.getReview());
            noOfRatings--;

        }

        return stringResult;
    }

    public String getRestaurant(String restaurantName) {
        Restaurant restaurant = Restaurant.allRestaurant.get(restaurantName);

        if(restaurant == null) {
            System.out.println("Restaurant Doesn't Exist");
        }

        List<Rate> ratings = restaurant.getRatings();

        return "Name: " + restaurant.getName() + " Rating: " + findAverage(ratings);
    }

    public List<String> listRestaurant(int noOfRestaurant) {
        List<Restaurant> restaurantList = new ArrayList<>(Restaurant.allRestaurant.values());

        List<String> result = new ArrayList<>();

        for(Restaurant restaurant : restaurantList) {

            double averageRating = findAverage(restaurant.getRatings());
            result.add("Name: " + restaurant.getName() + " Rating: " + averageRating);

        }

        // Sorting
        Collections.sort(result, (a, b) -> b.split("Rating:")[1].compareTo(a.split("Rating:")[1]));

        List<String> stringsResult = new ArrayList<>();

        for(String restaurantAndRating : result) {
            if(noOfRestaurant == 0)
                break;
            stringsResult.add(restaurantAndRating);
            noOfRestaurant--;
        }
        return stringsResult;
    }

    public double findAverage(List<Rate> ratings) {
        if(ratings.size() == 0)
            return 0;

        int sumOfRatings = 0;

//        System.out.println(ratings.toString());
        for(Rate rate : ratings) {
            sumOfRatings += rate.getRate();
        }

        return (double) sumOfRatings / ratings.size();
    }
}
