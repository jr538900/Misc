/*CSCI 1101 – Assignment 3 – Client3.java
This program will use SystemManager to make flight bookings.
(Provided in the assignment) 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Client3
{
   public static void main (String[] args)
   {
      SystemManager res = new SystemManager();
      
      //create airports
      res.createAirport("YHZ");
      res.createAirport("YYZ");
      res.createAirport("YUL");
      res.createAirport("YVR");
      res.createAirport("YYC");
      res.createAirport("LONDON"); //invalid
      res.createAirport("123"); //invalid
      res.createAirport("YEG");
      res.createAirport("BOS");
      res.createAirport("JFK");
      
      //create airlines
      res.createAirline("AC");
      res.createAirline("DELTA");
      res.createAirline("USAIR");
      res.createAirline("WSJET");
      res.createAirline("FRONTIER"); //invalid
      
      //create flights
      res.createFlight("AC", "YHZ", "YUL", "123");
      res.createFlight("AC", "YHZ", "YYZ", "567");
      res.createFlight("AC", "YUL", "YHZ", "789");
      res.createFlight("AC", "YUL", "YVR", "123"); //invalid – AC cannot have two flights with same id.
      res.createFlight("AC", "YHZ", "YYZ", "689");
      res.createFlight("DELTA", "YHZ", "BOS", "123");
      
      
      //create seats
      res.createSeats("AC", "123", 40);
      res.createSeats("DELTA", "123", 25);
      res.createSeats("AC", "567", 10);
      res.createSeats("AC", "789", 45);
      res.createSeats("AC", "689", 20);
      
      //find available flights
      res.findAvailableFlights("YHZ", "YYZ");
      
      //book seats
      res.bookSeat("AC", "123", 1, 'A');
      res.bookSeat("AC", "123", 20,'F');
      res.bookSeat("AC", "506", 2, 'B'); //invalid – 506 not created
      res.bookSeat("AC", "123", 55, 'C'); //invalid – row 55 doesn’t exist
      
      //display system details
      res.displaySystemDetails();
   }  
}
