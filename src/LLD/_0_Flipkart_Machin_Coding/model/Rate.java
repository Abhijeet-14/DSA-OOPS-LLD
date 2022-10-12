package LLD._0_Flipkart_Machin_Coding.model;

import java.util.List;

public class Rate {
    private int rate;
    private List<String> dishes;
    private String review;

    public Rate(int rate){
        this.rate = rate;
        this.dishes = null;
    }

    public Rate(int rate, List<String> dishes, String review) {
        this.rate = rate;
        this.dishes = dishes;
        this.review = review;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public void setDishes(List<String> dishes) {
        this.dishes = dishes;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rate=" + rate +
                ", dishes=" + dishes +
                ", review='" + review + '\'' +
                '}';
    }
}
