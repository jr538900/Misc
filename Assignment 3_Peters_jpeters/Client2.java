/*CSCI 1101 – Assignment 3 – Client2.java
This program will use SystemManager to make flight bookings.
(My own original code) 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Client2
{
   public static void main(String[] args)
   {
      SystemManager smgr = new SystemManager();
      
      //Adding airports.
      smgr.createAirport("ABC");
      smgr.createAirport("DEF");
      smgr.createAirport("GHI");
      smgr.createAirport("ABC"); //Invalid airport-already listed
      smgr.createAirport("WXYZ"); //Invalid airport-too many characters
      
      //Adding airlines.
      smgr.createAirline("AC");
      smgr.createAirline("WJET");
      smgr.createAirline("JBLUE");
      smgr.createAirline("UNITD");
      smgr.createAirline("WJET");   //Invalid airline-already listed
      smgr.createAirline("DREAMLINER");   //Invalid airline-too many characters.
      
      //Adding valid flights and their corresponding seats.
      smgr.createFlight("WJET", "ABC", "DEF", "123");
      smgr.createSeats("WJET", "123", 30);
      smgr.createFlight("AC", "ABC", "DEF", "113");
      smgr.createSeats("AC", "113", 15);
      smgr.createFlight("UNITD", "DEF", "GHI", "200");
      smgr.createSeats("UNITD", "200", 20);
      
      //Adding invalid flights.
      smgr.createFlight("WJET", "DEF", "GHI", "666"); //Invalid flight-no seats.
      smgr.createFlight("AC", "DEF", "GHI", "113");   //Invalid flight-ID already listed
      smgr.createFlight("AC", "ABC", "ABC", "789");   //Invalid flight-destination matches the origin.
      smgr.createFlight("SWISS", "ABC", "GHI", "101");   //Invalid flight-airline was not defined.
      smgr.createFlight("AC", "XYZ", "ABC", "112");   //Invalid flight-destination or arrival airports were not defined.
      
      
      //Creates invalid seats to test the createSeats" method.
      smgr.createSeats("AC", "113", 15);  //Invalid seat creation-The set of seats for the airplane is already created.
      smgr.createSeats("AC", "456", 66);  //Invalid seat creation-The flight does not exist.
      
      //Finds available flights from airport "ABC", to airport "DEF".
      smgr.findAvailableFlights("ABC", "DEF");
      
      
      //Finds no available flights from "ABC" to "GHI".
      System.out.println(smgr.findAvailableFlights("ABC", "GHI"));      
      //Finds no available flights with an invalid destination.
      System.out.println(smgr.findAvailableFlights("ABC", "ABC")); 
      
      //We now book seats for WJET
      smgr.bookSeat("WJET", "123", 7, 'A');
      //Booking seats for AC based on random numbers.
      for(int i=1; i<=15; i++)
         for(int j=65; j<=70; j++)
            if((int)(2*Math.random())==1)
               smgr.bookSeat("AC", "113", i, (char)j);  
      
      //Invalid Seat bookings     
      smgr.bookSeat("UD", "200", 3, 'B'); //Invalid flight number
      smgr.bookSeat("WJET", "666", 13, 'A'); //The flight has no seats
      smgr.bookSeat("AC", "113", 1, 'G'); //The row position is out of bounds.
      smgr.bookSeat("WJET", "123", 7, 'A');  //This seat has already been booked. 
                      
      //Prints the current status of the flight.      
      smgr.displaySystemDetails();
   }
}   