package LLD.BookMyShow.services;

import LLD.BookMyShow.db.DB;
import LLD.BookMyShow.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    public List<Seat> getAvailableSeat(){
        List<Seat> result = new ArrayList<>();

        for(Seat seat: DB.totalSeats.values()){
            if (!seat.isBooked())
                result.add(seat);
        }
        return result;
    }

    public List<Seat> getBookedSeat(){
        List<Seat> result = new ArrayList<>();

        for(Seat seat: DB.totalSeats.values()){
            if (seat.isBooked())
                result.add(seat);
        }
        return result;
    }
}
