package LLD._0_Flipkart_Machin_Coding.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    public static Map<String, Restaurant> allRestaurant = new HashMap<>();

    private String name;
    private List<Rate> ratings;
    // Map<UserName,Rate>
    public Restaurant(String name){
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }


    public void addRating(Rate rate){
        if(this.ratings == null)
            ratings =new ArrayList<>();
        this.ratings.add(rate);
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
//                ", ratings=" + ratings +
                '}';
    }
}
