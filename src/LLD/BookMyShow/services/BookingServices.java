package LLD.BookMyShow.services;

import LLD.BookMyShow.exceptions.BookingNotFound;
import LLD.BookMyShow.exceptions.SeatAlreadyBooked;
import LLD.BookMyShow.model.*;

import java.util.*;

import LLD.BookMyShow.db.DB;

public class BookingServices {


//    public BookingServices(Map<String, Booking> showBookings){
//        this.totalB = new HashMap<>();
//    }

    public Booking getBooking(String bookingId) throws BookingNotFound {
        if (!DB.totalBookings.containsKey(bookingId))
            throw new BookingNotFound();

        return DB.totalBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(String showId){
        List<Booking> result = new ArrayList<>();

        for(Booking booking: DB.totalBookings.values()){
            if (booking.getShowId().equals(showId))
                result.add(booking);
        }
        return result;
    }

    public Booking createBooking(String screenId,
                                 String userId,
                                 String showId,
                                 List<Seat> seats) throws Exception{
        // check if seats are booked.
        if(DB.totalScreens.containsKey(screenId) ){
            Screen screen = DB.totalScreens.get(screenId);

            List<Seat> allSeat = screen.getSeats();

            for (Seat seat: seats){
                if( allSeat.contains(seat))
                    throw new SeatAlreadyBooked();
            }
        }


        String bookingId = UUID.randomUUID().toString();
        Booking newBooking = new Booking(bookingId, showId, userId, seats);

        DB.totalBookings.put(bookingId, newBooking);

        return newBooking;
    }



}

