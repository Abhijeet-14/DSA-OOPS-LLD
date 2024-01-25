package LLD.BookMyShow.services;

import LLD.BookMyShow.db.DB;
import LLD.BookMyShow.model.Movie;

import java.util.UUID;

public class MovieService {

    public Movie getMovie(String movieId){
        return DB.totalMovies.get(movieId);
    }

    public Movie createMovie(String name){
        String movieId = UUID.randomUUID().toString();

        Movie movie = new Movie(movieId, name);

        DB.totalMovies.put(movieId, movie);

        return movie;
    }
}
