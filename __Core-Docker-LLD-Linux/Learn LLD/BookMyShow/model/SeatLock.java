package LLD.BookMyShow.model;

public class SeatLock {
    private Seat seat;
    private Show show;
    private int timeoutSeconds = 3;
    private String lockTime;
    private String lockedBy;

    public boolean isLockExpired(){
        timeoutSeconds--;
        return this.timeoutSeconds == 0;
    }
}
