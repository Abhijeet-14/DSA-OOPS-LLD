package LLD.BookMyShow.db;

import LLD.BookMyShow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DB {
    public static Map<String, Screen> totalScreens = new HashMap<>();
    public static Map<String, Movie> totalMovies = new HashMap<>();
    public static Map<String, Theater> totalTheaters = new HashMap<>();
    public static Map<String, Show> totalShows = new HashMap<>();
    public static Map<String, Booking> totalBookings = new HashMap<>();
    public static Map<String, Seat> totalSeats = new HashMap<>();
    public static Map<String, User> totalUser = new HashMap<>();

//    public static List<Screen> getScreens() {
//        return new ArrayList<>(totalScreens.values());
//    }
//
//    public static void addScreens(String screenId, Screen screens) {
//        totalScreens.put(screenId, screens);
//    }
//
//    public static void removeScreens(String screenId) {
//        totalScreens.remove(screenId);
//    }
//
//    //
//    public static List<Movie> getMovies() {
//        return new ArrayList<>(totalMovies.values());
//    }
//
//    public static void addMovies(String movieId, Movie movies) {
//        totalMovies.put(movieId, movies);
//    }
//
//    public static void removeMovies(String movieId) {
//        totalMovies.remove(movieId);
//    }
//
//    //
//    public static List<Theater> getTheaters() {
//        return new ArrayList<>(totalTheaters.values());
//    }
//
//    public static void addTheater(String theaterID, Theater theater) {
//        totalTheaters.put(theaterID, theater);
//    }
//
//    public static void removeTheater(String theaterID) {
//        totalTheaters.remove(theaterID);
//    }
//
//    public static List<Show> getShows() {
//        return new ArrayList<>(totalShows.values());
//    }
//
//    public static void addShow(String showId, Show show) {
//        totalShows.put(showId, show);
//    }
//
//    public static void removeShow(String showId) {
//        totalShows.remove(showId);
//    }
//
//    public static Map<String, Booking> getBookings() {
//        return totalBookings;
//    }
//
//    public static void addBooking(String bookingId, Booking booking) {
//        totalBookings.put(bookingId, booking);
//    }
//
//    public static void removeBooking(String bookingId) {
//        totalBookings.remove(bookingId);
//    }
}
