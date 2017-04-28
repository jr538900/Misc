/*CSCI 1101 – Assignment 3 – Client1.java
This program will coordinate the Airport, Airline, Flight, and Seat classes, 
and keep track of all occuring flights.
Client1 codes for the simplest case of all 3 clients. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Client1
{
   public static void main(String[] args)
   {
      SystemManager sm = new SystemManager();
      
      //Creates airport.
      sm.createAirport("HFX");
      sm.createAirport("TOR");
      
      //Creates airline.
      sm.createAirline("JAZZ");
      
      //Creates flight.
      sm.createFlight("JAZZ", "HFX", "TOR", "001");
      
      //Creates seats for flight.
      sm.createSeats("JAZZ", "001", 10);
      
      //Books all seats on the plane.
      for(int i=1; i<=10; i++)
         for(int j = 65; j<=70; j++)
            sm.bookSeat("JAZZ", "001", i, (char)j);
      
      //Tries to book one more seat.
      sm.bookSeat("JAZZ", "001", 1, 'A');
      
      //Displays status of flights, airports, etc.
      sm.displaySystemDetails();
   }
}            