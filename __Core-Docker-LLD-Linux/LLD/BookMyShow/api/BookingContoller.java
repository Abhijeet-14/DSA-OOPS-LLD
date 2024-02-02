package LLD.BookMyShow.api;

import LLD.BookMyShow.db.DB;
import LLD.BookMyShow.model.Booking;
import LLD.BookMyShow.model.Seat;
import LLD.BookMyShow.model.Show;
import LLD.BookMyShow.services.BookingServices;
import LLD.BookMyShow.services.SeatAvailabilityService;
import LLD.BookMyShow.services.ShowService;
import LLD.BookMyShow.services.TheaterService;

import java.util.ArrayList;
import java.util.List;

public class BookingContoller {

    private ShowService showService;
    private SeatAvailabilityService seatAvailabilityService;
    private BookingServices bookingServices;
    private TheaterService theaterService;

    public String createBooking(
            String screenId,
            String showId,
            String userId,
            List<String> seatIds
    ) throws Exception {

        Show show = showService.getShow(showId);

        List<Seat> seats = new ArrayList<>();

        for(String seatId: seatIds){
            Seat seat = theaterService.getSeat(seatId);
            seats.add(seat);
        }

        return bookingServices.createBooking(screenId, userId, showId, seats).getId();
    }

}
