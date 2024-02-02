# Movie Ticket Booking Applicaiton

Implement a Movie Ticket Booking Application for a Theater. Refer to the following details.
 - A Theater has Screens that run SHows for different Movies. Each Show has a particular Movie, start time, duration, amd is played 
    in a particular Screen in the theater. Each Screen has an arrangement of Seats that can be booked by Users.
 - Assume all users are registered, authentication and loggedin to the application.
 - Once a User selects a particular show to book tickets for a UserBookingSessions start. When this UserBookingSessions, a User
    will be able.
   

### Case 1:
    1. Say U1,U2 select same show.
    2. U1 requests for and get all Available Seats for this show.
    3. U1 selects group of seats and proceeds to pay.
    4. U2 request for and gets all Available Seats for this show.
        U2 should not see the seats selected by U1 as Available.
    5. Payment Succeeded for U1.
    6. U1 receives Ticket with Seats confirmed.

### Case 2:
    1. U1 U2 select same show.
    2. U1 U2 requests for and gets all available seats for this show.
    3. U1 selects group of seats
    4. U1 proceeds to pay
    5. U2 requests for and gets all available seats for this show.
        U2 should NOT see the seats selected by U1 as AVAILABLE
    6. Payment failed for U1. max 3 try.
        Also show in another scenario where U1's UserBookingSession is 
        explicitly closed by U1 before payment is completed.
    7. U2 again request for and gets all Available seats for this show U2 should
        now see the seats previously selected by U1 as AVAILABLE.

### Case 3:
    1. U1 U2 select same show.
    2. U1 U2 request for and get all Available seats for this show.
    3. U1 selects group of seats and proceeds to pay.
    4. U2 selects overlapping group of seats and proceeds to pay.
        U2 should be notified that one or more of the selected seat are not available at his moment.

### Bonus:
    Have a configuration for a UserBookingSession. Show that if User selects
    and Payment is not completed by timeout, then the UserBooking Session is closed 
    and seats selected are made AVAILABLE.

### Expectation: