//package LLD.FoodKart.model;
//
//import java.util.ArrayList;
//
//public class Rating {
//    ArrayList<Comment> listOfComments;
//    ArrayList<Integer> listOfRatings;
//    int totalRatingSum;
//
//    public Rating() {
//        this.listOfComments = new ArrayList<>();
//        this.listOfRatings = new ArrayList<>();
//        this.totalRatingSum = 0;
//    }
//
//    public double getAverageRating() {
//        return this.totalRatingSum / (this.listOfRatings.size() * 1.0);
//    }
//
//    public void addRatingAndComment(String userComment, int ratingScore) {
//        Comment comment = new Comment(userComment);
//        this.listOfComments.add(comment);
//        listOfRatings.add(ratingScore);
//        totalRatingSum += ratingScore;
//    }
//}
