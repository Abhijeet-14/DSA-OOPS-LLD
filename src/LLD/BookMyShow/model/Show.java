package LLD.BookMyShow.model;

public class Show {
    private String id;
    private String movieId;
    private String screenId;
    private String startTime;
    private int durationInSec;

    public Show(String id, String movieId, String screenId) {
        this.id = id;
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = "today!";
        this.durationInSec = 3600;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }
}
