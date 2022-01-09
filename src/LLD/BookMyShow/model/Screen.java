package LLD.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id;
    private String name;
    private Theater theater;

    private List<Seat> seats;

    public Screen(String id, String name, Theater theater){
        this.id =id;
        this.name = name;
        this.theater = theater;
        this.seats = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
