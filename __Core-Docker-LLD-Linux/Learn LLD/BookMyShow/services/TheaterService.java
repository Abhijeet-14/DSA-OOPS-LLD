package LLD.BookMyShow.services;

import LLD.BookMyShow.db.DB;
import LLD.BookMyShow.exceptions.BadInput;
import LLD.BookMyShow.model.Screen;
import LLD.BookMyShow.model.Seat;
import LLD.BookMyShow.model.Theater;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TheaterService {

    public Seat getSeat( String seatId) throws Exception{
        if (!DB.totalSeats.containsKey(seatId)){
            throw new BadInput();
        }

        return DB.totalSeats.get(seatId);
    }

    public Theater getTheater(String theaterId) throws Exception{
        if (!DB.totalTheaters.containsKey(theaterId)){
            throw new BadInput();
        }

        return DB.totalTheaters.get(theaterId);
    }

    public Screen getTheater(Screen screenId) throws Exception{
        if (!DB.totalScreens.containsKey(screenId)){
            throw new BadInput();
        }

        return DB.totalScreens.get(screenId);
    }

    public Theater createTheater(String name){
        String theaterId = UUID.randomUUID().toString();
        Theater newTheater = new Theater(theaterId, name);

        DB.totalTheaters.put(theaterId, newTheater);

        return newTheater;
    }

    public Theater addScreenInTheater(String theaterId, String screenName) {

        Theater theater = DB.totalTheaters.get(theaterId);

        Screen newScreen = createScreen(screenName, theater);

        theater.addScreen(newScreen);
        DB.totalTheaters.put(theaterId, theater);

        return theater;
    }

    public Screen createScreen(String screenName, Theater theater){
        String screenId = UUID.randomUUID().toString();

        Screen newScreen = new Screen(screenId, screenName, theater);
        DB.totalScreens.put(screenId, newScreen);

        return newScreen;
    }

    public void addSeatsInScreen(int rowNo, int seatNo, String screenId){
        String seatId = UUID.randomUUID().toString();

        Seat newSeat = new Seat(seatId, rowNo, seatNo);
        DB.totalSeats.put(seatId, newSeat);

        List<Seat> seatList = new ArrayList<>();
        seatList.add(newSeat);

        DB.totalScreens.get(screenId).setSeats(seatList);
    }

}
