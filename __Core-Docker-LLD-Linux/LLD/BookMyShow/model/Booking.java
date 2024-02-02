package LLD.BookMyShow.model;

import LLD.BookMyShow.exceptions.BookingNotCreated;

import java.util.*;

public class Booking {
    private String id;
    private String showId;
    private String userId;
    private int totalSeats;
    private List<Seat> seatsBooked;
    private BookingStatus bookingStatus;

    public Booking(String id, String showId,
                   String userId,
                   List<Seat> seatsBooked
    ){
        this.id =id;
        this.showId =showId;
        this.seatsBooked = seatsBooked;
        this.userId = userId;
        this.totalSeats = 10;
        this.bookingStatus = BookingStatus.Created;
    }

    public boolean isConfirmed(){
        return this.bookingStatus == BookingStatus.Confirmed;
    }

    public void confirmBooking() throws BookingNotCreated {
        if(this.bookingStatus !=  BookingStatus.Created){
            throw new BookingNotCreated();
        }

        this.bookingStatus = BookingStatus.Confirmed;
    }

    // GETTER & SETTER


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<Seat> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
