/*CSCI 1101 – Assignment 3 – SystemManager.java
This program will coordinate the Airport, Airline, Flight, and Seat classes, 
and keep track of all occuring flights. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

import java.util.ArrayList;
public class SystemManager
{
   //This object will keep track of matching the airports and airlines, for various flights.  
   ArrayList<Airport> airport;
   ArrayList<Airline> airline;
   ArrayList<Flight> flights;
   
   //The no-args constructor initializes the ArrayLists (initially empty).
   public SystemManager()
   {
      airport = new ArrayList<Airport>();
      airline = new ArrayList<Airline>();
      flights = new ArrayList<Flight>();
   }
   
   //This method will create a new airport object if the name is unique and only has 3 capital letters.      
   public void createAirport(String n)
   {
      //This variable will determine whether the name is unique
      //The program searches through the ArrayList of airports for the name "n".
      //If the input matches a previously established name, the variable is "false".
      boolean nameIsUnique = true;
      for(int i=0; i<airport.size(); i++)
         if(airport.get(i).getName().equals(n))
            nameIsUnique = false;
            
      //This will test the name for characters and uniqueness.      
      if(Airport.hasGoodChars(n) && nameIsUnique)
         airport.add(new Airport(n));     
      else if(!Airport.hasGoodChars(n))
         System.out.println("The name, \"" + n + "\", must have 3 capital alphabetic characters.");
      //The airport name is not unique.
      else 
         System.out.println("The name, \"" + n + "\", cannot be listed twice.");        
   }
   
   //This method will create a new airline object if the name is unique and has fewer than 6 characters.      
   public void createAirline(String n)
   {
      //This variable will determine whether the name is unique
      //The program searches through the ArrayList of airlines for the name "n".
      //If the input matches a previously established name, the variable is "false".
      boolean nameIsUnique = true;
      for(int i=0; i<airline.size(); i++)
         if(airline.get(i).getName().equals(n))
            nameIsUnique = false;
            
      //This will test the name for characters and uniqueness.      
      if(n.length()<6 && nameIsUnique)
         airline.add(new Airline(n));
      else if(!(n.length()<6))
         System.out.println("The name, \"" + n + "\", must have fewer than 6 characters.");   
      else 
         System.out.println("The name, \"" + n + "\", cannot be listed twice.");        
   }
   
   //This method will add a new flight object, 
   //specifing the name, airline name, origin and destination airports, orig, and dest, respectively and ID.
   public void createFlight(String aname, String orig, String dest, String id)
   {
      //This will determine whether the flight ID is unique.
      //This will prevent flight mix-up by searching through the flights array for any matches.
      boolean idIsUnique = true;
      for(int i=0; i<flights.size(); i++)
         if(flights.get(i).getID().equals(id) && flights.get(i).getAirline().getName().equals(aname))
            idIsUnique = false;
      
      //This loop will determine whether the airline name is defined in the airline ArrayList.
      boolean foundAirline = false;
      for(int j=0; j<airline.size(); j++)
         if(airline.get(j).getName().equals(aname))
             foundAirline = true;
      
      //This loop will determine whether the destination or arrival airports are defined.
      boolean foundOrigAirports = false;
      boolean foundDestAirports = false;
      for(int k=0; k<airport.size(); k++)
      {
         if(airport.get(k).getName().equals(orig)) 
            foundOrigAirports = true;
         else if(airport.get(k).getName().equals(dest))
            foundDestAirports = true;   
      }
           
      //The origin and destination airports must be different, and the flight IDs cannot be listed twice.
      if(!orig.equals(dest) && foundAirline && foundOrigAirports && foundDestAirports && idIsUnique)
         flights.add(new Flight(aname, orig, dest, id));
      //The origin matches the destination.
      else if(orig.equals(dest))
         System.out.println("The origin airport, " + orig + ", and destination airport, " + dest + ", must be different.");      
      //The airline is not found.
      else if(!foundAirline)
         System.out.println("The airline, \"" + aname + "\", must be previously defined.");
      //The origin or destination airports are not found.
      else if(!foundOrigAirports || !foundDestAirports)
         System.out.println("The airports, \"" + orig + "\", and \"" + dest + "\", must both be defined.");   
      else 
         System.out.println("The flight ID, \"" + id + "\", cannot be listed twice under airline, " + aname +".");              
   }
   
   //Creates seats with the given number of rows for a flight with identifier flID, associated with an airline, air
   public void createSeats(String air, String flID, int rows)
   {
      //We find the element of "flights" whose flight ID and airline name both match.
      int index = -1;
      //This involves searching the flights ArrayList.
      for(int i=0; i<flights.size(); i++)
         if(flights.get(i).getID().equals(flID) && flights.get(i).getAirline().getName().equals(air))
            index = i;
            
      //We now make a seat array with the specified number of rows, and 6 positions per row.      
      Seat[][] seats = new Seat[rows][6];
      for(int i=0; i<seats.length; i++)
         for(int j=0; j<seats[i].length; j++)
            //Creates a new seat object in each array element.
            //Adding one converts from index notation to row notation.
            //The row position is converted to an ascii value to correspond to the letters "A" to "F".
            seats[i][j] = new Seat(i+1,(char)(j+65));
      
      //We now match the desired flight with the array of seats, if this action hasn't already been done.
      if(index!=-1)
      {
         //The seats for this flight are not previously defined, so we now set the seats.
         if(flights.get(index).getSeats()==null)
            flights.get(index).setSeats(seats);
         else
            System.out.println("The flight with ID, \"" + flID + "\", at airline, \"" + air + "\" already has seats.");
      }         
         
      //The desired flight was not found.
      else
         System.out.println("No flight with ID, \"" + flID + "\", at airline, \"" + air + "\", was found.");
   }
   
   //This method finds all flights from airport orig to airport dest.
   public ArrayList<Flight> findAvailableFlights(String orig, String dest)
   {
      //Stores the flights that meet the specifications.
      ArrayList<Flight> availableFlights = new ArrayList<Flight>();
      //The origin and destination airports must be different.
      if(!orig.equals(dest))
      {
         //Searches the flights array for flights whose origin and destination airport names match. 
         for(int i=0; i<flights.size(); i++)
            if(flights.get(i).getOrigAirport().getName().equals(orig) 
            && flights.get(i).getDestAirport().getName().equals(dest))
               availableFlights.add(flights.get(i));
                    
         //There were no flights found with the origin and destination airports.      
         if(availableFlights.size()!=0)
         {
            System.out.println("\n");
            System.out.println(availableFlights.size() + " available flights from \"" + orig + "\" to \"" + dest + "\": ");
            for(int j=0; j<availableFlights.size(); j++)
               System.out.println("\n#" + (j+1) + availableFlights.get(j));
         }      
         else
            System.out.println("There are no available flights from \"" + orig + "\" to \"" + dest + "\".");
      }
      //The origin and destination airports match, which is not allowed.
      else
         System.out.println("The origin airport, \"" + orig + "\", and destination airports, \"" + dest + "\", must be different.");
         
      return availableFlights;                  
   }
   
   //This method books seat in given row and column on flight fl of airline air,	
   //if	that	particular	seat	is	still	available.   
   public void bookSeat(String air, String fl, int row, char col)
   {
      //We now search the flights Arraylist for the flight that contains the airline name, and the flight ID.
      int flightIndex = -1;
      for(int i=0; i<flights.size(); i++)
         //The flight must have a matching airline name and flight ID.
         if(flights.get(i).getAirline().getName().equals(air) && flights.get(i).getID().equals(fl))
            flightIndex = i;
      
      //The correct flight was found, so we now book the right seat.
      if(flightIndex!=-1)
      {
         //Makes sure the flight has seats.
         if(flights.get(flightIndex).getSeats()!=null)
         {        
            //The row number must be within a suitable row number of that particular flight.
            if(row >= 1 && row <= flights.get(flightIndex).getSeats().length
            && col >= (char)65 && col <=(char)70)
            {
               //We check whether the seat in question is booked.
               Seat thisSeat = flights.get(flightIndex).getSeats()[row-1][(int)(col-65)];
               
               //The seat is available
               if(!thisSeat.isBooked())
                  thisSeat.book();               
               
               //The seat is booked.   
               else
                  System.out.println("The seat at row " + row + " and position " + col +
                  " is already occupied for flight " + fl + " at airline " + air + ".");
            }//end if (row is in bounds)
            else
               System.out.println("Row " + row + " and column number " + col + " is invalid for flight " + fl + " at airline " + air + ".");
         }
         //Seat making error.
         else
            System.out.println("The flight with airline \"" + air + "\" and ID \"" + fl + "\" is unavailable.");      
      }//End if (the flight was found)      
      
      //The correct flight ID or airline was not found.
      else
         System.out.println("The flight with airline \"" + air + "\" and ID \"" + fl + "\" is invalid");
   }                                  
      
   //This method displays attribute values for all objects in the system.
   public void displaySystemDetails()
   {
      //Displaying Airports, airlines, and flights.
      System.out.println("\n");
      System.out.println("SYSTEM STATUS:");
      System.out.println("Airports: " + airport);
      System.out.println("Airlines: " + airline);
      System.out.println(flights.size() + " flights:");
      System.out.println();
      for(int i=0; i<flights.size(); i++)
         System.out.println("#" + (i+1) + flights.get(i));
   }                                  
}  
                   
            
   