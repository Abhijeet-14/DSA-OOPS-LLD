package LLD.BookMyShow.services;

import LLD.BookMyShow.db.DB;
import LLD.BookMyShow.exceptions.BadInput;
import LLD.BookMyShow.model.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShowService {

    public Show getShow(String showId) throws Exception{
        if(!DB.totalShows.containsKey(showId))
            throw new BadInput();

        return DB.totalShows.get(showId);
    }

    public Show createShow(String movieId, String screenID){
        String showId = UUID.randomUUID().toString();
        Show newShow = new Show(showId, movieId, screenID);

        DB.totalShows.put(showId, newShow);
        return newShow;
    }

    public List<Show> getShowForScreen(String screenId){
        List<Show> shows = new ArrayList<>();
        for(Show show: DB.totalShows.values()){
            if(show.getScreenId().equals(screenId))
                shows.add(show);
        }

        return shows;
    }
}
